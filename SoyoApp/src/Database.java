import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Database
{
    String customerDB = "customers.txt";
    public Database() {
        try {
            File myObj = new File(customerDB);
            if (myObj.createNewFile()) {
                System.out.println("Database Created: " + myObj.getName());
            }
        } catch (IOException e) {
            System.out.println("Error with Database");
            e.printStackTrace();
        }
    }

    public boolean addCustomer(String name, String contact, String location) {
        int customer_id;
        try {
            FileWriter myWriter;
            if(totalCustomers() == 0) {
                customer_id = 1;
                myWriter = new FileWriter(customerDB);
            }
            else {
                customer_id = (int)totalCustomers() + 1;
                myWriter = new FileWriter(customerDB, true);
            }

            myWriter.write(customer_id + "<>" + name + "<>" + contact + "<>" + location);
            myWriter.write("\r\n");     // save each customer on a new line
            myWriter.close();
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return false;
    }

    public long totalCustomers() {
        File file = new File(customerDB);
        long lines = 0;
        try(LineNumberReader lnr = new LineNumberReader(new FileReader(file))) {
            while (lnr.readLine() != null)
                lines = lnr.getLineNumber();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Total Customers: " + lines);
        return lines;
    }
    public ArrayList<String[]> getCustomers() {
        ArrayList<String[]> list = new ArrayList<>();
        try{
            File myObj = new File(customerDB);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().trim();
                if(data.length() > 0) {
                    list.add(data.split("<>"));
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return list;
    }


}