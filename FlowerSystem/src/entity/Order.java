/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author hanxin
 */
public class Order {
    private String orderNum;
    private int quantity;
   private Date date;
    private double price = 0.0;
   // private double subPrice = 0.0;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    public Order() {
        super();
    }



    public Order(String orderNum, int quantity, Date date,double price) {
        this.orderNum = orderNum;
        this.quantity = quantity;
        this.date = date;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public int getQuantity() {
        return quantity;
    }



    public Date getDate() {
        return date;
    }

    public void setPrice(double price) {
        this.price = price;
    }





    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDate(Date date) {
        this.date = date;
    }

     public double calculatePrice(){
        double subPrice = 0.0;
        subPrice = price * quantity;
        
        return subPrice;
    }
    @Override
    public String toString() {
        return "\n\n=========================\nOrder Num: " + orderNum + "\nQuantity: " + quantity + "\nSub Price: " + String.format("%.2f", calculatePrice()) + "\n=========================";
    }
    

  
   
    
}
