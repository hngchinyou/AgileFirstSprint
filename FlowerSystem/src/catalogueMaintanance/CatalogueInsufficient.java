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
public class CatalogueInsufficient {
    public static void CImain(List<Flower2> flower){
        //List<Flower2> flower = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        /*flower.add(new Flower2("B1111","Sun Shine", "asdasdasdasd", "Bouquet", 12.20, 5));
        flower.add(new Flower2("B1112","Lover Bouquets", "asdasdasdasd", "Bouquet", 12.20, 2));
        flower.add(new Flower2("F1111","Buttercup", "asdasdasdasd", "Flower", 12.20, 2));
        flower.add(new Flower2("F1112","Cherry Blosom", "sdaqwefgwre", "Flower", 12.20, 2));
        flower.add(new Flower2("F1113","Clover", "asdiuqwheasd", "Flower", 12.20, 5));*/
        
        System.out.println("\n");
        System.out.println("Insufficient stock");
        for (Flower2 flowers: flower){
            if(flowers.getAmount()<3){
                System.out.println("***********************");
                System.out.println("Product ID:" +  flowers.getId());
                System.out.println("Product Name:" +  flowers.getFlowername());
                System.out.println("Quantity:" + flowers.getAmount());
                System.out.println("***********************" + "\n");
            }
            
        }
        
        
    }
}
