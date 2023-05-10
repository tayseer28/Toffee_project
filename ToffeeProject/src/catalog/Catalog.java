package catalog;
import java.util.ArrayList;

public class Catalog {

    private ArrayList<Item> items;

    public Catalog(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItem(Item item){
        items.add(item);

    }


    public Item searchBYItem(String name){
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getName().equals(name)){
                return items.get(i);
            }
        }
        return null;
    }
    public void filterByPrice(double startPrice, double endPrice){
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getPrice() >= startPrice && items.get(i).getPrice() <= endPrice){
                System.out.println(items.get(i).getName());
            }
        }
    }
    public void display(){
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).getName());
        }
    }

}
