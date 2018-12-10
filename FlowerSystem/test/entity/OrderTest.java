/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class OrderTest {
    
    private String orderNum = "1";
    private Date date = new Date();
    
    
    Order  o = new Order(orderNum, 1, date, 1.0);
    public OrderTest() {
    }
    
    @Before
    public void setUp() {
         
    }

    /**
     * Test of getPrice method, of class Order.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        System.out.println(o.getPrice());
        
        double expResult = 1.0;
        double result = o.getPrice();
        assertEquals(expResult, result, 0.1);
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }

    /**
     * Test of getOrderNum method, of class Order.
     */
    @Test
    public void testGetOrderNum() {
        System.out.println("getOrderNum");
       // Order instance = new Order();
        String expResult = "1";
        String result = o.getOrderNum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantity method, of class Order.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
       // Order instance = new Order();
        int expResult = 1;
        int result = o.getQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Order.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
      //  Order instance = new Order();
        Date expResult = o.getDate();
        Date result = o.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of setPrice method, of class Order.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        double price = 0.0;
       // Order instance = new Order();
        o.setPrice(price);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setOrderNum method, of class Order.
     */
    @Test
    public void testSetOrderNum() {
        System.out.println("setOrderNum");
        String orderNum = "";
        //Order instance = new Order();
        o.setOrderNum(orderNum);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantity method, of class Order.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int quantity = 0;
       // Order instance = new Order();
        o.setQuantity(quantity);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class Order.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Date date = new Date();
       // Order instance = new Order();
        o.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of calculatePrice method, of class Order.
     */
    @Test
    public void testCalculatePrice() {
        System.out.println("calculatePrice");
       // Order instance = new Order();
        double expResult = 1.0;
        double result = o.calculatePrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    //    fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Order.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
       // Order instance = new Order();
        String expResult ="\n=========================\nOrder Num: " + o.getOrderNum() + "\nQuantity: " + o.getQuantity() + "\nSub Price: " + String.format("%.2f", o.calculatePrice()) + "\n=========================\n";;
        String result = o.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}