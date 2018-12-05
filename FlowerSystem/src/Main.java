

import java.util.Scanner;

import customized.CustFloArrange;
import Catalog_Order.CatOrder;
import custMaintenanceNPayment.CustomerMaintenanceAndPayment;
import delivery.ViewOrderListV3;
import catalogueMaintanance.CatalogueAdd;
import entity.CorporateCust;
import entity.Customer;
import entity.Flower2;
import java.util.ArrayList;
import java.util.List;

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
        // customer maintenance initial array
        List<Customer> custList = new ArrayList<>();
        custList.add(new Customer("Cn0001", "yohku", "Wangsa Maju", "Consumer"));
        custList.add(new CorporateCust("Cr0002", "kuma", "Wangsa Maju 2", "Corporate", 5000, "Kumasou", "60-5936555"));
        // flower maintenance
        List<Flower2> flower = new ArrayList<>();
        flower.add(new Flower2("B1111", "Sun Shine", "asdasdasdasd", "Bouquet", 12.20, 5));
        flower.add(new Flower2("B1112", "Lover Bouquets", "asdasdasdasd", "Bouquet", 12.20, 2));
        flower.add(new Flower2("F1111", "Buttercup", "asdasdasdasd", "Flower", 12.20, 2));
        flower.add(new Flower2("F1112", "Cherry Blosom", "sdaqwefgwre", "Flower", 12.20, 2));
        flower.add(new Flower2("F1113", "Clover", "asdiuqwheasd", "Flower", 12.20, 5));
        int choice;

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Menu");
            System.out.println("==============================================");
            System.out.println("1.Catalogue Maintenance");
            System.out.println("2.Customer Maintenance and Invoice Payment");
            System.out.println("3.Catalogue Order");
            System.out.println("4.Pick Up and Delivery");
            System.out.println("5.Customized Flower Arrangement");
            System.out.println("6.Exit");
            System.out.println("==============================================");
            System.out.print("Enter Your Choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    CatalogueAdd.CMmenu(flower);
                    //Noob
                    break;
                case 2:
                    CustomerMaintenanceAndPayment.CPmain(custList);
                    break;
                case 3:
                    CatOrder.COmain(custList, flower,allOrderPrice);
                    break;
                case 4:
                    ViewOrderListV3.Deliverymain();
                    break;
                case 5:
                    CustFloArrange.custFloArrange(flower);
                    break;
            }
        } while (choice != 6);

    }

}
