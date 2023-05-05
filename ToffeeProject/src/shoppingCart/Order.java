package shoppingCart;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

import catalog.Item;
import java.util.ArrayList;

public class Order {

    private LocalDateTime dateOfCheckout;
    private int ID;
    private static int StatID;



    private Item item;

    static {
        StatID = 202100;
    }

   /* public Order(LocalDateTime dateOfCheckout, double totalPrice, String name, String description, String status, String catalog, double price) {
        this.dateOfCheckout = dateOfCheckout;
        this.ID = ID;
        this.totalPrice = totalPrice;
        this.item = new Item(name,  description,  status, catalog,  price);
    }*/
    public Order(LocalDateTime dateOfCheckout, Item item) {
        this.item = item;
        this.dateOfCheckout = LocalDateTime.now();
        this.ID = StatID;
        StatID++;

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



    public void placeOrder(){

    }
}
