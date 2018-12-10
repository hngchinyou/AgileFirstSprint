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
    private String id;
    private Date pickUpDate;
    private String collectMethod;
    private String DAddress;
    private int count = 0;
    private double totalPrice = 0;
    private String custId;
    private static double allTotal=0;
    private String status;
    private String area; 
   
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    public OrderList(List<Order> orderList,String id, Date pickUpDate, String collectMethod,String area ,String DAddress,String custId,String status) {
        this.orderList = orderList;
        this.id = id;
        this.pickUpDate = pickUpDate;
        this.collectMethod = collectMethod;
        this.area = area ; 
        this.DAddress = DAddress;    
        this.custId = custId;
        this.status = status;
  
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    
    public String getStatus() {
        return status;
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

    public void setStatus(String status) {
        this.status = status;
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
   
    public double calcTotalPrice(List<Order> orderArr){
        totalPrice=0;
        for(Order o : orderArr){
            totalPrice += o.calculatePrice();
        }      
        
        return totalPrice;
    }
    
    public double calcAllOrder(List<OrderList> orderList, List<Order> orderArr)
    {
        allTotal=0;
        for(OrderList ol: orderList)
        {
            allTotal += ol.calcTotalPrice(orderArr);
        }
        return allTotal;
    }
    
    public double calcAllOrder(List<OrderList> orderList, String customerId)
    {
        allTotal=0;
        for(OrderList ol: orderList)
        {
            if(customerId.equals(ol.getCustId())){
            allTotal += ol.calcTotalPrice(ol.getOrderList());
            
            }
        }
        
        return allTotal;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getAllTotal() {
        return allTotal;
    }

    public void setAllTotal(double allTotal) {
        this.allTotal = allTotal;
    }
    
    
    

    
    public String toString(int count ) {

        return  "\n*************************\nOrder "+ count + "\nCustomer Id: " + custId + arString() + "\nOrder Id: " + id + 
                "\n\nPick Up Date: " + formatter.format(pickUpDate) + 
                "\nCollect Method: " + collectMethod + "\nAddress: " + DAddress +", " + area  +"\nStatus= " + status +
                "\n*************************\n";
    }
    
    
    
    
}
