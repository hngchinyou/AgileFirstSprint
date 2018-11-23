/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custMaintenanceNPayment;

import entity.CorporateCust;
import entity.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;





/**
 *
 * @author Kuma
 */
public class CustomerMaintenanceAndPayment{

    

    /**
     * @param args the command line arguments
     */
    public static void CPmain() {
        int choice = 0, choice2 = 0;
           List<CorporateCust> custList = new ArrayList<>();
        custList.add(new CorporateCust("Cn0001", "yohku", "Wangsa Maju", "Consumer"));
        custList.add(new CorporateCust("Cr0002", "kuma", "Wangsa Maju 2", "Corporate", 2000));
        
        do{
            choice = custMenu();
            if(choice==1)
                classify(custList);
            else if(choice==2)
                setLimit(custList);
            else if(choice==3)
            {
                choice2 = shCMenu();
                 if(choice2==1)
                    addCust(custList);
                 else if(choice2==2)
                    viewCust(custList);
                 else if(choice2==3);
                    editCust(custList);
            }
        }while(choice!=4);
        
    }
 
    public static void classify(List<CorporateCust> custList)  
    {
        Scanner scanner = new Scanner(System.in);
        String name;
        
        
        System.out.print("Enter customer name: ");
        name = scanner.nextLine();
        
        if(verifyCT(name, custList)==1)
            System.out.println(name + " is a corporate customer!");
        else if(verifyCT(name, custList)==2)
            System.out.println(name + " is a consumer customer!");
        else
            System.err.println(name + " is not exist");
        
    }
    
    public static int verifyCT(String name, List<CorporateCust> custList)
    {
        for(Customer c: custList)
        {
            if(name.equals(c.getName())&& c.getcType().equals("Corporate"))
                return 1;
            else if(name.equals(c.getName())&& c.getcType().equals("Consumer"))
                return 2;
        }
        return 0;
    }
    
    public static int custMenu()
    {
        int choice=0;
        Scanner scanner = new Scanner(System.in);
        do
        {
            shMenu(); 
            while(!scanner.hasNext("[0-9]"))
            {
                System.err.println("Please enter digit\n");
                shMenu();
                scanner.next();
            }
            choice = scanner.nextInt();
        }while((choice>4 || choice < 1));
        return choice;
    }
    
    public static void setLimit(List<CorporateCust> custList)
    {
        Scanner scanner = new Scanner(System.in);
        String name;
        double credit;
        boolean valid = false;
        
        System.out.print("Please enter the corporate customer name: ");
        name = scanner.nextLine();
        
        for(CorporateCust c: custList)
        {
            if(name.equals(c.getName()) && c.getcType().equals("Corporate"))
            {
                System.out.print("Enter the credit for the corporate customer: RM ");
                while(!scanner.hasNext("\\s*(?=.*[1-9])\\d*(?:\\.\\d{1,2})?\\s*$"))
                {
                    System.err.println("Please enter digit");
                    System.out.print("Enter the credit for the corporate customer: RM ");
                    scanner.next();
                }
                credit = scanner.nextDouble();
                
                c.setCredit(credit);
                valid = true;
                System.out.println(name + String.format("'s credit is RM %.2f\n", credit));
            }
        }
        
        if(!valid)
        {
            System.err.println("The corporate customer is not exist!");
        }
    }
    
    // menu
    public static void shMenu()
    {
        System.out.println("Customer Maintenance And Payment");
        System.out.println("1. Classify customer type");
        System.out.println("2. Set limit credit");
        System.out.println("3. Customer Maintenance");
        System.out.println("4. Exit");
        System.out.print("Enter your selection: ");
    }
    
    // customer maintenance menu
    public static int shCMenu()
    {
        int choice=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nCustomer Maintenance");
        System.out.println("1. Customer Registration");
        System.out.println("2. View Customer");
        System.out.println("3. Edit Customer");
        System.out.println("4. Exit");
        System.out.print("Enter your selection: ");
         
        while(!scanner.hasNext("[1-4]{1}"))
        {
            System.err.print("Please enter digit");
            System.out.print("Enter your selection: ");
            scanner.next();
        }
        choice = scanner.nextInt();
        return choice;
    }
    
    
    
    public static void addCust(List<CorporateCust> custList)
    {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter new customer information:");
        System.out.println("Customer type:\n"
                + "1.Corporate Customer\n"
                + "2.Consumer Customer");
        System.out.print("Enter the customer type: ");
        
        while(!scanner.hasNext("[1-2]{1}"))
        {
            System.err.print("Please enter digit");
            System.out.print("Enter your selection: ");
            scanner.next();
        }
        
        choice = scanner.nextInt();
        if(choice==1)
            addCor(custList);
        else
            addCon(custList);
    }
    
    public static void addCon(List<CorporateCust> custList)
    {
        Scanner scanner = new Scanner(System.in);
        String s = generateCID(custList, 2);
        String name;
        String add;
        System.out.println("\nCustomer ID: " + s);
        System.out.print("Name : ");
        name = scanner.nextLine();
        System.out.print("Address : ");
        add = scanner.nextLine();
        
        custList.add(new CorporateCust(s, name, add, "Consumer"));
        System.out.println("The customer register successfully!\n");
    }
    
    public static void addCor(List<CorporateCust> custList)
    {
        Scanner scanner = new Scanner(System.in);
        String s = generateCID(custList, 1);
        String name;
        String add;
        double credit;
        System.out.println("\nCustomer ID: " + s);
        System.out.print("Name : ");
        name = scanner.nextLine();
        System.out.print("Address : ");
        add = scanner.nextLine();
        System.out.print("Credit : RM ");
        //credit = scanner.nextDouble();
        
        while(!scanner.hasNext("\\s*(?=.*[1-9])\\d*(?:\\.\\d{1,2})?\\s*$"))
        {
            System.err.println("Please enter digit");
            System.out.print("Credit : RM ");
            scanner.next();
        }
        credit = scanner.nextDouble();
        
        custList.add(new CorporateCust(s, name, add, "Corporate", credit));
        System.out.println("The customer register successfully!\n");
    }
    
    // generate customer id
    public static String generateCID(List<CorporateCust> custList, int type)
    {
        int count=0;
        for(CorporateCust c: custList)
        {
            count++;
        }
        
        if(type == 1)
            return String.format("Cr%04d", ++count);
        else
            return String.format("Cn%04d", ++count);
    }
    
    // print all customer information
    public static void viewCust(List<CorporateCust> custList)
    {
        for(CorporateCust c: custList)
        {
            System.out.println(c);
        }
    }
    
    public static void editCust(List<CorporateCust> custList)
    {
        
    }
}
