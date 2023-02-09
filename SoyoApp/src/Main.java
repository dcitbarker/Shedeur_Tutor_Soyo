import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {

        Customers customers = new Customers();
        customers.showCustomers();      // show existing customers

        Scanner scanner = new Scanner(System.in);

        while (false) {
            System.out.print("Enter Customer Name: ");
            customers.name = scanner.nextLine();

            if (customers.name.equalsIgnoreCase("x")) {
                break;
            }

            System.out.print("Enter Customer Contact Number: ");
            customers.contact = scanner.nextLine();

            System.out.print("Enter Customer Location: ");
            customers.location = scanner.nextLine();

            if (customers.add_customer()) {
                customers.welcome();
                customers.showCustomers();      // reload the table
            }
        }


    }
}
