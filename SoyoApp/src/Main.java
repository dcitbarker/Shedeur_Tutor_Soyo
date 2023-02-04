public class Main {
    public static void main(String[] arg) {
        
        Customers customers = new Customers();
        String add = customers.add_customer("Soyo", "0552346355");

        System.out.println(customers.customer_id);

    }
}
