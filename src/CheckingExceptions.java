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
        return tokens;
    }

    private String getCommand(String text){
        Pattern pattern = Pattern.compile("^[a-z]+");
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()){
            return matcher.group();
        }
        try {
            throw new ConsoleException("Команда указана неверно");
        } catch (ConsoleException e) {
            return command;
        }
    }

    private String getName(String text){
        String name = text.replace(getCommand(text),"").trim();
        Pattern pattern = Pattern.compile("[[\\w+]\\s+]+");
        Matcher matcher = pattern.matcher(name);
        if(matcher.find()){
            return matcher.group();
        }
        try{
            throw new ConsoleException("Не указано имя");
        }catch(ConsoleException e){
            return "";
        }
    }

    private String getEmail(String text){
        Pattern pattern = Pattern.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}");
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()){
            return matcher.group();
        }try{
            throw new ConsoleException("Неверно указан электронный адрес");
        }catch(ConsoleException e){
            return "";
        }
    }

    private String getPhone(String text){
        Pattern pattern = Pattern.compile("(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?$");
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()){
            return matcher.group().replaceAll("[- _:=+()]","");
        }
        try {
            throw new ConsoleException("Номер телефона указан неверно");
        } catch (ConsoleException e) {
            return "";
        }
    }
}
