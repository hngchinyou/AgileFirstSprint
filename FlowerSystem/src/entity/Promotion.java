/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import custMaintenanceNPayment.mLinkedInterface;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Promotion {
    private String productname,description,id;
    private double price;
    private int amount;
    private mLinkedInterface<Flower2> fList;

    public Promotion(String id, String productname, String description,double price, int amount) {
        this.productname = productname;
        this.description = description;
        this.id = id;
        this.price = price;
        this.amount = amount;
    }

    public Promotion(String productname, String description, String id, double price, int amount, mLinkedInterface<Flower2> fList) {
        this.productname = productname;
        this.description = description;
        this.id = id;
        this.price = price;
        this.amount = amount;
        this.fList = fList;
    }

    public mLinkedInterface<Flower2> getfList() {
        return fList;
    }

    public void setfList(mLinkedInterface<Flower2> fList) {
        this.fList = fList;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return 
                "==========================" + "\n" + 
                "Promotion ID:" + id + "\n" +
                "Promotion Name:" + productname + "\n" +  
                "Description:" + description + "\n" + 
                "Price: RM " + price + "\n" + 
                "Quantity:" + amount + "\n" + 
                "==========================";
    }
    
    
}
