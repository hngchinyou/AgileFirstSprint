package catalogueMaintanance;

import custMaintenanceNPayment.mLinkedInterface;
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
    public static void CEmain(mLinkedInterface<Flower2> flower) {              
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
            for (int i=0; i<flower.size();i++)
            {   
                
                if(productID.equals(flower.get(i).getId())){
                System.out.println("\n");    
                System.out.println("Original Flowers Information"); 
                System.out.println("==========================" + "\n" + 
                "ID:" + flower.get(i).getId() + "\n" +  
                "Flower Name:" + flower.get(i).getFlowername() + "\n" +  
                "Description:" + flower.get(i).getDescription() + "\n" + 
                "Type:" + flower.get(i).getType() + "\n" +
                "Price: RM " + flower.get(i).getPrice() + "\n" + 
                "Amount:" + flower.get(i).getAmount() + "\n" + 
                "==========================" +
                "\n" + "\n");  
                
                
                //if(productID.equals(flowers.getId())){
                System.out.println("Please enter the new information at below");
                System.out.println("-----------------------------------------");
                System.out.println("Product ID:" + flower.get(i).getId());
                
                System.out.print("Please enter new poduct name:");
                productName = scanner.next();
                while(!productName.matches("[a-zA-Z, ]+")){
                System.out.print("\n");
                System.out.println("Please do not leave blank!");
                System.out.print("Enter new product name: "); 
                productName = scanner.next();
                }
                flower.get(i).setFlowername(productName);
                
                System.out.print("Enter product description: ");
                description = scanner.next();
                while(!description.matches("[a-zA-Z1-9, ]+")){
                System.out.println("Please do not leave blank!");
                System.out.print("Enter product description: "); 
                description = scanner.next();
                }
                flower.get(i).setDescription(description);
                
                System.out.println("Product Type:" + flower.get(i).getType());
                
                System.out.print("Enter product price: RM ");
                while(!scanner.hasNext("\\s*(?=.*[1-9])\\d*(?:\\.\\d{1,2})?\\s*$")){                
                scanner.next();
                System.out.print("Invalid input. Please input again. \n");
                System.out.print("Enter product price: RM ");
                }
                price = scanner.nextDouble();
                flower.get(i).setPrice(price);
                //}    
                
                System.out.print("Enter product quantity: ");           
                while(!scanner.hasNextInt() || !scanner.hasNext("[0-9]*")){                
                scanner.next();
                System.out.print("Invalid input. Please input again. \n");
                System.out.print("Enter product amount: ");
                }
                amount = scanner.nextInt();
                flower.get(i).setAmount(amount);
                
                System.out.println("Modified successfully!" + "\n");
                }
            
            }
    }
}
