/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package catalog;

/**
 *
 * @author RTX
 */
public class Item {
    private String name ;
    private String description;
    private String status;
    private String catalog;

    private int id;
    private static int Statid;
    private double price;
    private Brand b;

    static {
        Statid = 2021;
    }

    public Item(String name, String description, String status, String catalog, double price) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.catalog = catalog;
        this.b = new Brand();
        this.price = price;
        id = Statid;
        Statid++;

    }

    public Item() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void discountByItem(double percentage){
        double disc = this.price * percentage;
        this.price = disc;
    }


}
