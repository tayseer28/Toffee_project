
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cart {

    private ArrayList<Item> items;
    private Catalog catalog;

    private Address address;
    UserAccount userAccount;

    public Cart() {
        items = new ArrayList<>();
        catalog = new Catalog();
        address = new Address();
        userAccount = new UserAccount();
    }
    public Cart(Catalog catalog, UserAccount userAccount){
        this.catalog = catalog;
        items = new ArrayList<>();
        this.userAccount = userAccount;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
//    public void addOrder(Order o){
//        order.add(o);
//    }

    public void addItemToCart()
    {
        int id;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter id of item you want to add to cart");
        id = sc.nextInt();
        Item item = catalog.getItemByID(id);
        items.add(item);

    }
    public double totalPrice(){
        double total = 0;
        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getPrice();
        }
        return total;

    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    //    public void writeToFile()
//    {
//        try (FileWriter myWriter = new FileWriter("cart.txt", true);
//
//             BufferedWriter bw = new BufferedWriter(myWriter)){
//            String fileName = "src\\Orders.txt";
//            String data = "customer ID: " + userAccount.getId() + "\nTotal price: " + totalPrice() + "\nUser account: " + userAccount.getUserName() + "\nItems: ";
//            for (int i = 0; i < items.size(); i++) {
//                data += items.get(i).getName() + "\n";
//            }
//            bw.write(data);
//        }
//        catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//    }
//    public void readFromFile()
//    {
//        File file = new File("cart.txt");
//        try {
//
//            Scanner sc = new Scanner(file);
//            while (sc.hasNextLine()) {
//                String data = sc.nextLine();
//                System.out.println(data);
//            }
//        }
//        catch (IOException e) {
//        System.out.println("An error occurred.");
//        e.printStackTrace();
//        }
//    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public void display(){
        System.out.println("Total price: " + totalPrice());
        System.out.println("User account: " + userAccount.getUserName());
        System.out.println("Items: ");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).getName());
        }
    }
}
