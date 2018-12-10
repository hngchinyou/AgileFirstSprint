/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class OrderListTest {

    private String id = "Or0001";
    private Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    //Order  o = new Order(orderNum, 1, date, 1.0);
    List<Order> orderList = new ArrayList<>();
    
    OrderList ol = new OrderList(orderList, id, date, "Delivery", "Setapak", "abc", "Cn0001", "Processing");

    public OrderListTest() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of setArea method, of class OrderList.
     */
    @Test
    public void testSetArea() {
        System.out.println("setArea");
        String area = "Setapak";
        //OrderList instance = null;
        ol.setArea(area);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getArea method, of class OrderList.
     */
    @Test
    public void testGetArea() {
        System.out.println("getArea");
        //OrderList instance = null;
        String expResult = "Setapak";
        String result = ol.getArea();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class OrderList.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        // OrderList instance = null;
        String expResult = "Or0001";
        String result = ol.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //  fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class OrderList.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "Or0001";
        //OrderList instance = null;
        ol.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class OrderList.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        //OrderList instance = null;
        String expResult = "Processing";
        String result = ol.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getCustId method, of class OrderList.
     */
    @Test
    public void testGetCustId() {
        System.out.println("getCustId");
        // OrderList instance = null;
        String expResult = "Cn0001";
        String result = ol.getCustId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getOrderList method, of class OrderList.
     */
    @Test
    public void testGetOrderList() {
        System.out.println("getOrderList");
       // OrderList instance = null;
        List<Order> expResult = new ArrayList<>();
        List<Order> result = ol.getOrderList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //   fail("The test case is a prototype.");
    }

    /**
     * Test of getPickUpDate method, of class OrderList.
     */
    @Test
    public void testGetPickUpDate() {
        System.out.println("getPickUpDate");
        // OrderList instance = null;
        Date expResult = new Date();
        Date result = new Date();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCollectMethod method, of class OrderList.
     */
    @Test
    public void testGetCollectMethod() {
        System.out.println("getCollectMethod");
        // OrderList instance = null;
        String expResult = "Delivery";
        String result = ol.getCollectMethod();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDAddress method, of class OrderList.
     */
    @Test
    public void testGetDAddress() {
        System.out.println("getDAddress");
        // OrderList instance = null;
        String expResult = "abc";
        String result = ol.getDAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //  fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class OrderList.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String status = "Processing";
        //  OrderList instance = null;
        ol.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of setOrderList method, of class OrderList.
     */
    @Test
    public void testSetOrderList() {
        System.out.println("setOrderList");
        List<Order> orderList = new ArrayList<>();
        //OrderList instance = null;
        ol.setOrderList(orderList);
        // TODO review the generated test code and remove the default call to fail.
        //  fail("The test case is a prototype.");
    }

    /**
     * Test of setCustId method, of class OrderList.
     */
    @Test
    public void testSetCustId() {
        System.out.println("setCustId");
        String custId = "Cn0001";
        // OrderList instance = null;
        ol.setCustId(custId);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of setPickUpDate method, of class OrderList.
     */
    @Test
    public void testSetPickUpDate() {
        System.out.println("setPickUpDate");
        Date pickUpDate = new Date();
        // OrderList instance = null;
        ol.setPickUpDate(pickUpDate);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of setCollectMethod method, of class OrderList.
     */
    @Test
    public void testSetCollectMethod() {
        System.out.println("setCollectMethod");
        String collectMethod = "Delivery";
        //OrderList instance = null;
        ol.setCollectMethod(collectMethod);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of setDAddress method, of class OrderList.
     */
    @Test
    public void testSetDAddress() {
        System.out.println("setDAddress");
        String DAddress = "abc";
        // OrderList instance = null;
        ol.setDAddress(DAddress);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of arString method, of class OrderList.
     */
    /**
     * Test of calcTotalPrice method, of class OrderList.
     */
    /**
     * Test of calcAllOrder method, of class OrderList.
     */
    /**
     * Test of calcAllOrder method, of class OrderList.
     */
    /**
     * Test of setTotalPrice method, of class OrderList.
     */
    @Test
    public void testSetTotalPrice() {
        System.out.println("setTotalPrice");
        double totalPrice = 1.0;
        //  OrderList instance = null;
        ol.setTotalPrice(totalPrice);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of getAllTotal method, of class OrderList.
     */
    /**
     * Test of setAllTotal method, of class OrderList.
     */
    @Test
    public void testSetAllTotal() {
        System.out.println("setAllTotal");
        double allTotal = 1.0;
        // OrderList instance = null;
        ol.setAllTotal(allTotal);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class OrderList.
     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        int count = 1;
//      //  OrderList instance = null;
//        String expResult = "\n*************************\nOrder"+ count + "\nCustomer Id: " + ol.getCustId() + ol.arString() +"\nOrder Id: " + id + 
//                 "\n\nPick Up Date: " + formatter.format(ol.getPickUpDate()) + 
//                 "\nCollect Method: " + ol.getCollectMethod() +"\nAddress: " + ol.getDAddress() +", " + ol.getArea()  +"\nStatus= " + ol.getStatus() +"\n"
//                + "\n*************************\n";
//        String result = ol.toString(count);
//        assertEquals(expResult, result);
//        }
        
 
        // TODO review the generated test code and remove the default call to fail.
        //  fail("The test case is a prototype.");
    

}