package catalog;


import java.util.ArrayList;

/**
 *
 * @author RTX
 */
public class Category {
    private String name;
    private String Desciption;
    private int id;
    private static int Statid;
    private ArrayList<Item> items;

    static {
        Statid = 202100;
    }

    public Category(String name, String Desciption, ArrayList<Item> items) {
        this.name = name;
        this.Desciption = Desciption;
        this.items = items;
        id = Statid;
        Statid++;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesciption() {
        return Desciption;
    }

    public void setDesciption(String Desciption) {
        this.Desciption = Desciption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void dicountByCategory(double percentage) {
        for (int i = 0; i < items.size(); i++) {
            double disc = items.get(i).getPrice() * percentage;
            items.get(i).setPrice(disc);
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}

