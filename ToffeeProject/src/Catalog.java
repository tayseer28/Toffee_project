
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Catalog {

    private static int Statid;
    private ArrayList<Item> items;

    static {
        Statid = 2021;
    }


    public Catalog() {
        items = new ArrayList<>();
    }

    public Catalog(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItem(Item item){

       //System.out.println( "StatID" + Statid);

        item.setId(Statid);
        Statid++;
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
        readItems();
        for (int i = 0; i < items.size(); i++) {
            System.out.println( "ID: "+ items.get(i).getId() +" name: "  + items.get(i).getName()+ " status: " + items.get(i).getStatus() + " price:  " + items.get(i).getPrice() + " brand:  " + items.get(i).getBrand());

        }
    }


    public void readItems(){


        File file = new File("items.txt");
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null){
                Item it = new Item();
                 it.setName(st);
                for(int i = 0; i < 4; i++){
                    st = br.readLine();
                    if(i == 0){
                        it.setDescription(st);
                    }
                    else if(i == 1){
                        it.setStatus(st);
                    }
                    else if(i == 2){
                        it.setPrice(Double.parseDouble(st));
                    }
                    else if(i == 3){
                        it.setBrand(st);
                    }
                }
                addItem(it);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Item getItemByID(int id){
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getId() == id){
                return items.get(i);
            }
        }
        return null;
    }

}
