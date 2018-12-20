/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import Interface.ArrayList;
import Interface.ListInterface;
import java.text.SimpleDateFormat;
//import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
//import java.util.List;
/**
 *
 * @author User
 */
public class OrderList {
    private ListInterface<Order> orderList = new ArrayList<>();
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
     Iterator<Order> iterator = orderList.getIterator();
     
   
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    public OrderList(ListInterface<Order> orderList,String id, Date pickUpDate, String collectMethod,String area ,String DAddress,String custId,String status) {
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

    public ListInterface<Order> getOrderList() {
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

    public void setOrderList(ListInterface<Order> orderList) {
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
        
        while(iterator.hasNext())
        {
            s += iterator.next();
        }
        return s;
    }
   
    public double calcTotalPrice(ListInterface<Order> orderArr){
        totalPrice=0;
     for(Iterator<Order> i = orderArr.getIterator(); i.hasNext(); ) {
            totalPrice += iterator.next().calculatePrice();
        }      
        
        return totalPrice;
    }
    
    public double calcAllOrder(ListInterface<OrderList> orderList, ListInterface<Order> orderArr)
    {
        
        Iterator<OrderList> iterator = orderList.getIterator();
        allTotal=0;
        while(iterator.hasNext()){
            allTotal += iterator.next().calcTotalPrice(orderArr);
        }
        return allTotal;
    }
    
    public double calcAllOrder(ListInterface<OrderList> orderList, String customerId)
    {
         Iterator<OrderList> iterator = orderList.getIterator();
        allTotal=0;
        for(int i = 0 ; i < orderList.size();i++){
            if(customerId.equals(orderList.get(i).getCustId())){
            allTotal += orderList.get(i).calcTotalPrice(orderList.get(i).getOrderList());
            
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
