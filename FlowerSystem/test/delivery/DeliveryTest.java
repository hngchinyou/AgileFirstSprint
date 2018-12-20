///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package delivery;
//
//import delivery.ViewOrderListV3;
//import entity.Order;
//import entity.OrderList;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author Chin You
// */
//public class DeliveryTest {
//    public DeliveryTest() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//
//   
//    
//   
//    /**
//     * Test of viewRoute method, of class Delivery.
//     */
//    @Test
//    public void testViewRoute() {
//        
//        try {
//            List<OrderList> orderList = new ArrayList<>();
//            
//            System.out.println("addQuantity");
//            List<Order> orderItem = new ArrayList<>();
//            orderItem.add(new Order("1", 1, new Date(), 1.0));
//            
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//            Date date = new Date();
//            date = sdf.parse(sdf.format(new Date()));
//            String orderId = "Or0001";
//            orderList.add(new OrderList(orderItem, "Or0001", date, "Delivery", "Setapak", "abc", "Cn0001", "Processing"));
//            int expResult = 1;
//            int result = ViewOrderListV3.sortRoute(orderList);
//            if(result > 0)
//                result = 1;
//            //   int result = CatOrder.addQuantity(orderList, orderId, orderItem1);
//            assertEquals(expResult, result);
//            // TODO review the generated test code and remove the default call to fail.
//            // fail("The test case is a prototype.");
//        } catch (ParseException ex) {
//            Logger.getLogger(DeliveryTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//}
