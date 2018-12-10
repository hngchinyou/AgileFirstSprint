package catalogueMaintanance;

import entity.Flower2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entity.Promotion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class CatalogueView {
    public static void CVmain(List<Flower2> flower, List<Promotion> promotion) {
        Scanner scanner = new Scanner(System.in);
        char answer;
        int choice;
        
        /*flower.add(new Flower2("B1111","Sun Shine", "asdasdasdasd", "Bouquet", 12.20, 5));
        flower.add(new Flower2("B1112","Lover Bouquets", "asdasdasdasd", "Bouquet", 12.20, 5));
        flower.add(new Flower2("F1111","Buttercup", "asdasdasdasd", "Flower", 12.20, 5));
        flower.add(new Flower2("F1112","Cherry Blosom", "sdaqwefgwre", "Flower", 12.20, 5));
        flower.add(new Flower2("F1113","Clover", "asdiuqwheasd", "Flower", 12.20, 5));*/
        do{
        System.out.println("Catalogue Maintenance");
        System.out.println("==================================");
        System.out.println("1.View Product");
        System.out.println("2.View Promotion");
        System.out.println("3.Exit");
        System.out.print("Enter your choice: ");
        
        choice = scanner.nextInt();
        switch ( choice ){
            case 1 : 
                CatalogueView.ViewProduct(flower);
                break;
            case 2 : 
                CatalogueView.ViewPromotion(promotion);
                break;
        }
        }while(choice !=3);
    }
        
        public static void ViewProduct(List<Flower2> flower) {
        Scanner scanner = new Scanner(System.in);
        char answer;    
        
        System.out.println("Do you want to view product details or product sales?");
        System.out.println("a(Product Details) / b(Product Sales):");
        String word = scanner.next();
        while(!word.matches("[a-bA-B, ]+"))
        {
            System.out.println("Please only enter a or b:");
            word = scanner.next();
        }
//        word = word.toUpperCase();
//        answer = word.charAt(0);
        
        if(word.equalsIgnoreCase("a")){  
            System.out.println("Do you want to view bouquet or flower?");
            System.out.print("(a for Flower / b for Bouquet):");
            System.out.print("\n");
            String ans = scanner.next();
            while(!ans.matches("[a-bA-B, ]+"))
            {
                System.out.println("Please only enter a or b:");
                ans = scanner.next();
            }
            if(ans.equalsIgnoreCase("a")){
                for (Flower2 flowers: flower){
                    if(flowers.getType().equalsIgnoreCase("Flower"))
                    System.out.println(flowers);
                }
            }else if(ans.equalsIgnoreCase("b")){
                for (Flower2 flowers: flower){
                    if(flowers.getType().equalsIgnoreCase("Bouquet"))
                    System.out.println(flowers);
                }
            }           
            }
          
        else if(word.equalsIgnoreCase("b")){ 
            System.out.println("Do you want to view bouquet or flower?");
            System.out.print("(a for Flower / b for Bouquet):");
            System.out.print("\n");
            String answers = scanner.next();
            while(!answers.matches("[a-bA-B, ]+"))
            {
                System.out.println("Please only enter a or b:");
                answers = scanner.next();
            }
            if(answers.equalsIgnoreCase("a")){
                System.out.println("================="); 
                System.out.println("Flower For Sales");
                System.out.println("=================");
                for (Flower2 flowers: flower){
                    if(flowers.getType().equalsIgnoreCase("Flower")){
                    System.out.println("**************************");
                    System.out.println("Product ID:" + flowers.getId() + "\n" + "Product Name:" + flowers.getFlowername() + 
                    "\n" + "Price:" + flowers.getPrice());
                    System.out.println("**************************" + "\n");
                    }                   
                }
            }else if(answers.equalsIgnoreCase("b")){
                System.out.println("================="); 
                System.out.println("Flower For Sales");
                System.out.println("=================");
                for (Flower2 flowers: flower){
                    if(flowers.getType().equalsIgnoreCase("Bouquet")){
                        System.out.println("**************************");
                    System.out.println("Product ID:" + flowers.getId() + "\n" + "Product Name:" + flowers.getFlowername() + 
                    "\n" + "Price:" + flowers.getPrice());
                    System.out.println("**************************" + "\n");
                    }                  
                }
            }    
    }
    }
        
        
    public static void ViewPromotion(List<Promotion> promotion){
        System.out.println("======================="); 
        System.out.println("Flower with promotion");
        System.out.println("=======================");
        for (Promotion promotions: promotion)
        {    
            System.out.println(promotions);                               
        }    
    }
}

