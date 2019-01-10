package catalogueMaintanance;

import custMaintenanceNPayment.mLinked;
import custMaintenanceNPayment.mLinkedInterface;
import entity.Promotion;
import entity.Flower2;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
public class CatalogueAdd {
    
    public static void CMmenu(mLinkedInterface<Flower2> flower, mLinkedInterface<Promotion> promotion){
        Scanner scanner = new Scanner(System.in);
//        List<Promotion> promotion = new ArrayList<>();
        int choice;
        do{
        System.out.println("Catalogue Maintenance");
        System.out.println("==================================");
        System.out.println("1.Add Product");
        System.out.println("2.View Catalogue");
        System.out.println("3.View Insufficient");
        System.out.println("4.Update Information");
        System.out.println("5.Add Promotion");
        System.out.println("6.Exit");
        System.out.print("Enter your Choice: ");
        
        choice = scanner.nextInt();
        switch ( choice ){
            case 1 : 
                CatalogueAdd.CAmain(flower);
                break;
            case 2 : 
                CatalogueView.CVmain(flower, promotion);
                break;
            case 3 : 
                CatalogueInsufficient.CImain(flower);
                break;    
            case 4 :
                CatalogueEdit.CEmain(flower);
                break;
            case 5 :
                CataloguePromotion.CPmain(promotion);
        }
        }while(choice !=6);
       
    }
    
    public static void CAmain(mLinkedInterface<Flower2> flower) {
//        List<Flower2> flower = new ArrayList<>();
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        String result = "";
        String name, description, type;
        double price;
        int amount = 0;
        boolean error = false;
        int Flowerid = 1111;
        int Bouquetid = 1111;
        int Accessoriesid = 1111;
        int choice = 0;
        String fullFlowerID = "";
        String fullBouquetID = "";
        String flowerType = "Flower";
        String bouquetType = "Bouquet";
        String accessoriesType = "Accessories";
        do
        {
            System.out.println("Please choose for the product to add.");
            System.out.println("**************************************");
            System.out.println("1.Fresh Flower");
            System.out.println("2.Accessories");
            System.out.println("3.Bouquets");
            System.out.println("**************************************");
            System.out.print("Enter your Choice: ");
            //choice = scanner.nextInt();
            while(!scanner.hasNextInt() || !scanner.hasNext("[1-3]")){
                System.out.println("Please enter 1 or 3 only !!");
                System.out.print("Enter your Choice: ");
                scanner.next();             
            }           
            choice = scanner.nextInt();
            
            if(choice == 1){
                for(int i=0;i<flower.size();i++){
                    if(("F" + Flowerid).equals(flower.get(i).getId())){
                        Flowerid++;
                    }
                }
                System.out.print("Product ID: ");            
                System.out.print("F" + Flowerid);
                fullFlowerID = "F" + Flowerid;
                Flowerid ++;
                System.out.print("\n");               
            }else if(choice == 2){
                for(int i=0;i<flower.size();i++){
                    if(("A" + Accessoriesid).equals(flower.get(i).getId())){
                        Accessoriesid++;
                    }
                }
                System.out.print("Product ID: ");            
                System.out.print("A" + Accessoriesid);
                fullBouquetID = "A" + Accessoriesid;
                Accessoriesid ++;
                System.out.print("\n");
            }else{
                for(int i=0;i<flower.size();i++){
                    if(("B" + Bouquetid).equals(flower.get(i).getId())){
                        Bouquetid++;
                    }
                }
                System.out.print("Product ID: ");            
                System.out.print("B" + Bouquetid);
                fullBouquetID = "B" + Bouquetid;
                Bouquetid ++;
                System.out.print("\n");
            }
           
            System.out.print("Enter new product name: ");            
            name = scanner.next(); 
            while(!name.matches("[a-zA-Z, ]+")){
                System.out.print("\n");
                System.out.println("Please do not leave blank!");
                System.out.print("Enter new product name: "); 
                name = scanner.next();
            }
                               
            System.out.print("Enter product description: ");
            description = scanner.next();
            while(!description.matches("[a-zA-Z1-9, ]+")){
                System.out.println("Please do not leave blank!");
                System.out.print("Enter product description: "); 
                description = scanner.next();
            }
            
//            System.out.print("Enter product type: ");
            if(choice == 1){
                System.out.print("Product Type: " + flowerType);            
                System.out.print("\n");               
            }else if(choice == 2){
                System.out.print("Product Type: " + accessoriesType);            
                System.out.print("\n");
            }else{
                System.out.print("Product Type: " + bouquetType);            
                System.out.print("\n");
            } 
                     
//            type = scanner.next();
//            while(!type.matches("[a-zA-Z, ]+")){
//                System.out.println("Please do not leave blank!");
//                System.out.print("Enter product type: "); 
//                type = scanner.next();
//            }
            
            System.out.print("Enter product price: RM ");
            while(!scanner.hasNext("\\s*(?=.*[1-9])\\d*(?:\\.\\d{1,2})?\\s*$")){                
                scanner.next();
                System.out.print("Invalid input. Please input again. \n");
                System.out.print("Enter product price: RM ");
            }
            price = scanner.nextDouble();
            
            System.out.print("Enter product quantity: ");           
            while(!scanner.hasNextInt() || !scanner.hasNext("[0-9]*")){                
                scanner.next();
                System.out.print("Invalid input. Please input again. \n");
                System.out.print("Enter product amount: ");
            }
            amount = scanner.nextInt();
            
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
            System.out.print("Select the flower/accessories that needed for this bouquet: ");
            fneeded = scanner.nextInt();
            if(fneeded!=5)
            {
                System.out.print("Quantity: ");
                qneeded = scanner.nextInt();
                fneededList.add(tfneededList.get(fneeded-1));
                fneededList.get(fneededList.size()-1).setAmount(qneeded);
                int counttttt = fneededList.size();
                double a = 1;
                float b=1;
            }
            
            }while(fneeded!=loopcount+1);
            
            if(choice == 1){
                 flower.add(new Flower2(fullFlowerID, name, description, flowerType, price, amount));
            }else if(choice == 2){
                 flower.add(new Flower2(fullFlowerID, name, description, accessoriesType, price, amount));
            }else{
                  flower.add(new Flower2(fullBouquetID, name, description, bouquetType, price, amount, fneededList));
//                flower.add(new Flower2(String.format("%d", Bouquetid), name, description, type, price, amount));
            }
            
             
            System.out.println("Do you want to add another new product(y/n)?");
            while (!scanner.hasNext("(Y|N)|(y|n){1}$")) {
                System.err.println("You only can choose Y or N !!!!");
                scanner.next();
            }
            result = scanner.next();
        }while(result.equalsIgnoreCase("Y"));              
         System.out.println("Add successful." + "\n");       
    }
}


