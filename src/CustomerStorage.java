import java.util.HashMap;

public class CustomerStorage
{
    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String[] data)
    {
        storage.put(data[1], new Customer(data[1], data[3], data[2]));
    }

    public void listCustomers()
    {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String[] data)
    {
        storage.remove(data[1]);
    }

    public int getCount()
    {
        return storage.size();
    }
}