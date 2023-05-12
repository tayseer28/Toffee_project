/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.*;


/**
 *
 * @author RTX
 */
public class Item {
    private String name ;
    private String description;
    private String status;
    private int id;

    private String brand;
    private double price;

    public Item(String name, String description, String status, double price, String brand) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.brand = brand;
        this.price = price;


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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
