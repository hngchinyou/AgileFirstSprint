/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogueMaintanance;
import custMaintenanceNPayment.mLinked;
import custMaintenanceNPayment.mLinkedInterface;
import entity.Flower2;
import entity.Promotion;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author user
 */
public class CataloguePromotion {
    public static void CPmain(mLinkedInterface<Promotion> promotion, mLinkedInterface<Flower2> flower){
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        String name, description;
        double price;
        int amount = 0;
        int PromotionId = 1111;
        String result = "";
        String fullPromotionID = "";
        do{
        for(int i=0; i<promotion.size();i++){
                    if(("P" + PromotionId).equals(promotion.get(i).getId())){
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
            
            int fneeded=0;
            int qneeded=0;
            int loopcount=0;
            
            mLinkedInterface<Flower2> fneededList = new mLinked<>();
            mLinkedInterface<Flower2> tfneededList = new mLinked<>();
            
            do{
                loopcount=0;
                System.out.println("===== Flower =====");
                for(int i=0; i<flower.size();i++)
                {
                    if(flower.get(i).getType().equals("Flower"))
                    {
                        System.out.println(loopcount+1 +". "+ flower.get(i).getFlowername());
                        loopcount++;
                        tfneededList.add(flower.get(i));
                    }
                }
                System.out.println("===== Accessories =====");
                for(int i=0; i<flower.size();i++)
                {
                    if(flower.get(i).getType().equals("Accessories"))
                    {
                        System.out.println(loopcount+1 +". "+ flower.get(i).getFlowername());
                        loopcount++;
                        tfneededList.add(flower.get(i));
                    }
                }
                System.out.println(loopcount+1 + ". Finish selection");
                System.out.print("Select the flower/accessories that needed for this promotion: ");
                fneeded = scanner.nextInt();
                if(fneeded!=5)
                {
                    System.out.print("Quantity: ");
                    qneeded = scanner.nextInt();
                    fneededList.add(tfneededList.get(fneeded-1));
                    fneededList.get(fneededList.size()-1).setAmount(qneeded);
                }

            }while(fneeded!=loopcount+1);
            
        
            System.out.print("Enter promotion quantity: ");           
            while(!scanner.hasNextInt() || !scanner.hasNext("[0-9]*")){                
                scanner.next();
                System.out.print("Invalid input. Please input again. \n");
                System.out.print("Enter product amount: ");
            }
            amount = scanner.nextInt();
        
            
            addPromotion(promotion, fullPromotionID, name, description, price, amount, fneededList);
        
        System.out.println("Do you want to add another new promotion(y/n)?");
            while (!scanner.hasNext("(Y|N)|(y|n){1}$")) {
                System.err.println("You only can choose Y or N !!!!");
                scanner.next();
            }
            result = scanner.next();
           
    }while(result.equalsIgnoreCase("Y"));              
         System.out.println("Add successful." + "\n");
}

    public static void addPromotion(mLinkedInterface<Promotion> promotion, String fullPromotionID, String name, String description, double price, int amount, mLinkedInterface neededflower) {
        promotion.add(new Promotion(fullPromotionID, name, description, price, amount, neededflower));
    }
}