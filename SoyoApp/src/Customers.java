import java.util.ArrayList;
import java.util.List;

public class Customers {

    String name;
    String contact, location;
    String customer_id;
    Database database = new Database();

    public boolean add_customer() {
        
        if (name != null && contact != null && location != null) {
            if (name.length() > 0 && contact.length() > 0 && location.length() > 0) {
                return database.addCustomer(name, contact, location);
            } else {
                System.out.println("Sorry, provide all details to continue");
            }
        }
        else {
            System.out.println("Sorry, provide all details to continue");
        }
        return false;
    }

    public void welcome() {
        System.out.println("Hi " + name + ", Welcome to Soyo's Stores");
    }


    public void showCustomers() {
        ArrayList<String[]> customers = database.getCustomers();
        System.out.println("MY CUSTOMERS DATABASE - TOTAL: " + customers.size());
        System.out.println("################################################");
        System.out.println("No. - CustomerID - Names - Contacts - Location");
        System.out.println("################################################");

        if(customers.size() > 0) {
            int i = 1;
            for (String[] customer : customers) {
                customer_id = customer[0];
                name = customer[1];
                contact = customer[2];
                location = customer[3];
                System.out.println(i + ". " + customer_id + " - " + name + " - " + contact + " - " + location);
                i++;
            }
        }
        else {
            System.out.println("No Customer Added yet");
        }
    }
}
