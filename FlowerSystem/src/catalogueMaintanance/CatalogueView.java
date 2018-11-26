package catalogueMaintanance;

import entity.Flower2;
import java.util.ArrayList;
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
public class CatalogueView {
    public static void CVmain(List<Flower2> flower) {
        //List<Flower2> flower = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        char answer;
        
        /*flower.add(new Flower2("B1111","Sun Shine", "asdasdasdasd", "Bouquet", 12.20, 5));
        flower.add(new Flower2("B1112","Lover Bouquets", "asdasdasdasd", "Bouquet", 12.20, 5));
        flower.add(new Flower2("F1111","Buttercup", "asdasdasdasd", "Flower", 12.20, 5));
        flower.add(new Flower2("F1112","Cherry Blosom", "sdaqwefgwre", "Flower", 12.20, 5));
        flower.add(new Flower2("F1113","Clover", "asdiuqwheasd", "Flower", 12.20, 5));*/
        
        
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
         for (Flower2 flowers: flower)           
            System.out.println(flowers);
        } 
        else if(word.equalsIgnoreCase("b")){ 
        int i = 1;
        System.out.println("================="); 
        System.out.println("Flower For Sales");
        System.out.println("=================");
        for (Flower2 flowers: flower)
        {    
            System.out.println( i + ")"+ "Product ID:" + flowers.getId() + "\n" + "Product Name:" + flowers.getFlowername() + 
                    "\n" + "Price:" + flowers.getPrice()+ "\n");           
            i++;           
        }    
    }
    }
    
}
