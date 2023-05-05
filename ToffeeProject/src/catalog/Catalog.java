package catalog;
import java.util.ArrayList;

public class Catalog {

    private ArrayList<Item> items;
    private ArrayList<Category> categories;

    public Catalog(ArrayList<Category> categories, ArrayList<Item> items) {

        this.categories =  categories;
        this.items = items;
    }

    public void addItem(Item item){
        items.add(item);

    }
    public void addCategory(Category category){

        categories.add(category);

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

    public void filterByCategory(String name){
        for (int i = 0; i < categories.size(); i++) {
            if(categories.get(i).getName().equals(name)){
                for (int j = 0; j < categories.get(i).getItems().size(); j++) {
                    System.out.println(categories.get(i).getItems().get(j).getName());
                }
            }
        }
    }




    public void filterByName(){

    }

    public void display(){
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).getName());
        }
    }

}
