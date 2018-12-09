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
//Bodoh Han Xin

/**
 *
 * @author Han Xin
 */
public class CatOrder {
    //12

    /**
     * @param args the command line arguments
     */
    public static void COmain(List<Customer> custList, List<Flower2> flower, double allOrderPrice, List<Order> arrOrder, List<OrderList> orderList) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int choice;
        int count = 0;
        choice = catalogueMenu();
        if (choice == 1) {
            System.out.print("Enter Customer Id: ");
            String id = scanner.next();

            count = getCustomer(custList, id, count, flower, allOrderPrice, arrOrder, orderList);

        } else if (choice == 2) {
            generateSales(custList, flower, allOrderPrice, arrOrder, orderList);
            count = 1;
        }
        if (count == 0) {
            System.err.println("This person does not exist!");
        }

    }

    public static void catalogueOrder(List<Customer> custList, List<Flower2> flower, String id, double allOrderPrice, List<Order> arrOrder, List<OrderList> orderList) {

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        // respond
        String res = "";
        String res1 = "";
        String remakeRes = "";
        String remakeRes1 = "";
        //Array Declaration    

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
        String area = "";
        // double allOrderPrice = 0;
        Date date1 = new Date();
        boolean valid = true;
        String oid = generateOID(orderList);
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
                    System.out.println(cust.getName() + ",monthly limit is : " + (((CorporateCust) cust).getCredit() - allOrderPrice));

                    //   System.out.print(allOrderPrice);
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
                            int areaChoice = 0;
                            areaChoice = areaMenu();
                            switch (areaChoice) {
                                case 1:
                                    area = "Setapak";
                                    System.out.print("Enter Delivery Address:");
                                    address = scanner.next();
                                    break;
                                case 2:
                                    area = "Gombak";
                                    System.out.print("Enter Delivery Address:");
                                    address = scanner.next();
                                    break;
                                case 3:
                                    area = "Cheras";
                                    System.out.print("Enter Delivery Address:");
                                    address = scanner.next();
                                    break;
                                case 4:
                                    area = "Subang";
                                    System.out.print("Enter Delivery Address:");
                                    address = scanner.next();
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
                            orderList.add(new OrderList(arrOrder, oid, pDate, collectMethod, area, address, id, "Processing"));

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
        if (valid) {
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

    public static void consOrder(List<Customer> custList, List<Flower2> flower, String id, double allOrderPrice, List<Order> arrOrder, List<OrderList> orderList) {

        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        // respond
        String res = "";
        String res1 = "";
        String remakeRes = "";
        String remakeRes1 = "";
        //Array Declaration    

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
        String area = "";
        Date date1 = new Date();
        boolean valid = true;

        // arrOrder.add(new Order("1", 3, date1, 100.00));
        //orderList.add(new OrderList(arrOrder, date1, "Delivery", " ", "Cr0002","Processing"));
        //Date Formatter
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        do {
            String oid = generateOID(orderList);
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
                        break;
                    case 2:
                        collectMethod = "Self Pick Up";
                        address = " ";
                        break;
                }
                int areaChoice = 0;
                areaChoice = areaMenu();
                switch (areaChoice) {
                    case 1:
                        area = "Setapak";
                        System.out.print("Enter Delivery Address:");
                        address = scanner.next();
                        break;
                    case 2:
                        area = "Gombak";
                        System.out.print("Enter Delivery Address:");
                        address = scanner.next();
                        break;
                    case 3:
                        area = "Cheras";
                        System.out.print("Enter Delivery Address:");
                        address = scanner.next();
                        break;
                    case 4:
                        area = "Subang";
                        System.out.print("Enter Delivery Address:");
                        address = scanner.next();
                        break;
                }
            }
//            for(OrderList o : orderList){
//                if(o.calcTotalPrice() > creditLimit){
//                    System.err.println("You already over your limit. you cannot continue order!");
//                    System.err.println("Please Try Again~!");
//                }
//            }
            orderList.add(new OrderList(arrOrder, oid, pDate, collectMethod, area, address, id, "Processing"));

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

    public static void generateSales(List<Customer> custList, List<Flower2> flower, double allOrderPrice, List<Order> arrOrder, List<OrderList> orderList) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        String custId = "";
        String orderId = "";
        List<Order> orderItem = new ArrayList<>();

        System.out.print("Enter Customer ID : ");
        custId = sc.next();
        int a = 0;
        System.out.println("Customer [" + custId + "'s] Order ID");
        System.out.println("===================================");
        for (OrderList ol : orderList) {
            if (ol.getCustId().equals(custId)) {
                ++a;

                System.out.print("[" + a + "] ");
                System.out.println(ol.getId());

            }

        }
        System.out.println("===================================");
        System.out.print("Enter Order ID : ");
        orderId = sc.next();
        int count = 0;
        int count2 = 0;
        double price = 0;
        for (OrderList ol2 : orderList) {
            if (ol2.getId().equals(orderId)) {
                for (int i = 0; i < ol2.getOrderList().size(); i++) {
                    count = 0;
                    if (orderItem.isEmpty()) {
                        orderItem.add(new Order(ol2.getOrderList().get(i).getOrderNum(),
                                ol2.getOrderList().get(i).getQuantity(), ol2.getOrderList().get(i).getPrice()));
                    } else {
                        for (Order oi : orderItem) {
                            if (oi.getOrderNum().equals(ol2.getOrderList().get(i).getOrderNum())) {
                                count2 = oi.getQuantity() + ol2.getOrderList().get(i).getQuantity();
                                price = oi.calculatePrice() + ol2.getOrderList().get(i).calculatePrice();
                                oi.setPrice(ol2.getOrderList().get(i).getPrice());
                                oi.setQuantity(count2);
                                count = 1;

                            }
                        }
                        if (count == 0) {
                            orderItem.add(new Order(ol2.getOrderList().get(i).getOrderNum(),
                                    ol2.getOrderList().get(i).getQuantity(), ol2.getOrderList().get(i).getPrice()));

                        }

                    }

                }
            }

        }
        int b = 0;
        System.out.println("Sales order for Customer ID [" + custId + "] Order ID [" + orderId + "]");
        System.out.println("======================================================================");
        for (Order oi2 : orderItem) {
            ++b;
            System.out.print("Item " + b);

            System.out.print(oi2);

        }
        System.out.println("======================================================================");
    }

    private static int getCustomer(List<Customer> custList, String id, int count, List<Flower2> flower, double allOrderPrice, List<Order> arrOrder, List<OrderList> orderList) {
        for (Customer c : custList) {
            if (id.equals(c.getId())) {
                if (c.getcType().equals("Corporate")) {
                    count = Catalog(flower);
                    catalogueOrder(custList, flower, id, allOrderPrice, arrOrder, orderList);
                } else if (c.getcType().equals("Consumer")) {
                    count = Catalog(flower);
                    consOrder(custList, flower, id, allOrderPrice, arrOrder, orderList);
                }
            }

        }
        return count;
    }

    private static int Catalog(List<Flower2> flower) {
        int count;
        int j = 0;
        for (Flower2 f : flower) {
            System.out.println("================");
            System.out.print("Flower " + (++j) + "\n" + f.getFlowername() + "\nRM ");
            System.out.println(String.format("%.2f", f.getPrice()));
            System.out.println("================");
        }
        count = 1;
        return count;
    }

    public static String generateOID(List<OrderList> orderLists) {
        int count = 0;
        for (OrderList id : orderLists) {
            count++;
        }
        return String.format("Or%04d", ++count);

    }

    public static int catalogueMenu() {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Catalogue Order");
        System.out.println("======================");
        System.out.println("[1] Make Order");
        System.out.println("[2] Generate Sales Order");
        System.out.println("[3] Exit");
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
        System.out.println("[1] Delivery  ");
        System.out.println("[2] Self Pick Up");
        System.out.println("==================================");
        System.out.print("Enter your choice:");
        choice = scanner.nextInt();
        return choice;

    }

    public static int areaMenu() {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Choose the Address Area ");
        System.out.println("==================================");
        System.out.println("[1] Setapak  ");
        System.out.println("[2] Gombak");
        System.out.println("[3] Cheras");
        System.out.println("[4] Subang");
        System.out.println("==================================");
        System.out.print("Enter your choice:");
        choice = scanner.nextInt();
        return choice;

    }

}
