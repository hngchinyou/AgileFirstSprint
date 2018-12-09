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
    public static void CPmain(List<Customer> custList) {
        int choice = 0, choice2 = 0;
           
        
        do{
            choice = shCMenu();
            if(choice==1)
                addCust(custList);
            else if(choice==2)
            {
                choice2 = CViewMenu();
                if(choice2==1)
                    viewConCust(custList);
                else if(choice2==2)
                    viewCorCust(custList);
                else if(choice2==3)
                    viewCust(custList);
            }  
            else if(choice==3)
               editCust(custList);
            
        }while(choice!=4);
        
    }
 
    public static void classify(List<Customer> custList)  
    {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        String name;
        
        
        System.out.print("Enter customer name: ");
        name = scanner.next();
        
        if(verifyCT(name, custList)==1)
            System.out.println(name + " is a corporate customer!");
        else if(verifyCT(name, custList)==2)
            System.out.println(name + " is a consumer customer!");
        else
            System.err.println(name + " is not exist");
        
    }
    
    public static int verifyCT(String name, List<Customer> custList)
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
    
    public static void setLimit(List<Customer> custList)
    {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        String name;
        double credit;
        boolean valid = false;
        
        System.out.print("Please enter the corporate customer name: ");
        name = scanner.next();
        
        for(Customer c: custList)
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
                
                ((CorporateCust)c).setCredit(credit);
                valid = true;
                System.out.println(name + String.format("'s credit is RM %.2f\n", credit));
            }
        }
        
        if(!valid)
        {
            System.err.println("The corporate customer is not exist!");
        }
    }
   
    
    // customer maintenance menu
    public static int shCMenu()
    {
        int choice=0;
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
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
    
    // Customer view menu
    public static int CViewMenu()
    {
        int choice=0;
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.println("\nCustomer View");
        System.out.println("1. View Consumer Customer");
        System.out.println("2. View Corporate Customer");
        System.out.println("3. View All Customer");
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
    
    public static void addCust(List<Customer> custList)
    {
        int choice = 0;
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
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
    
    public static void addCon(List<Customer> custList)
    {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        String s = generateCID(custList, 2);
        String name;
        String add;
        System.out.println("\nCustomer ID: " + s);
        System.out.print("Name : ");
        name = scanner.next();
        System.out.print("Address : ");
        add = scanner.next();
        
        custList.add(new Customer(s, name, add, "Consumer"));
        System.out.println("The customer register successfully!\n");
    }
    
    public static void addCor(List<Customer> custList)
    {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        String s = generateCID(custList, 1);
        String name;
        String add;
        double credit;
        String companyName;
        String contactNo;
        
        System.out.println("\nCustomer ID: " + s);
        System.out.print("Name : ");
        name = scanner.next();
        System.out.print("Address : ");
        add = scanner.next();
        System.out.print("Credit : RM ");
        //credit = scanner.nextDouble();
        
        while(!scanner.hasNext("\\s*(?=.*[1-9])\\d*(?:\\.\\d{1,2})?\\s*$"))
        {
            System.err.println("Please enter digit");
            System.out.print("Credit : RM ");
            scanner.next();
        }
        credit = scanner.nextDouble();
        
        System.out.print("Company Name: ");
        companyName = scanner.next();
        System.out.print("Contact No: ");
        contactNo = scanner.next();
        
        custList.add(new CorporateCust(s, name, add, "Corporate", credit, companyName, contactNo));
        System.out.println("The customer register successfully!\n");
    }
    
    // generate customer id
    public static String generateCID(List<Customer> custList, int type)
    {
        int count=0;
        for(Customer c: custList)
        {
            count++;
        }
        
        if(type == 1)
            return String.format("Cr%04d", ++count);
        else
            return String.format("Cn%04d", ++count);
    }
    
    // print all customer information
    public static void viewCust(List<Customer> custList)
    {
        for(Customer c: custList)
        {
            if(c.getcType().equals("Consumer"))
            {
                System.out.print("Consumer List\n=============");
                System.out.println(c);
            }
        }
        for(Customer c: custList)
        {
            if(c.getcType().equals("Corporate"))
            {
                System.out.print("\nCorporate List\n==============");
                System.out.println(c);
            }
        } 
    }
    
    public static void viewConCust(List<Customer> custList)
    {
        for(Customer c: custList)
        {
            if(c.getcType().equals("Consumer"))
                System.out.println(c);
        }
    }
    
    public static void viewCorCust(List<Customer> custList)
    {
        for(Customer c: custList)
        {
            if(c.getcType().equals("Corporate"))
                System.out.println(c);
        }
    }
    
    public static void editCust(List<Customer> custList)
    {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        
        String id;
        int choice;
        
        System.out.print("Enter customer ID: ");
        id = scanner.next();
        
        for(Customer c: custList)
        {
            if(c.getId().equals(id))
            {
                if(c.getcType().equals("Corporate"))
                {
                // name, address, credit limit, companyname, contact num12
                choice = CorEMenu();
                switch(choice)
                {
                    case 1: System.out.println("Name: "+c.getName());
                            System.out.print("Enter new customer name: ");
                            c.setName(scanner.next());
                            break;
                    case 2: System.out.println("Address: "+c.getAddress());
                            System.out.print("Enter new customer address: ");
                            c.setAddress(scanner.next());
                            break;
                    case 3: System.out.println("Credit Limit: RM "+((CorporateCust)c).getCredit());
                            System.out.print("Enter the credit for the corporate customer: RM ");
                            while(!scanner.hasNext("\\s*(?=.*[1-9])\\d*(?:\\.\\d{1,2})?\\s*$"))
                            {
                                System.err.println("Please enter digit");
                                System.out.println("Credit Limit: RM "+((CorporateCust)c).getCredit());
                                System.out.print("Enter the credit for the corporate customer: RM ");
                                scanner.next();
                            }
                            ((CorporateCust)c).setCredit(scanner.nextDouble());
                            break;
                    case 4: System.out.println("Company Name: "+((CorporateCust)c).getCompanyName());
                            System.out.print("Enter new company name: ");
                            ((CorporateCust)c).setCompanyName(scanner.next());
                            break;
                    case 5: System.out.println("Contact No: "+((CorporateCust)c).getContactNo());
                            System.out.print("Enter new contact number: ");
                            ((CorporateCust)c).setContactNo(scanner.next());
                            break;
                    case 6: System.out.println("Name: "+c.getName());
                            System.out.print("Enter new customer name: ");
                            c.setName(scanner.next());
                            System.out.println("Address: "+c.getAddress());
                            System.out.print("Enter new customer address: ");
                            c.setAddress(scanner.next());
                            System.out.println("Credit Limit: RM "+((CorporateCust)c).getCredit());
                            System.out.print("Enter the credit for the corporate customer: RM ");
                            while(!scanner.hasNext("\\s*(?=.*[1-9])\\d*(?:\\.\\d{1,2})?\\s*$"))
                            {
                                System.err.println("Please enter digit");
                                System.out.println("Credit Limit: RM "+((CorporateCust)c).getCredit());
                                System.out.print("Enter the credit for the corporate customer: RM ");
                                scanner.next();
                            }
                            ((CorporateCust)c).setCredit(scanner.nextDouble());
                            System.out.println("Company Name: "+((CorporateCust)c).getCompanyName());
                            System.out.print("Enter new company name: ");
                            ((CorporateCust)c).setCompanyName(scanner.next());
                            System.out.println("Contact No: "+((CorporateCust)c).getContactNo());
                            System.out.print("Enter new contact number: ");
                            ((CorporateCust)c).setContactNo(scanner.next());
                            break;
                }
                }
                else
                {
                    choice = ConEMenu();
                    switch(choice)
                    {
                    case 1: System.out.println("Name: "+c.getName());
                            System.out.print("Enter new customer name: ");
                            c.setName(scanner.next());
                            break;
                    case 2: System.out.println("Address: "+c.getAddress());
                            System.out.print("Enter new customer address: ");
                            c.setAddress(scanner.next());
                            break;
                    case 3: System.out.println("Name: "+c.getName());
                            System.out.print("Enter new customer name: ");
                            c.setName(scanner.next());
                            System.out.println("Address: "+c.getAddress());
                            System.out.print("Enter new customer address: ");
                            c.setAddress(scanner.next());
                            break;
                    }
                }
            }
        }
    }
    
    // corporate edit
    public static int CorEMenu()
    {
        int choice=0;
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.println("\nCustomer Modification");
        System.out.println("1. Modify name");
        System.out.println("2. Modify address");
        System.out.println("3. Modify credit limit");
        System.out.println("4. Modify company name");
        System.out.println("5. Modify contact number");
        System.out.println("5. Modify corporate customer informations");
        System.out.println("7. Exit");
        System.out.print("Enter your selection: ");
         
        while(!scanner.hasNext("[1-7]{1}"))
        {
            System.err.print("Please enter digit");
            System.out.print("Enter your selection: ");
            scanner.next();
        }
        choice = scanner.nextInt();
        return choice;
    }
    
    // consumer edit
    public static int ConEMenu()
    {
        int choice=0;
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.println("\nCustomer Modification");
        System.out.println("1. Modify name");
        System.out.println("2. Modify address");
        System.out.println("3. Modify consumer customer informations");
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
    
}
