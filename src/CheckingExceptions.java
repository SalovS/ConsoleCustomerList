import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckingExceptions {
    private String command = "help";
    public String[] checking(String text){
        String[] tokens = new String[4];
        tokens[0] = getCommand(text);
        if(!tokens[0].contains("add") && !tokens[0].contains("remove")){
            return tokens;
        }
        tokens[1] = getName(text);
        if(tokens[0].contains("remove")){
            return tokens;
        }
        tokens[2] = getEmail(text);
        tokens[3] = getPhone(text);
        for(int i = 0; i < 4; i++){
            if(tokens[i] == ""){
                tokens[0] = command;
            }
        }
        tokens[1] += " " + tokens[2] + " " + tokens[3];
        return tokens;
    }

    private String getCommand(String text){
        Pattern pattern = Pattern.compile("^[a-z]+");
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()){
            return matcher.group();
        }
        getException("Команда указана неверно");
        return command;
    }

    private String getName(String text){
        String name = text.replace(getCommand(text),"").trim();
        Pattern pattern = Pattern.compile("\\w+\\s+\\w+\\s+");
        Matcher matcher = pattern.matcher(name);
        if(matcher.find()){
            return matcher.group();
        }
        getException("Неверно указано имя");
        return "";
    }

    private String getEmail(String text){
        Pattern pattern = Pattern.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}");
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()){
            return matcher.group();
        }
        getException("Неверно указан электронный адрес");
        return "";
    }

    private String getPhone(String text){
        Pattern pattern = Pattern.compile("(\\s*)?(\\+)?([- _():=]?\\d[- _():=]?){10,14}(\\s*)?$");
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()){
            return matcher.group().replaceAll("[- _:=()]","");
        }
        getException("Номер телефона указан неверно");
        return "";
    }

    private void getException(String text){
        try {
            throw new ConsoleException(text);
        } catch (ConsoleException e) {
        }
    }
}
