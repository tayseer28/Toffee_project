import catalog.Item;


public class Main {
    public static void main(String[] args) {

        Item item = new Item("sdz", "sdz", "sdz", "sdz", 12.0);
        Item item2 = new Item("sdz", "sdz", "sdz", "sdz", 12.0);
        System.out.println(item.getId());
        System.out.println(item2.getId());
    }



}