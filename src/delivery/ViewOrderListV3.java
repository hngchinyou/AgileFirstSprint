/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery;

import com.sun.jmx.remote.util.OrderClassLoaders;
import java.sql.Timestamp;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.Order;
import entity.OrderList;

/**
 *
 * @author Chin You
 */
public class ViewOrderListV3 {

    /**
     * @param args the command line arguments
     */
    public static void Deliverymain() {
        // TODO code application logic here
        char result;
        Scanner sc = new Scanner(System.in);
        
        List<Order> orderItem = new ArrayList<>();
        List<OrderList> orderList = viewOrderList(true, orderItem);
        do{
        System.out.println("Please select your option\n1) View Order of today\n2) Indicate specific order\n3) Exit");
        result = sc.next().charAt(0);
        if (result == '1') {
            viewOrderList(false, orderItem);
        } else if (result == '2') {
            indicateOrder(orderList, orderItem);
        }}while(result!=3);
        
    }

    public static List<OrderList> viewOrderList(boolean valid, List<Order> orderItem) {

        List<OrderList> orderList = new ArrayList<>();
        try {

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sdf.parse("25/11/2018");
            Date pickUpDate = sdf.parse("25/11/2018");
            Date todayDate = new Date();
            int count = 0;

            todayDate = sdf.parse(sdf.format(new Date()));

            orderItem.add(new Order("1", 3, todayDate, 12.34));
            orderItem.add(new Order("2", 1, todayDate, 54.32));
            orderItem.add(new Order("3", 6, todayDate, 22.34));

            orderList.add(new OrderList(orderItem, pickUpDate, "Delivery", "PV13", "Cn0001", "Processing"));//hardcoding order list 1
            orderList.add(new OrderList(orderItem, pickUpDate, "Self Pickup", "PV14", "Cn0001", "Processing"));//hardcoding order list 1
//            orderList.add(new OrderList(orderItem, pickUpDate, "Delivery", "PV15", "Cn0001", "Processing"));//hardcoding order list 2
//            orderList.add(new OrderList(orderItem, pickUpDate, "Self Pickup", "PV11", "Cn0001", "Processing"));//hardcoding order list 2
//            orderList.add(new OrderList(orderItem, pickUpDate, "Delivery", "PV16", "Cn0001", "Processing"));//hardcoding order list 2
//            orderList.add(new OrderList(orderItem, pickUpDate, "Self Pickup", "PV12", "Cn0001", "Processing"));//hardcoding order list 2
//            orderList.add(new OrderList(orderItem, pickUpDate, "Delivery", "PV23", "Cn0001", "Processing"));//hardcoding order list 2
//            orderList.add(new OrderList(orderItem, pickUpDate, "Self Pickup", "PV11", "Cn0001", "Processing"));//hardcoding order list 2

            if (!valid) {
                System.out.println("Displaying order list of the day");
            
            int a = 0;

            for (OrderList ol: orderList)//displaying order list of today
            {
                if (ol.getPickUpDate().compareTo(todayDate) == 0 && ol.getCollectMethod().equals("Delivery")) {
                    System.out.println(ol.toString(++a));
                } else {
                    count++;
                }
            }
            }
            if (count == orderList.size() && !valid)//displaying message if no order list today
            {
                System.out.println("There are no available order list today");
            }

        } catch (ParseException ex) {
            Logger.getLogger(ViewOrderListV3.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderList;
    }//end of retrieving

    public static void indicateOrder(List<OrderList> orderList, List<Order> orderItem) {
        Date date = new Date();
        long time = date.getTime();
        Scanner sc = new Scanner(System.in);
        int reply;
        int count = 0;
        double pay;
        String exit = "";
        double change;

        Timestamp ts = new Timestamp(time);
        int a = 0;
        for (OrderList aa : orderList) {
            if (aa.getStatus().equals("Processing")) {

                //alltotal+=aa.getAllTotal();
                ++a;
                System.out.print(aa.toString(a));
                count++;
                //alltotal += aa.calcAllOrder(orderList, "Cr0001", arrOrder);
            }
        }
        
        do{
       // System.out.println(count);//ask user to choose order to indicate
        System.out.println("Which order do you want to indicate?");//ask user to choose order to indicate

        while (!sc.hasNextInt()) {
            sc.next();
            System.out.println("Please enter number only: ");
        }
        reply = sc.nextInt()-1;

        
        if(!(reply >= orderList.size()) && !(reply < 0))
        {
            if (!orderList.get(reply).getStatus().equals("Processing") || (reply+1) > count) {                
                System.out.println("Please enter order number listed above");
                sc.next();
            }
        }  
        else
            System.out.println("The order is not exist"); 
        }while(reply >= orderList.size());
        
        for (int i = 0; i < orderList.size(); i++)//find order requested by user
        {
            if (orderList.get(i).getOrderList().get(i).getOrderNum().equals("" + reply)) {
                System.out.println("\n" + orderList.get(i).getOrderList());
                System.out.println("\nThe price is RM " + orderList.get(i).calcTotalPrice(orderItem) + ".\n");
                while (!sc.hasNextInt() && !sc.hasNextDouble()) {
                    sc.next();
                    System.out.println("Please enter number only: ");
                }
                pay = sc.nextDouble();

                while (pay < orderList.get(i).calcTotalPrice(orderItem)) {
                    System.out.println("Insufficient money, please reenter!");
                    while (!sc.hasNextInt() && !sc.hasNextDouble()) {
                        sc.next();
                        System.out.println("Please enter number only: ");
                    }
                    pay = sc.nextDouble();
                }

                change = pay - orderList.get(i).calcTotalPrice(orderItem);

                orderList.get(i).setStatus("Completed");
                orderList.get(i).setPickUpDate(ts);
                System.out.println("\nYour change is RM " + change + ". Thank you for coming!\n==============================================");
                int b = 0;
                System.out.println(orderList.get(i).getOrderList());
                System.out.println(orderList.get(i).getStatus());
            }
        }
//        indicateOrder(orderList, orderItem);
    }//end of indicating
}
