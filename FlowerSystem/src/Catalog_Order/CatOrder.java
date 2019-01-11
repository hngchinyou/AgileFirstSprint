/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalog_Order;

//import Interface.List;
//import Interface.ArrayList;
import custMaintenanceNPayment.mLinked;
import custMaintenanceNPayment.mLinkedInterface;
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
public class CatOrder<T> {
    //12

    /**
     * @param args the command line arguments
     */
    public static void COmain(mLinkedInterface<Customer> custList, mLinkedInterface<Flower2> flower, double allOrderPrice, doubleLinkedInterface<Order> arrOrder, doubleLinkedInterface<OrderList> orderList) {
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
        } else if (count == 33) {
            System.err.println("Please do the payment!!!");
        }

    }

    public static void catalogueOrder(mLinkedInterface<Customer> custList, mLinkedInterface<Flower2> flower, String id, double allOrderPrice, doubleLinkedInterface<Order> arrOrder, doubleLinkedInterface<OrderList> orderList, int count5) {

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

        // arrOrder.add(new Order("1", 3, date1, 100.00));
        //orderList.add(new OrderList(arrOrder, date1, "Delivery", " ", "Cr0002","Processing"));
        //Date Formatter
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        do {
            String oid = generateOID(orderList);
            if (!orderList.isEmpty()) {
                for (int i = 0; i < orderList.size(); i++) {
                    if (!orderList.get(i).getStatus().equals("Paid")) {
                        allOrderPrice = orderList.get(i).calcAllOrder(orderList, id);
                    }
                }
            }
            for (int i = 0; i < custList.size(); i++) {

                if (id.equals(custList.get(i).getId())) {
                    System.out.println(custList.get(i).getName() + ",monthly limit is : " + (((CorporateCust) custList.get(i)).getCredit() - allOrderPrice));

                    //   System.out.print(allOrderPrice);
                    if (allOrderPrice > ((CorporateCust) custList.get(i)).getCredit()) {
                        valid = false;
                        break;
                    } else {

                        arrOrder = new doubleLinked<>();
                        //arrOrder.clear();
                        do {

                            do {
                                if (remakeRes.equalsIgnoreCase("y") && totalPrice > ((CorporateCust) custList.get(i)).getCredit()) {
                                    totalPrice -= totalSub;
                                }
                                totalSub = 0;

                                int countBouquet = 0;
                                int countFlower = 0;

                                for (int flt = 0; flt < flower.size(); flt++) {
                                    if (flower.get(flt).getType().equals("Bouquet")) {
                                        countBouquet++;
                                    } else if (flower.get(flt).getType().equals("Flower")) {
                                        countFlower++;
                                    }
                                }

                                do {
                                    System.out.print("Enter the Catalogue Number: ");

                                    while (!scanner.hasNext("\\d*[1-9]\\d*$")) {
                                        System.err.print("Sorry, please enter a proper catalog number again: ");
                                        scanner.next();
                                    }
                                    orderNo = scanner.next();
                                    if ((Integer.parseInt(orderNo) > countBouquet && count5 == 1)
                                            || (Integer.parseInt(orderNo) > countFlower && count5 == 2)) {
                                        System.err.println("Please choose the number in the catalog ");
                                    }

                                } while ((Integer.parseInt(orderNo) > countBouquet && count5 == 1)
                                        || (Integer.parseInt(orderNo) > countFlower && count5 == 2));
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
                                //for (OrderList orderList.get(j) : orderList) 
                                //{
                                //    allOrderPrice += orderList.get(j).calcAllOrder(orderList, "Cr0001");
                                //}
                                if (allOrderPrice > ((CorporateCust) custList.get(i)).getCredit()) {

                                } else {
                                    double getdeprice = 0;
                                    mLinkedInterface<Flower2> fl = new mLinked<>();
                                    for (int j = 0; j < flower.size(); j++) {
                                        if (flower.get(j).getType().equals("Bouquet") && count5 == 1) {
                                            fl.add(flower.get(j));

                                        } else if (flower.get(j).getType().equals("Flower") && count5 == 2) {
                                            fl.add(flower.get(j));
                                        }

                                    }
                                    //  getdeprice = fl.get(Integer.parseInt(orderNo) - 1).getPrice();
                                    getdeprice = fl.get(0).getPrice();
                                    arrOrder.add(new Order(orderNo, quantity, date, getdeprice));

                                    for (int j = 0; j < arrOrder.size(); j++) {
                                        totalSub += arrOrder.get(j).calculatePrice();
                                    }
                                    //check credit limit
                                    totalPrice = totalSub + allOrderPrice;
                                    //System.out.println(allOrderPrice);

                                    if (totalSub > ((CorporateCust) custList.get(i)).getCredit() || totalPrice > ((CorporateCust) custList.get(i)).getCredit()) {
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
                                    && (totalSub > ((CorporateCust) custList.get(i)).getCredit()
                                    || allOrderPrice > ((CorporateCust) custList.get(i)).getCredit()
                                    || (totalPrice > ((CorporateCust) custList.get(i)).getCredit())));

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

                        Date cmpPickDate = new Date();

                        if (res.equalsIgnoreCase("N") && valid) {
                            do {

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
                                if (pDate.before(cmpPickDate)) {
                                    System.err.println("Please enter date after today! ");
                                }
                            } while (pDate.before(cmpPickDate));
                            int choice = 0;
                            int count3 = 0;

                            choice = collectMethodMenu();

                            switch (choice) {
                                case 1:
                                    collectMethod = "Delivery";
                                    count3 = 1;
                                    break;
                                case 2:
                                    collectMethod = "Self Pick Up";
                                    address = " ";
                                    count3 = 2;
                                    break;
                            }
                            if (count3 == 1) {
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
                        }

                        if (valid) {

                            int ll = orderList.size();
                            boolean dateValid = false;
                            for (int k = 0; k < ll; k++) {
                                if (pDate.before(orderList.get(k).getPickUpDate())) {
                                    dateValid = true;
                                    orderList.addByPosition(k, new OrderList(arrOrder, oid, pDate, collectMethod, area, address, id, "Processing"));
                                }
                            }
                            if (!dateValid) {
                                orderList.add(new OrderList(arrOrder, oid, pDate, collectMethod, area, address, id, "Processing"));
                            }
                            // orderList.add(new OrderList(arrOrder, oid, pDate, collectMethod, area, address, id, "Processing"));

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

        System.out.print(arrOrder.size());
        if (valid) {
            double alltotal = 0;
            int a = 0;
            for (int j = 0; j < orderList.size(); j++) {
                for (int i = 0; i < custList.size(); i++) {
                    if (id.equals(custList.get(i).getId())) {
                        //alltotal+=aa.getAllTotal();
                        ++a;
                        System.out.print(orderList.get(j).toString(a));
                    }
                }
                //alltotal += aa.calcAllOrder(orderList, "Cr0001", arrOrder);
            }
            System.out.print("\nTotal Price: RM ");
            System.out.println(String.format("%.2f", totalPrice));
        }
    }

    private static boolean binarySearch(int first, int last, Date pDate, doubleLinkedInterface<OrderList> orderList) {
        boolean found;
        int mid = (first + last) / 2;
        if (first > last) {
            found = false;
        } else if (pDate.equals(orderList.get(mid).getPickUpDate())) {
            found = true;
        } else if (pDate.compareTo(orderList.get(mid).getPickUpDate()) < 0) {
            found = binarySearch(first, mid - 1, pDate, orderList);
        } else {
            found = binarySearch(mid + 1, last, pDate, orderList);
        }
        return found;
    }

    public static void consOrder(mLinkedInterface<Customer> custList, mLinkedInterface<Flower2> flower, String id, double allOrderPrice, doubleLinkedInterface<Order> arrOrder, doubleLinkedInterface<OrderList> orderList, int count5) {

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
                for (int i = 0; i < orderList.size(); i++) {

                    allOrderPrice = orderList.get(i).calcAllOrder(orderList, id);
                }
            }

            arrOrder = new doubleLinked<>();
            //arrOrder.clear();

            do {

                do {
                    int countBouquet = 0;
                    int countFlower = 0;

                    for (int flt = 0; flt < flower.size(); flt++) {
                        if (flower.get(flt).getType().equals("Bouquet")) {
                            countBouquet++;
                        } else if (flower.get(flt).getType().equals("Flower")) {
                            countFlower++;
                        }
                    }

                    do {
                        System.out.print("Enter the Catalogue Number: ");

                        while (!scanner.hasNext("\\d*[1-9]\\d*$")) {
                            System.err.print("Sorry, please enter a proper catalog number again: ");
                            scanner.next();
                        }
                        orderNo = scanner.next();
                        if ((Integer.parseInt(orderNo) > countBouquet && count5 == 1)
                                || (Integer.parseInt(orderNo) > countFlower && count5 == 2)) {
                            System.err.println("Please choose the number in the catalog ");
                        }

                    } while ((Integer.parseInt(orderNo) > countBouquet && count5 == 1)
                            || (Integer.parseInt(orderNo) > countFlower && count5 == 2));
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
                    //for (OrderList orderList.get(j) : orderList) 
                    //{
                    //    allOrderPrice += orderList.get(j).calcAllOrder(orderList, "Cr0001");
                    //}
                    //System.err.println("You Have Over your monthly limit !");
                    //System.err.print("Do you want to Remake Order ?[Y/N]");
                    //remakeRes = scanner.next();
                    //arrOrder.remove(arrOrder.size() - 1);
                    double getdeprice = 0;
                    List<Flower2> fl = new ArrayList<>();
                    for (int i = 0; i < flower.size(); i++) {
                        if (flower.get(i).getType().equals("Bouquet") && count5 == 1) {
                            fl.add(flower.get(i));
                            //getdeprice = flower.get(i).getPrice();

                        } else if (flower.get(i).getType().equals("Flower") && count5 == 2) {
                            fl.add(flower.get(i));
                            //getdeprice = flower.get(i).getPrice();

                        }

                    }
                    getdeprice = fl.get(Integer.parseInt(orderNo) - 1).getPrice();

                    arrOrder.add(new Order(orderNo, quantity, date, getdeprice));

                    totalSub += arrOrder.get(arrOrder.size() - 1).calculatePrice();
                    //totalSub += orderList.get(j).getQuantity()*orderList.get(j).getPrice();

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
            Date cmpPickDate = new Date();
            //     int day = cmpPickDate.getDate() + 1;
            //    cmpPickDate.setDate(day);
            //  System.out.print(cmpPickDate);
            if (res.equalsIgnoreCase("N")) {
                do {
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
                    if (pDate.before(cmpPickDate)) {
                        System.err.println("Please enter date after today! ");
                    }
                } while (pDate.before(cmpPickDate));
                int count3 = 0;
                int choice = 0;
                choice = collectMethodMenu();
                switch (choice) {
                    case 1:
                        collectMethod = "Delivery";
                        count3 = 1;
                        break;
                    case 2:
                        collectMethod = "Self Pick Up";
                        address = " ";
                        break;
                }
                if (count3 == 1) {
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
            }
//            for(OrderList o : orderList){
//                if(o.calcTotalPrice() > creditLimit){
//                    System.err.println("You already over your limit. you cannot continue order!");
//                    System.err.println("Please Try Again~!");
//                }
//            }

            int ll = orderList.size();
            boolean dateValid = false;
            for (int k = 0; k < ll; k++) {
                if (pDate.before(orderList.get(k).getPickUpDate())) {
                    dateValid = true;
                    orderList.addByPosition(k, new OrderList(arrOrder, oid, pDate, collectMethod, area, address, id, "Processing"));
                }
            }
            if (!dateValid) {
                orderList.add(new OrderList(arrOrder, oid, pDate, collectMethod, area, address, id, "Processing"));
            }

            // arrOrder.clea
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
        for (int i = 0; i < orderList.size(); i++) {
            for (int j = 0; j < custList.size(); j++) {
                if (id.equals(custList.get(j).getId())) {
                    //alltotal+=aa.getAllTotal();
                    ++a;
                    System.out.print(orderList.get(i).toString(a));
                }
            }
            //alltotal += aa.calcAllOrder(orderList, "Cr0001", arrOrder);
        }
        System.out.print("\nTotal Price: RM ");
        System.out.println(String.format("%.2f", totalPrice));

    }

    public static int generateSales(mLinkedInterface<Customer> custList, mLinkedInterface<Flower2> flower, double allOrderPrice, doubleLinkedInterface<Order> arrOrder, doubleLinkedInterface<OrderList> orderList) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        String custId = "";
        String orderId = "";
        doubleLinkedInterface<Order> orderItem = new doubleLinked<>();
        int count = 0;
        System.out.print("Enter Customer ID : ");
        custId = sc.next();
        int count1 = 0;
        int count2 = 0;

        int a = 0;
        for (int i = 0; i < custList.size(); i++) {
            if (custList.get(i).getId().equals(custId)) {
                System.out.println("Customer [" + custId + "'s] Order ID");
                System.out.println("===================================");

                for (int j = 0; j < orderList.size(); j++) {
                    if (orderList.get(j).getCustId().equals(custId)) {
                        ++a;

                        System.out.print("[" + a + "] ");
                        System.out.println(orderList.get(j).getId());
                        count2 = 1;
                    } else {
                        count2 = 0;
                    }

                }
                if (count2 == 1) {
                    System.out.println("===================================");
                    System.out.print("Enter Order ID : ");
                    orderId = sc.next();
                    count1 = addQuantity(orderList, orderId, orderItem);
                    int b = 0;
                    System.out.println("Sales order for Customer ID [" + custId + "] Order ID [" + orderId + "]");
                    System.out.println("======================================================================");
                    for (int k = 0; k < orderItem.size(); k++) {
                        ++b;
                        System.out.print("Item " + b);

                        System.out.print(orderItem.get(k));

                    }
                    System.out.println("======================================================================");
                    count = 1;
                }
            } else {
                count = 0;
            }

        }

        if (count == 0) {
            System.err.println("This person does not exist!");
        }

        return count1;

    }

    public static int addQuantity(doubleLinkedInterface<OrderList> orderList, String orderId, doubleLinkedInterface<Order> orderItem) {
        int count = 0;
        int count2 = 0;
        int count1 = 0;
        double price = 0;
        for (int i = 0; i < orderList.size(); i++) {

            if (orderList.get(i).getId().equals(orderId)) {

                for (int k = 0; k < orderList.get(i).getOrderList().size(); k++) {
                    count = 0;
                    if (orderItem.isEmpty()) {
                        orderItem.add(new Order(orderList.get(i).getOrderList().get(k).getOrderNum(),
                                orderList.get(i).getOrderList().get(k).getQuantity(), orderList.get(i).getOrderList().get(k).getPrice()));
                        count1 = 1;
                    } else {
                        for (int j = 0; j < orderItem.size(); j++) {
                            if (orderItem.get(j).getOrderNum().equals(orderList.get(i).getOrderList().get(k).getOrderNum())) {
                                count2 = orderItem.get(j).getQuantity() + orderList.get(i).getOrderList().get(k).getQuantity();
                                price = orderItem.get(j).calculatePrice() + orderList.get(i).getOrderList().get(k).calculatePrice();
                                orderItem.get(j).setPrice(orderList.get(i).getOrderList().get(k).getPrice());
                                orderItem.get(j).setQuantity(count2);
                                count = 1;
                                count1 = count2;

                            }
                        }
                        if (count == 0) {
                            orderItem.add(new Order(orderList.get(i).getOrderList().get(k).getOrderNum(),
                                    orderList.get(i).getOrderList().get(k).getQuantity(), orderList.get(i).getOrderList().get(k).getPrice()));
                            count1 = 1;

                        }

                    }

                }
            }

        }
        return count1;
    }

    private static int getCustomer(mLinkedInterface<Customer> custList, String id, int count, mLinkedInterface<Flower2> flower, double allOrderPrice, doubleLinkedInterface<Order> arrOrder, doubleLinkedInterface<OrderList> orderList) {
        for (int i = 0; i < custList.size(); i++) {
            if (id.equals(custList.get(i).getId())) {
                if (custList.get(i).getcType().equals("Corporate")) {
                    Date date = new Date();
                    boolean valid = true;
                    if ((new Date(2018, 11, 8)).before(date)) {
                        valid = true;
                    } else {
                        for (int j = 0; j < orderList.size(); j++) {
                            if (orderList.get(j).getCustId().equals(id) && orderList.get(j).getPickUpDate().getMonth() == date.getMonth() - 1) {
                                if (!(orderList.get(j).getStatus().equals("Paid"))) {
                                    valid = false;
                                    count = 33;
                                }
                            }
                        }
                    }
                    if (valid) {
                        count = Catalog(flower);
                        catalogueOrder(custList, flower, id, allOrderPrice, arrOrder, orderList, count);
                    }

                } else if (custList.get(i).getcType().equals("Consumer")) {
                    count = Catalog(flower);
                    consOrder(custList, flower, id, allOrderPrice, arrOrder, orderList, count);
                }
            }

        }
        return count;
    }

    private static int Catalog(mLinkedInterface<Flower2> flower) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        int count;
        int j = 0;
        int choice;

        System.out.println("Catalogue Menu\n==============");
        System.out.println("1. Bouquet Menu");
        System.out.println("2. Flower Menu");
        System.out.print("Choice:");
        while (!scanner.hasNext("(1)|(2)")) {
            System.err.println("You only can choose 1 or 2 !!!!");
            System.out.print("Enter your choice:");
            scanner.next();
        }
        choice = scanner.nextInt();

        for (int i = 0; i < flower.size(); i++) {
            if (flower.get(i).getType().equals("Bouquet") && choice == 1) {
                System.out.println("================");
                System.out.print("Flower " + (++j) + "\n" + flower.get(i).getFlowername() + "\nRM ");
                System.out.println(String.format("%.2f", flower.get(i).getPrice()));
                System.out.println("================");
            } else if (flower.get(i).getType().equals("Flower") && choice == 2) {
                System.out.println("================");
                System.out.print("Flower " + (++j) + "\n" + flower.get(i).getFlowername() + "\nRM ");
                System.out.println(String.format("%.2f", flower.get(i).getPrice()));
                System.out.println("================");
            }
        }
        count = 1;
        return choice;
    }

    public static String generateOID(doubleLinkedInterface<OrderList> orderLists) {
        int count = 0;
        for (int i = 0; i < orderLists.size(); i++) {
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

        while (!scanner.hasNext("(1)|(2)")) {
            System.err.println("You only can choose 1 or 2 !!!!");
            System.out.print("Enter your choice:");
            scanner.next();
        }
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
        while (!scanner.hasNext("(1)|(2)|(3)|(4)")) {
            System.err.println("You only can choose 1 to 4 !!!!");
            System.out.print("Enter your choice:");
            scanner.next();
        }

        choice = scanner.nextInt();
        return choice;

    }

}
