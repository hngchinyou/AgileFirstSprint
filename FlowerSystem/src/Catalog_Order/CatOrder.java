/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalog_Order;

import entity.CorporateCust;
import entity.Customer;
import entity.Flower2;
import java.text.SimpleDateFormat;
import java.util.*;
import entity.Order;
import entity.OrderList;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author Han Xin
 */
public class CatOrder {
    //Testing1

    /**
     * @param args the command line arguments
     */
    public static void COmain(List<Customer> custList, List<Flower2> flower) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int choice;
        int count = 0;
        choice = catalogueMenu();
        if (choice == 1) {
            System.out.print("Enter Customer Id: ");
            String id = scanner.next();

            for (Customer c : custList) {
                if (id.equals(c.getId())) {
                    if (c.getcType().equals("Corporate")) {
                        int j = 0;
                        for (Flower2 f : flower) {
                            System.out.println("================");
                            System.out.print("Flower " + (++j) + "\n" + f.getFlowername() + "\nRM ");
                            System.out.println(String.format("%.2f", f.getPrice()));
                            System.out.println("================");
                        }
                        count = 1;
                        catalogueOrder(custList, flower, id);
                    } else if (c.getcType().equals("Consumer")) {
                        int j = 0;
                        for (Flower2 f : flower) {
                            System.out.println("================");
                            System.out.print("Flower " + (++j) + "\n" + f.getFlowername() + "\nRM ");
                            System.out.println(String.format("%.2f", f.getPrice()));
                            System.out.println("================");
                        }
                        count = 1;
                        consOrder(custList, flower, id);
                    }
                }

            }

        }
        if (count == 0) {
            System.err.println("This person does not exist!");
        }

    }

    public static void catalogueOrder(List<Customer> custList, List<Flower2> flower, String id) {

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        // respond
        String res = "";
        String res1 = "";
        String remakeRes = "";
        String remakeRes1 = "";
        //Array Declaration    
        List<Order> arrOrder = new ArrayList<>();
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
        double allOrderPrice = 0;
        Date date1 = new Date();
        boolean valid = true;
        // arrOrder.add(new Order("1", 3, date1, 100.00));
        //orderList.add(new OrderList(arrOrder, date1, "Delivery", " ", "Cr0002","Processing"));
        //Date Formatter
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        do {
            if (!orderList.isEmpty()) {
                for (OrderList ol : orderList) {

                    allOrderPrice = ol.calcAllOrder(orderList, id);
                }
            }
            for (Customer cust : custList) {

                if (id.equals(cust.getId())) {
                    System.out.print(((CorporateCust) cust).getCredit());
                    System.out.print(allOrderPrice);
                    if (allOrderPrice > ((CorporateCust) cust).getCredit()) {
                        valid = false;
                        break;
                    } else {

                        arrOrder = new ArrayList<>();
                        //arrOrder.clear();
                        do {

                            do {
                                if (remakeRes.equalsIgnoreCase("y") && totalPrice > ((CorporateCust) cust).getCredit()) {
                                    totalPrice -= totalSub;
                                }
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
                                }

                                quantity = scanner.nextInt();
                                System.out.print("\n");

                                // order list verify
                                // for loop for orderlist in order to get the total price
                                // of past order of same customer in this month
                                //for (OrderList ol : orderList) 
                                //{
                                //    allOrderPrice += ol.calcAllOrder(orderList, "Cr0001");
                                //}
                                if (allOrderPrice > ((CorporateCust) cust).getCredit()) {
                                    //System.err.println("You Have Over your monthly limit !");
                                    //System.err.print("Do you want to Remake Order ?[Y/N]");
                                    //remakeRes = scanner.next();
                                    //arrOrder.remove(arrOrder.size() - 1);
                                } else {
                                         
                                    arrOrder.add(new Order(orderNo, quantity, date, flower.get(Integer.parseInt(orderNo)).getPrice()));

                                    for (Order ol : arrOrder) {
                                        totalSub += ol.calculatePrice();
                                    }
                                    //check credit limit
                                    totalPrice = totalSub + allOrderPrice;
                                    //System.out.println(allOrderPrice);

                                    if (totalSub > ((CorporateCust) cust).getCredit() || totalPrice > ((CorporateCust) cust).getCredit()) {
                                        System.err.println("You Have Over your monthly limit !");
                                        System.err.print("Do you want to Remake Order ?[Y/N]");
                                        remakeRes = scanner.next();
                                        arrOrder.remove(arrOrder.size() - 1);

                                        if (remakeRes.equalsIgnoreCase("n")) {
                                            if (!arrOrder.isEmpty()) {

                                                arrOrder.remove(arrOrder.size() - 1);

                                                valid = false;

                                            } else {
                                                valid = false;
                                            }
                                        }
                                    }
                                }

                            } while (remakeRes.equalsIgnoreCase("Y")
                                    && (totalSub > ((CorporateCust) cust).getCredit()
                                    || allOrderPrice > ((CorporateCust) cust).getCredit()
                                    || (totalPrice > ((CorporateCust) cust).getCredit())));

                            if (valid == false) {
                                break;
                            } else {
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
                            }

                        } while (res.equalsIgnoreCase("Y") && valid);

                        if (res.equalsIgnoreCase("N") && valid) {
                            System.out.print("Enter the pick-up date (dd/MM/yyyy): ");

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
                        if (valid) {
                            orderList.add(new OrderList(arrOrder, pDate, collectMethod, address, id, "Processing"));

                            // arrOrder.clear();
                            System.out.print("Do you want to add more Order ? [Y/N] ");
                            //Check only Y or N allowed to enter 
                            while (!scanner.hasNext("(Y|N)|(y|n){1}$")) {
                                System.err.println("You only can choose Y or N !!!!");
                                System.out.print("Do you want to add more order ? [Y/N] ");
                                scanner.next();
                            }
                            res1 = scanner.next();
                        }

                    }
                }
            }

        } while (res1.equalsIgnoreCase("Y"));
        if(valid){
        double alltotal = 0;
        int a = 0;
        for (OrderList aa : orderList) {
            for (Customer c : custList) {
                if (id.equals(c.getId())) {
                    //alltotal+=aa.getAllTotal();
                    ++a;
                    System.out.print(aa.toString(a));
                }
            }
            //alltotal += aa.calcAllOrder(orderList, "Cr0001", arrOrder);
        }
        System.out.print("\nTotal Price: RM ");
        System.out.println(String.format("%.2f", totalPrice));
        }
    }

    public static void consOrder(List<Customer> custList, List<Flower2> flower, String id) {

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        // respond
        String res = "";
        String res1 = "";
        String remakeRes = "";
        String remakeRes1 = "";
        //Array Declaration    
        List<Order> arrOrder = new ArrayList<>();
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
        double allOrderPrice = 0;
        Date date1 = new Date();
        boolean valid = true;
        // arrOrder.add(new Order("1", 3, date1, 100.00));
        //orderList.add(new OrderList(arrOrder, date1, "Delivery", " ", "Cr0002","Processing"));
        //Date Formatter
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        do {
            if (!orderList.isEmpty()) {
                for (OrderList ol : orderList) {

                    allOrderPrice = ol.calcAllOrder(orderList, id);
                }
            }

            arrOrder = new ArrayList<>();
            //arrOrder.clear();
            do {

                do {

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
                    }

                    quantity = scanner.nextInt();
                    System.out.print("\n");

                    // order list verify
                    // for loop for orderlist in order to get the total price
                    // of past order of same customer in this month
                    //for (OrderList ol : orderList) 
                    //{
                    //    allOrderPrice += ol.calcAllOrder(orderList, "Cr0001");
                    //}
                    //System.err.println("You Have Over your monthly limit !");
                    //System.err.print("Do you want to Remake Order ?[Y/N]");
                    //remakeRes = scanner.next();
                    //arrOrder.remove(arrOrder.size() - 1);
                    arrOrder.add(new Order(orderNo, quantity, date, flower.get(Integer.parseInt(orderNo)).getPrice()));

                    for (Order ol : arrOrder) {
                        totalSub += ol.calculatePrice();
                    }
                    //check credit limit
                    totalPrice = totalSub + allOrderPrice;
                    //System.out.println(allOrderPrice);

                } while (remakeRes.equalsIgnoreCase("Y"));

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
            orderList.add(new OrderList(arrOrder, pDate, collectMethod, address, id, "Processing"));

            // arrOrder.clear();
            System.out.print("Do you want to add more Order ? [Y/N] ");
            //Check only Y or N allowed to enter 
            while (!scanner.hasNext("(Y|N)|(y|n){1}$")) {
                System.err.println("You only can choose Y or N !!!!");
                System.out.print("Do you want to add more order ? [Y/N] ");
                scanner.next();
            }
            res1 = scanner.next();

        } while (res1.equalsIgnoreCase("Y"));

        double alltotal = 0;
        int a = 0;
        for (OrderList aa : orderList) {
            for (Customer c : custList) {
                if (id.equals(c.getId())) {
                    //alltotal+=aa.getAllTotal();
                    ++a;
                    System.out.print(aa.toString(a));
                }
            }
            //alltotal += aa.calcAllOrder(orderList, "Cr0001", arrOrder);
        }
        System.out.print("\nTotal Price: RM ");
        System.out.println(totalPrice);
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
