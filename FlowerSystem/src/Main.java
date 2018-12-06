import java.util.Scanner;

import customized.CustFloArrange;
import Catalog_Order.CatOrder;
import custMaintenanceNPayment.CustomerMaintenanceAndPayment;
import delivery.ViewOrderListV3;
import catalogueMaintanance.CatalogueAdd;
/**
 * 18
 */


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
                	CatalogueAdd.CMmenu();
                    break;
                case 2:
                   CustomerMaintenanceAndPayment.CPmain();
                    break;
                case 3:               
                    CatOrder.COmain();
                    break;
                case 4:
                	ViewOrderListV3.Deliverymain();
                    break;
                case 5:
                	CustFloArrange.custFloArrange();
                    break;
            }
        } while (choice != 6);

	}

}
