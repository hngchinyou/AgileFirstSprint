package catalogueMaintanance;

import entity.Flower2;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class CatalogueEdit {
    public static void CEmain(List<Flower2> flower) {              
        String productID, productName, description;
        double price;
        int amount = 0;
        
         Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Enter product ID to search product:");
            productID = scanner.next();
            while(!productID.matches("[a-zA-Z0-9, ]+")){
                System.out.println("Please do not leave blank!");
                System.out.print("Enter product ID to search product: "); 
                productID = scanner.next();
            }
            for (Flower2 flowers: flower)
            {   
                
                if(productID.equals(flowers.getId())){
                System.out.println("\n");    
                System.out.println("Original Flowers Information"); 
                System.out.println("==========================" + "\n" + 
                "ID:" + flowers.getId() + "\n" +  
                "Flower Name:" + flowers.getFlowername() + "\n" +  
                "Description:" + flowers.getDescription() + "\n" + 
                "Type:" + flowers.getType() + "\n" +
                "Price: RM " + flowers.getPrice() + "\n" + 
                "Amount:" + flowers.getAmount() + "\n" + 
                "==========================" +
                "\n" + "\n");  
                
                
                //if(productID.equals(flowers.getId())){
                System.out.println("Please enter the new information at below");
                System.out.println("-----------------------------------------");
                System.out.println("Product ID:" + flowers.getId());
                
                System.out.print("Please enter new poduct name:");
                productName = scanner.next();
                while(!productName.matches("[a-zA-Z, ]+")){
                System.out.print("\n");
                System.out.println("Please do not leave blank!");
                System.out.print("Enter new product name: "); 
                productName = scanner.next();
                }
                flowers.setFlowername(productName);
                
                System.out.print("Enter product description: ");
                description = scanner.next();
                while(!description.matches("[a-zA-Z1-9, ]+")){
                System.out.println("Please do not leave blank!");
                System.out.print("Enter product description: "); 
                description = scanner.next();
                }
                flowers.setDescription(description);
                
                System.out.println("Product Type:" + flowers.getType());
                
                System.out.print("Enter product price: RM ");
                while(!scanner.hasNext("\\s*(?=.*[1-9])\\d*(?:\\.\\d{1,2})?\\s*$")){                
                scanner.next();
                System.out.print("Invalid input. Please input again. \n");
                System.out.print("Enter product price: RM ");
                }
                price = scanner.nextDouble();
                flowers.setPrice(price);
                //}    
                
                System.out.print("Enter product quantity: ");           
                while(!scanner.hasNextInt() || !scanner.hasNext("[0-9]*")){                
                scanner.next();
                System.out.print("Invalid input. Please input again. \n");
                System.out.print("Enter product amount: ");
                }
                amount = scanner.nextInt();
                flowers.setAmount(amount);
                
                System.out.println("Modified successfully!" + "\n");
                }
            
            }
    }
}
