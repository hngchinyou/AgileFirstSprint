

import java.util.Scanner;

import customized.CustFloArrange;
import Catalog_Order.CatOrder;
//import Interface.ArrayList;
//import Interface.ListInterface;
import custMaintenanceNPayment.CustomerMaintenanceAndPayment;
import delivery.ViewOrderListV3;
import catalogueMaintanance.CatalogueAdd;
import custMaintenanceNPayment.mLinked;
import custMaintenanceNPayment.mLinkedInterface;
import entity.CorporateCust;
import entity.Customer;
import entity.CustomizedFlower;
import entity.Flower2;
import entity.Promotion;
import entity.Order;
import entity.OrderList;
import java.util.List;
import java.util.ArrayList;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;

/**
 *
 */

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // catalog order initial array 
        double allOrderPrice = 0;
        mLinkedInterface<Order> arrOrder = new mLinked<>();
        mLinkedInterface<OrderList> orderList = new mLinked<>();
//        arrOrder.add(new Order("1", 3, new Date(), 12.34));
//        orderList.add(new OrderList(arrOrder, "Or0001", new Date(), "Delivery", "setapak", "Pv13", "Cn0001", "Processing"));//hardcoding order list 1

        // customer maintenance initial array
        //ListInterface<Customer> custList = new ArrayList<>();
        mLinkedInterface<Customer> custList = new mLinked<>();
        custList.add(new Customer("Cn0001", "yohku", "Wangsa Maju", "Consumer"));
        custList.add(new CorporateCust("Cr0002", "kuma", "Wangsa Maju 2", "Corporate", 5000, "Kumasou", "60-5936555"));
        // flower maintenance
        mLinkedInterface<Flower2> flower = new mLinked<>();
        flower.add(new Flower2("B1111", "Sun Shine", "asdasdasdasd", "Bouquet", 12.20, 5));
        flower.add(new Flower2("B1112", "Lover Bouquets", "asdasdasdasd", "Bouquet", 13.0, 2));
        flower.add(new Flower2("F1111", "Buttercup", "asdasdasdasd", "Flower", 14.20, 2));
        flower.add(new Flower2("F1112", "Cherry Blosom", "sdaqwefgwre", "Flower", 15.20, 2));
        flower.add(new Flower2("F1113", "Clover", "asdiuqwheasd", "Flower", 16.20, 5));
		mLinkedInterface<CustomizedFlower> flowerList = new mLinked<>();
//		ListInterface<String> floType = new ArrayList<>(Arrays.asList("Clover"));
//		ListInterface<String> accessory = new ArrayList<>(Arrays.asList("Bear"));
//		CustomizedFlower custflower = new CustomizedFlower("Vertical", "Big", "CF0001", "Processing", floType,
//				accessory, 1, "Cn0001", new Date());

//		flowerList.add(custflower);
        //promotion
        mLinkedInterface<Promotion> promotion = new mLinked<>();
        promotion.add(new Promotion("P1111", "Green Plant", "asdasdasdasd",12.20, 5));
        promotion.add(new Promotion("P1112", "Lover Day", "asdasdasdasd",13.20, 5));
        promotion.add(new Promotion("P1113", "Sun Shine", "asdasdasdasd",14.20, 5));       
        int choice;

        
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Menu");
            System.out.println("==============================================");
            System.out.println("[1] Catalogue Maintenance");
            System.out.println("[2] Customer Maintenance and Invoice Payment");
            System.out.println("[3] Catalogue Order");
            System.out.println("[4] Pick Up and Delivery");
            System.out.println("[5] Customized Flower Arrangement");
            System.out.println("[6] Exit");
            System.out.println("==============================================");
            System.out.print("Enter Your Choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    CatalogueAdd.CMmenu(flower, promotion);
                    break;
                case 2:
                    CustomerMaintenanceAndPayment.CPmain(custList, allOrderPrice, orderList);
                    break;
                case 3:
                    System.out.print(custList.get(0));
                    CatOrder.COmain(custList, flower,allOrderPrice,arrOrder,orderList);
                    break;
                case 4:
                    //ViewOrderListV3.Deliverymain(orderList, flowerList,flower);
                    break;
                case 5:
                    //CustFloArrange.custFloArrange(custList,flower,flowerList);
                    break;
            }
        } while (choice != 6);

    }

}
