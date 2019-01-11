/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

//import Interface.ArrayList;
//import Interface.List;
import Catalog_Order.doubleLinked;
import Catalog_Order.doubleLinkedInterface;
import custMaintenanceNPayment.mLinked;
import custMaintenanceNPayment.mLinkedInterface;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/**
 *
 * @author User
 */
public class OrderList {
    private doubleLinkedInterface<Order> orderList = new doubleLinked<>();
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
    // Iterator<Order> iterator = orderList.getIterator();
     
   
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    public OrderList(doubleLinkedInterface<Order> orderList,String id, Date pickUpDate, String collectMethod,String area ,String DAddress,String custId,String status) {
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

    public doubleLinkedInterface<Order> getOrderList() {
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

    public void setOrderList(doubleLinkedInterface<Order> orderList) {
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
        
        for(int i=0;i<orderList.size();i++)
        {
            s += orderList.get(i);
        }
        return s;
    }
   
    public double calcTotalPrice(doubleLinkedInterface<Order> orderArr){
        totalPrice=0;
     for(int i = 0 ; i < orderArr.size();i++) {
            totalPrice += orderArr.get(i).calculatePrice();
        }      
        
        return totalPrice;
    }
    
    public double calcAllOrder(doubleLinkedInterface<OrderList> orderList, doubleLinkedInterface<Order> orderArr)
    {
        
      //  Iterator<OrderList> iterator = orderList.getIterator();
        allTotal=0;
        for(int i=0;i<orderList.size();i++){
            allTotal += orderList.get(i).calcTotalPrice(orderArr);
        }
        return allTotal;
    }
    
    public double calcAllOrder(doubleLinkedInterface<OrderList> orderList, String customerId)
    {
     //    Iterator<OrderList> iterator = orderList.getIterator();
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
