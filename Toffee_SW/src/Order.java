
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class
import java.io.*;


import java.util.ArrayList;
import java.util.Scanner;


public class Order {
    private LocalDateTime dateOfCheckout;
    private int ID;
    private Cart cart;
    private double totalPrice;
    private static int StatID;

    private Item item;

    static {
        StatID = 202100;
    }
    public Order(Cart cart){
        this.cart = cart;
        totalPrice = cart.totalPrice();
        this.dateOfCheckout = LocalDateTime.now();
        this.ID = StatID;
        StatID++;
    }

    public void display(){
        System.out.println("Order ID: " + ID);
        System.out.println("Date of checkout: " + dateOfCheckout);
        System.out.println("Total price: " + totalPrice);
        System.out.println("User account: " + cart.getUserAccount().getUserName());
        System.out.println("Items: ");
        for (int i = 0; i < cart.getItems().size(); i++) {
            System.out.println(cart.getItems().get(i).getName());
        }
    }
    public LocalDateTime getDateOfCheckout() {
        return dateOfCheckout;
    }

    public void setDateOfCheckout(LocalDateTime dateOfCheckout) {
        this.dateOfCheckout = LocalDateTime.now();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public static int getStatID() {
        return StatID;
    }

    public static void setStatID(int statID) {
        StatID = statID;
    }

    public void writeToFile()
    {

        try (FileWriter myWriter = new FileWriter("orders.txt", true);

            BufferedWriter bw = new BufferedWriter(myWriter)){
            String fileName = "src\\Orders.txt";
            String data ="customer ID: " + cart.getUserAccount().getId() + " Order ID: " + ID + "\nDate of checkout: " + dateOfCheckout + "\nTotal price: " + totalPrice + "\nUser account: " + cart.userAccount.getUserName() + "\nItems: ";
            for (int i = 0; i < cart.getItems().size(); i++) {
                data += cart.getItems().get(i).getName() + "\n";
            }
            bw.write(data);
        }

        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void placeOrder(){
        display();
        System.out.println("do you want to place order? (y/n)");
        Scanner sc = new Scanner(System.in);
        char choice = sc.next().charAt(0);
        if(choice == 'y'){
            writeToFile();
            System.out.println("order placed successfully");
        }
        else{
            System.out.println("order not placed");
        }
    }
}
