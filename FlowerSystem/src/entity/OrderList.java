/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author User
 */
public class OrderList {
    private List<Order> orderList = new ArrayList<>();
    private Date pickUpDate;
    private String collectMethod;
    private String DAddress;
    private int count = 0;
    private double totalPrice = 0;
    private String custId;
   
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    public OrderList(List<Order> orderList, Date pickUpDate, String collectMethod, String DAddress,String custId) {
        this.orderList = orderList;
        this.pickUpDate = pickUpDate;
        this.collectMethod = collectMethod;
        this.DAddress = DAddress;    
        this.custId = custId;
        count++;
    }

    public String getCustId() {
        return custId;
    }


    

    public List<Order> getOrderList() {
        return orderList;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public String getCollectMethod() {
        return collectMethod;
    }

    public String getDAddress() {
        return DAddress;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

 

  

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public void setCollectMethod(String collectMethod) {
        this.collectMethod = collectMethod;
    }

    public void setDAddress(String DAddress) {
        this.DAddress = DAddress;
    }
    
    public String arString()
    {
        String s="";
        for(Order o: orderList)
        {
            s += o;
        }
        return s;
    }
   
    public double calcTotalPrice(){
        totalPrice=0;
        for(Order o : orderList){
            
            totalPrice += o.calculatePrice();
        }        
        return totalPrice;
    }
    
    public double calcAllOrder(List<OrderList> orderList)
    {
        double allTotal=0;
        for(OrderList ol: orderList)
        {
            allTotal += ol.calcTotalPrice();
        }
        return allTotal;
    }
    
    @Override
    public String toString() {
//        for(Order creditLimit : orderList){
//            if(creditLimit.calculatePrice() > 3000){
//                return "You already over your monthly credit limit!!";
//                
//            }
//        }
        return  "\nOrder"+ count + arString() + "\nPick Up Date=" + formatter.format(pickUpDate) + 
                        "\nCollect Method=" +collectMethod + "\nReceiver=" + DAddress +
                        "\nTotal Price = RM ";
    }
    
    
    
}
