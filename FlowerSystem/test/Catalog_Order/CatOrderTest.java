/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalog_Order;


import Interface.ArrayList;
import Interface.ListInterface;
import entity.Order;
import entity.OrderList;
//import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class CatOrderTest {
    
    public CatOrderTest() {
    }
    
    @Before
    public void setUp() {
    }

   
    
   
    /**
     * Test of addQuantity method, of class CatOrder.
     */
    @Test
    public void testAddQuantity() {
        System.out.println("addQuantity");
        ListInterface<Order> orderItem = new ArrayList<>();
        ListInterface<Order> orderItem1 = new ArrayList<>();
        ListInterface<OrderList> orderList = new ArrayList<>();
        orderItem.add(new Order("1", 1, new Date(), 1.0));
        orderItem.add(new Order("1", 1, new Date(), 1.0));
        String orderId = "Or0001";
       // orderList.add(new OrderList(orderItem, "Or0001", new Date(), "Delivery", "Setapak", "abc", "Cn0001", "Processing"));
        
        int expResult = 2;
        int result = CatOrder.addQuantity(orderList, orderId, orderItem1);
   
        assertEquals(expResult, result);
       
    }

   
 
    
}
