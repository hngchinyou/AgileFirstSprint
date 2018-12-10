/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogueMaintanance;
import entity.Promotion;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author user
 */
public class CataloguePromotion {
    public static void CPmain(List<Promotion> promotion){
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        String name, description;
        double price;
        int amount = 0;
        int PromotionId = 1111;
        String result = "";
        String fullPromotionID = "";
        do{
        for(Promotion promotions: promotion){
                    if(("P" + PromotionId).equals(promotions.getId())){
                        PromotionId++;
                    }
        }
        System.out.print("\n");
        System.out.print("Promotion ID: ");            
        System.out.print("P" + PromotionId);
        fullPromotionID = "P" + PromotionId;
        PromotionId ++;
        System.out.print("\n");
        
        System.out.print("Enter new promotion name: ");            
            name = scanner.next(); 
            while(!name.matches("[a-zA-Z, ]+")){
                System.out.print("\n");
                System.out.println("Please do not leave blank!");
                System.out.print("Enter new promotion name: "); 
                name = scanner.next();
            }
            
        System.out.print("Enter promotion description: ");
            description = scanner.next();
            while(!description.matches("[a-zA-Z1-9, ]+")){
                System.out.println("Please do not leave blank!");
                System.out.print("Enter product description: "); 
                description = scanner.next();
            }
            
        System.out.print("Enter promotion price: RM ");
            while(!scanner.hasNext("\\s*(?=.*[1-9])\\d*(?:\\.\\d{1,2})?\\s*$")){                
                scanner.next();
                System.out.print("Invalid input. Please input again. \n");
                System.out.print("Enter product price: RM ");
            }
            price = scanner.nextDouble();
            
        System.out.print("Enter promotion quantity: ");           
            while(!scanner.hasNextInt() || !scanner.hasNext("[0-9]*")){                
                scanner.next();
                System.out.print("Invalid input. Please input again. \n");
                System.out.print("Enter product amount: ");
            }
            amount = scanner.nextInt();
            
        promotion.add(new Promotion(fullPromotionID, name, description, price, amount));
        
        System.out.println("Do you want to add another new promotion(y/n)?");
            while (!scanner.hasNext("(Y|N)|(y|n){1}$")) {
                System.err.println("You only can choose Y or N !!!!");
                scanner.next();
            }
            result = scanner.next();
           
    }while(result.equalsIgnoreCase("Y"));              
         System.out.println("Add successful." + "\n");
}
}