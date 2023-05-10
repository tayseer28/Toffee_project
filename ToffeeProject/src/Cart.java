
import java.util.ArrayList;
import java.util.Scanner;

public class Cart {

    private ArrayList<Item> items;
    private Catalog catalog;

    private Address address;


    public Cart(Catalog catalog){
        this.catalog = catalog;
        items = new ArrayList<>();
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
}
