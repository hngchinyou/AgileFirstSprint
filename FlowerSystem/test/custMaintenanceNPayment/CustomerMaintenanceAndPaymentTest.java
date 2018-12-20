/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custMaintenanceNPayment;

import entity.Customer;
import entity.Order;
import entity.OrderList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kuma
 */
public class CustomerMaintenanceAndPaymentTest {
    
    public CustomerMaintenanceAndPaymentTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testSortInvoice() {
    System.out.println("sortInvoice");
    List<Order> orderItem = new ArrayList<>();
    List<OrderList> orderList = new ArrayList<>();
    orderItem.add(new Order("1", 1, new Date(2018, 10, 5), 1.0));

    orderList.add(new OrderList(orderItem, "Or0001", new Date(2018, 10, 5), "Delivery", "Setapak", "abc", "Cr0002", "Processing"));
    String id = "Cr0002";
    Date date = new Date();

    int count = 0;
    int test = 0;
    int expResult = 1;
    int result = CustomerMaintenanceAndPayment.sortInvoice(orderList, id, date, orderItem, count, test);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    //fail("The test case is a prototype.");
    }

   
    @Test
    public void testChangeStatus() {
    System.out.println("changeStatus");
    int choice2 = 1;
    List<OrderList> orderList = new ArrayList<>();
    List<Order> orderItem = new ArrayList<>();
    orderItem.add(new Order("1", 1, new Date(2018, 10, 5), 1.0));
    orderList.add(new OrderList(orderItem, "Or0001", new Date(2018, 10, 5), "Delivery", "Setapak", "abc", "Cr0002", "Processing"));
    String id = "Cr0002";
    Date date = new Date();
    int expResult = 1;
    int result = CustomerMaintenanceAndPayment.changeStatus(choice2, orderList, id, date);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    //fail("The test case is a prototype.");
    }
    
}
