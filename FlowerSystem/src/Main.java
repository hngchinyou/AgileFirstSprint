import java.util.Scanner;

/**
 * 
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
                	
                    break;
                case 2:
                	
                    break;
                case 3:
                	
                    break;
                case 4:
                	
                    break;
                case 5:
                	
                    break;
            }
        } while (choice != 6);

	}

}
