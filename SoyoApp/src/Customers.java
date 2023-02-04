public class Customers {
    String name;
    String contact,location,purchase;
    int customer_id = 6464;

    public String add_customer(String name,String contact){
        this.name = name;
        this.contact = contact;
        System.out.println("Customer's name is " + this.name + " and number is: " + this.contact);

        return "done";
    }




}
