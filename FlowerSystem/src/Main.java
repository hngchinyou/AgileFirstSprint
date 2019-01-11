

import java.util.Scanner;

import customized.CustFloArrange;
import Catalog_Order.CatOrder;
import Catalog_Order.doubleLinked;
import Catalog_Order.doubleLinkedInterface;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
doubleLinkedInterface<Order> arrOrder = new doubleLinked<>();
doubleLinkedInterface<OrderList> orderList = new doubleLinked<>();
//        arrOrder.add(new Order("1", 3, new Date(), 12.34));
//        orderList.add(new OrderList(arrOrder, "Or0001", new Date(), "Delivery", "setapak", "Pv13", "Cn0001", "Processing"));//hardcoding order list 1

        // customer maintenance initial array
        //ListInterface<Customer> custList = new ArrayList<>();
        mLinkedInterface<Customer> custList = new mLinked<>();
        custList.add(new Customer("Cn0001", "yohku", "Wangsa Maju", "Consumer"));
        custList.add(new CorporateCust("Cr0002", "kuma", "Wangsa Maju 2", "Corporate", 5000, "Kumasou", "60-5936555"));
        // flower maintenance
        mLinkedInterface<Flower2> flower = new mLinked<>();
      //flower.add(new Flower2("B1111", "Sun Shine", "asdasdasdasd", "Bouquet", 12.20, 5));
        //flower.add(new Flower2("B1112", "Lover Bouquets", "asdasdasdasd", "Bouquet", 13.0, 2));
        flower.add(new Flower2("F1111", "Buttercup", "asdasdasdasd", "Flower", 14.20, 2));
        flower.add(new Flower2("F1112", "Cherry Blosom", "sdaqwefgwre", "Flower", 15.20, 2));
        flower.add(new Flower2("F1113", "Clover", "asdiuqwheasd", "Flower", 16.20, 5));
        flower.add(new Flower2("A1113", "Black Clover", "asdiuqwheasd", "Accessories", 5.20, 10));
        
        SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
        Date dsf=null,dsf2=null,dsf3=null,dsf4=null,dsf5=null,dsf6=null,dsf7=null,dsf8=null,dsf9=null;
        try {
        dsf = sdf.parse("13-12-2018");
        dsf2 = sdf.parse("14-12-2018");
        dsf3= sdf.parse("16-12-2018");
        dsf4 = sdf.parse("17-12-2018");
        dsf5 = sdf.parse("20-12-2018");
        dsf6 = sdf.parse("23-12-2018");
        dsf7= sdf.parse("24-12-2018");
        dsf8 = sdf.parse("26-12-2018");
        dsf9 = sdf.parse("27-12-2018");}catch(Exception ex) {}
		mLinkedInterface<CustomizedFlower> flowerList = new mLinked<>();
		mLinkedInterface<String> floType = new mLinked<>();
		floType.add("Clover");
		mLinkedInterface<String> accessory = new mLinked<>();
		accessory.add("Bear");
		CustomizedFlower custflower = new CustomizedFlower("Vertical", "Big", "CF0001", "Processing", floType,
				accessory, 1, "Cn0001", dsf);
		CustomizedFlower custflower2 = new CustomizedFlower("Vertical", "Big", "CF0001", "Processing", floType,
				accessory, 1, "Cn0001", dsf2);
		CustomizedFlower custflower3 = new CustomizedFlower("Vertical", "Big", "CF0001", "Processing", floType,
				accessory, 1, "Cn0001", dsf3);
		CustomizedFlower custflower4 = new CustomizedFlower("Vertical", "Big", "CF0001", "Processing", floType,
				accessory, 1, "Cn0001", dsf4);
		CustomizedFlower custflower5 = new CustomizedFlower("Vertical", "Big", "CF0001", "Processing", floType,
				accessory, 1, "Cn0001", dsf5);
		CustomizedFlower custflower6 = new CustomizedFlower("Vertical", "Big", "CF0001", "Processing", floType,
				accessory, 1, "Cn0001", dsf6);
		CustomizedFlower custflower7 = new CustomizedFlower("Vertical", "Big", "CF0001", "Processing", floType,
				accessory, 1, "Cn0001", dsf7);
		CustomizedFlower custflower8 = new CustomizedFlower("Vertical", "Big", "CF0001", "Processing", floType,
				accessory, 1, "Cn0001", dsf8);
		CustomizedFlower custflower9 = new CustomizedFlower("Vertical", "Big", "CF0001", "Processing", floType,
				accessory, 3, "Cn0001", dsf9);


		flowerList.add(custflower);
		flowerList.add(custflower2);
		flowerList.add(custflower3);
		flowerList.add(custflower4);
		flowerList.add(custflower5);
		flowerList.add(custflower6);
		flowerList.add(custflower7);
		flowerList.add(custflower8);
		flowerList.add(custflower9);
        //promotion
        mLinkedInterface<Promotion> promotion = new mLinked<>();
        //promotion.add(new Promotion("P1111", "Green Plant", "asdasdasdasd",12.20, 5));
        //promotion.add(new Promotion("P1112", "Lover Day", "asdasdasdasd",13.20, 5));
        //promotion.add(new Promotion("P1113", "Sun Shine", "asdasdasdasd",14.20, 5));       
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
                    CatOrder.COmain(custList, flower,allOrderPrice,arrOrder,orderList);
                    break;
                case 4:
                    //ViewOrderListV3.Deliverymain(orderList, flowerList,flower);
                    break;
                case 5:
                    CustFloArrange.custFloArrange(custList,flower,flowerList);
                    break;
            }
        } while (choice != 6);

    }

}



/*
   if(front == null)
    {
        front = (Object)1;
    }

*/
