/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalog_Order;


import java.text.SimpleDateFormat;
import java.util.*;
import entity.Order;
import entity.OrderList;
/**
 *
 * @author Han Xin
 */
public class CatOrder {

    /**
     * @param args the command line arguments
     */
    public static void COmain() {
        int choice;
        choice = catalogueMenu();
        if (choice == 1) {
            catalogueOrder();
        }
     catalogueOrder();
  }

    public static void catalogueOrder() {

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        // respond
        String res = "";
        String res1 = "";
        String remakeRes = "";
        String remakeRes1 = "";
        //Array Declaration    
        List<Order> arrOrder ;
        List<OrderList> orderList = new ArrayList<>();
       
        //Variable Declaration
        int quantity = 0;
        Date date = new Date();
        int count = 0;
        String pickUpD;
        String orderNo;
        Date pDate = new Date();
        String collectMethod = "";
        String address = "";
        double creditLimit = 1000.0;
        double totalSub = 0;
        double totalPrice = 0;

        //Date Formatter
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        do {
            arrOrder = new ArrayList<>();
            arrOrder.clear();
            do {

                do {

                    totalSub = 0;
                    System.out.print("Enter the Catalogue Number: ");

//                while(!scanner.hasNext("[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]\\w$")){
//                     System.err.print("Sorry, please enter a proper tity again: ");
//                    scanner.next();
//                }
                orderNo = scanner.next();

                    System.out.print("Enter the quantity: ");
                    //Check only integer allowed to enter 
                    while (!scanner.hasNext("\\d*[1-9]\\d*$")) {
                        System.err.print("Sorry, please enter a proper quantity again: ");
                        scanner.next();
    orderNo = scanner.next();
            }
         System.out.print("Enter the quantity: ");
                //Check only integer allowed to enter 
                while (!scanner.hasNext("[1-9]$")) {
                    System.err.print("Sorry, please enter a proper quantity again: ");
                    scanner.next();
                }

                    quantity = scanner.nextInt();
                    System.out.print("\n");

                    // order list verify
                    // for loop for orderlist in order to get the total price
                    // of past order of same customer in this month
                    arrOrder.add(new Order(orderNo, quantity, date, 50.0));

                    for (Order ol : arrOrder) {
                        totalSub += ol.calculatePrice();
                    }
                    //check credit limit
                    if (totalSub > 1000) {
                        System.err.println("You Have Over your monthly limit !");
                        System.err.print("Do you want to Remake Order ?[Y/N]");
                        remakeRes = scanner.next();
                        arrOrder.remove(arrOrder.size() - 1);
                    }
                } while (remakeRes.equalsIgnoreCase("Y") && totalSub > 1000);

                //Ask to add more item
                System.out.print("Do you want to add more item ? [Y/N] ");
                //Check only Y or N allowed to enter 
                while (!scanner.hasNext("(Y|N)|(y|n){1}$")) {

                    System.err.println("You only can choose Y or N !!!!");
                    System.out.print("Do you want to add more item ? [Y/N] ");
                    scanner.next();

                }
                res = scanner.next();

                count++;

            } while (res.equalsIgnoreCase("Y"));

            if (res.equalsIgnoreCase("N")) {
                System.out.print("Enter the pick-up date (dd/MM/yyyy): ");

                //Date Validation
                while (!scanner.hasNext("(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$")) {

                    System.err.print("Sorry, please enter a proper date with the format(dd/MM/yyyy) : ");
                    scanner.next();
                }

                pickUpD = scanner.next();
                try {
                    pDate = formatter.parse(pickUpD);

                } catch (Exception ex) {

                }
                int choice = 0;
                choice = collectMethodMenu();
                switch (choice) {
                    case 1:
                        collectMethod = "Delivery";
                        System.out.print("Enter Delivery Address:");
                        address = scanner.next();
                        break;
                    case 2:
                        collectMethod = "Self Pick Up";
                        address = " ";
                        break;
                }

            }
//            for(OrderList o : orderList){
//                if(o.calcTotalPrice() > creditLimit){
//                    System.err.println("You already over your limit. you cannot continue order!");
//                    System.err.println("Please Try Again~!");
//                }
//            }
            orderList.add(new OrderList(arrOrder, pDate, collectMethod, address,"C0001"));

            // arrOrder.clear();
            System.out.print("Do you want to add more Order ? [Y/N] ");
            //Check only Y or N allowed to enter 
            while (!scanner.hasNext("(Y|N)|(y|n){1}$")) {
                System.err.println("You only can choose Y or N !!!!");
                System.out.print("Do you want to add more order ? [Y/N] ");
                scanner.next();
            }
            res1 = scanner.next();
            System.out.print("\n");

        } while (res1.equalsIgnoreCase("Y"));

        int a = 0;
        for (OrderList aa : orderList) {
            System.out.print(aa);
            System.out.print(aa.calcAllOrder(orderList));
            System.out.print("\n");
        }

    }

    public static int catalogueMenu() {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Catalogue Order");
        System.out.println("======================");
        System.out.println("1.Make Order");
        System.out.println("2.View Order List");
        System.out.println("3.Generate Sales Order");
        System.out.println("======================");
        System.out.print("Enter your choice:");
        choice = scanner.nextInt();
        return choice;
    }

    public static int collectMethodMenu() {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Choose the Collect Method ");
        System.out.println("==================================");
        System.out.println("1. Delivery  ");
        System.out.println("2. Self Pick Up");
        System.out.println("==================================");
        System.out.print("Enter your choice:");
        choice = scanner.nextInt();
        return choice;
    }

}

