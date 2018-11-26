package entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Flower2 {
    private String flowername,description, type, id;
    private double price;
    private int amount;

    public Flower2(String id, String flowername, String description, String type, double price, int amount) {
        this.id = id;
        this.flowername = flowername;
        this.description = description;
        this.type = type;
        this.price = price;
        this.amount = amount;
    }

    public Flower2() {
    }

    @Override
    public String toString() {
        return 
                "==========================" + "\n" + 
                "ID:" + id + "\n" +
                "Flower Name:" + flowername + "\n" +  
                "Description:" + description + "\n" + 
                "Type:" + type + "\n" +
                "Price: RM " + price + "\n" + 
                "Quantity:" + amount + "\n" + 
                "==========================" +
                "\n" + "\n" ;
                
    }

    public String getFlowername() {
        return flowername;
    }

    public void setFlowername(String flowername) {
        this.flowername = flowername;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
   
   
}
