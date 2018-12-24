/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custMaintenanceNPayment;

import entity.CorporateCust;
import entity.Customer;
import entity.Order;
import entity.OrderList;
import java.util.ArrayList;
import java.util.Date;
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
    public static void CPmain(mLinkedInterface<Customer> custList, double allOrderPrice, List<OrderList> orderList) {
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
            else if(choice==4)
                IPMenu(custList, allOrderPrice, orderList);
            else if(choice==5)
                Testing(custList);
        }while(choice!=6);
    }
    
    public static void Testing(mLinkedInterface<Customer> custList)
    {
        String id;
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        id = scanner.next();
        
        mLinkedInterface<Customer> cll = new mLinked<>();
        
        for(int i=0; i<custList.size();i++)
        {
            cll.add(custList.get(i));
        }
        
        for(int i=0; i< cll.size(); i++)
        {
            if(cll.get(i).getId().equals(id))
            {
                cll.get(i).setName("testtest");
            }
        }
        
        for(int i=0; i< cll.size(); i++)
        {
            System.out.println(cll.get(i).toString());
        }
    }
 
    public static void classify(mLinkedInterface<Customer> custList)  
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
    
    public static int verifyCT(String name, mLinkedInterface<Customer> custList)
    {
        for(int i=0; i< custList.size();i++)
        {
            if(name.equals(custList.get(i).getName())&& custList.get(i).getcType().equals("Corporate"))
                return 1;
            else if(name.equals(custList.get(i).getName())&& custList.get(i).getcType().equals("Consumer"))
                return 2;
        }
        return 0;
    }
    
    public static void setLimit(mLinkedInterface<Customer> custList)
    {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        String name;
        double credit;
        boolean valid = false;
        
        System.out.print("Please enter the corporate customer name: ");
        name = scanner.next();
        
        for(int i=0;i<custList.size();i++)
        {
            if(name.equals(custList.get(i).getName()) && custList.get(i).getcType().equals("Corporate"))
            {
                System.out.print("Enter the credit for the corporate customer: RM ");
                while(!scanner.hasNext("\\s*(?=.*[1-9])\\d*(?:\\.\\d{1,2})?\\s*$"))
                {
                    System.err.println("Please enter digit");
                    System.out.print("Enter the credit for the corporate customer: RM ");
                    scanner.next();
                }
                credit = scanner.nextDouble();
                
                ((CorporateCust)custList.get(i)).setCredit(credit);
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
        System.out.println("4. Invoice Payment");
        System.out.println("5. Test");
        System.out.println("6. Exit");
        System.out.print("Enter your selection: ");
         
        while(!scanner.hasNext("[1-6]{1}"))
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
    
    public static void addCust(mLinkedInterface<Customer> custList)
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
    
    public static void addCon(mLinkedInterface<Customer> custList)
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
    
    public static void addCor(mLinkedInterface<Customer> custList)
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
    public static String generateCID(mLinkedInterface<Customer> custList, int type)
    {
        int count=0;
        for(int i=0; i<custList.size();i++)
        {
            count++;
        }
        
        if(type == 1)
            return String.format("Cr%04d", ++count);
        else
            return String.format("Cn%04d", ++count);
    }
    
    // print all customer information
    public static void viewCust(mLinkedInterface<Customer> custList)
    {
        for(int i=0;i<custList.size();i++)
        {
            if(custList.get(i).getcType().equals("Consumer"))
            {
                System.out.print("Consumer List\n=============");
                System.out.println(custList.get(i));
            }
        }
        for(int i=0; i<custList.size();i++)
        {
            if(custList.get(i).getcType().equals("Corporate"))
            {
                System.out.print("\nCorporate List\n==============");
                System.out.println(custList.get(i));
            }
        } 
    }
    
    public static void viewConCust(mLinkedInterface<Customer> custList)
    {
        for(int i=0;i<custList.size();i++)
        {
            if(custList.get(i).getcType().equals("Consumer"))
                System.out.println(custList.get(i));
        }
    }
    
    public static void viewCorCust(mLinkedInterface<Customer> custList)
    {
        for(int i=0;i<custList.size();i++)
        {
            if(custList.get(i).getcType().equals("Corporate"))
                System.out.println(custList.get(i));
        }
    }
    
    public static void editCust(mLinkedInterface<Customer> custList)
    {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        
        String id;
        int choice;
        
        System.out.print("Enter customer ID: ");
        id = scanner.next();
        
        for(int i=0;i<custList.size();i++)
        {
            if(custList.get(i).getId().equals(id))
            {
                if(custList.get(i).getcType().equals("Corporate"))
                {
                // name, address, credit limit, companyname, contact num12
                choice = CorEMenu();
                switch(choice)
                {
                    case 1: System.out.println("Name: "+custList.get(i).getName());
                            System.out.print("Enter new customer name: ");
                            custList.get(i).setName(scanner.next());
                            break;
                    case 2: System.out.println("Address: "+custList.get(i).getAddress());
                            System.out.print("Enter new customer address: ");
                            custList.get(i).setAddress(scanner.next());
                            break;
                    case 3: System.out.println("Credit Limit: RM "+((CorporateCust)custList.get(i)).getCredit());
                            System.out.print("Enter the credit for the corporate customer: RM ");
                            while(!scanner.hasNext("\\s*(?=.*[1-9])\\d*(?:\\.\\d{1,2})?\\s*$"))
                            {
                                System.err.println("Please enter digit");
                                System.out.println("Credit Limit: RM "+((CorporateCust)custList.get(i)).getCredit());
                                System.out.print("Enter the credit for the corporate customer: RM ");
                                scanner.next();
                            }
                            ((CorporateCust)custList.get(i)).setCredit(scanner.nextDouble());
                            break;
                    case 4: System.out.println("Company Name: "+((CorporateCust)custList.get(i)).getCompanyName());
                            System.out.print("Enter new company name: ");
                            ((CorporateCust)custList.get(i)).setCompanyName(scanner.next());
                            break;
                    case 5: System.out.println("Contact No: "+((CorporateCust)custList.get(i)).getContactNo());
                            System.out.print("Enter new contact number: ");
                            ((CorporateCust)custList.get(i)).setContactNo(scanner.next());
                            break;
                    case 6: System.out.println("Name: "+custList.get(i).getName());
                            System.out.print("Enter new customer name: ");
                            custList.get(i).setName(scanner.next());
                            System.out.println("Address: "+custList.get(i).getAddress());
                            System.out.print("Enter new customer address: ");
                            custList.get(i).setAddress(scanner.next());
                            System.out.println("Credit Limit: RM "+((CorporateCust)custList.get(i)).getCredit());
                            System.out.print("Enter the credit for the corporate customer: RM ");
                            while(!scanner.hasNext("\\s*(?=.*[1-9])\\d*(?:\\.\\d{1,2})?\\s*$"))
                            {
                                System.err.println("Please enter digit");
                                System.out.println("Credit Limit: RM "+((CorporateCust)custList.get(i)).getCredit());
                                System.out.print("Enter the credit for the corporate customer: RM ");
                                scanner.next();
                            }
                            ((CorporateCust)custList.get(i)).setCredit(scanner.nextDouble());
                            System.out.println("Company Name: "+((CorporateCust)custList.get(i)).getCompanyName());
                            System.out.print("Enter new company name: ");
                            ((CorporateCust)custList.get(i)).setCompanyName(scanner.next());
                            System.out.println("Contact No: "+((CorporateCust)custList.get(i)).getContactNo());
                            System.out.print("Enter new contact number: ");
                            ((CorporateCust)custList.get(i)).setContactNo(scanner.next());
                            break;
                }
                }
                else
                {
                    choice = ConEMenu();
                    switch(choice)
                    {
                    case 1: System.out.println("Name: "+custList.get(i).getName());
                            System.out.print("Enter new customer name: ");
                            custList.get(i).setName(scanner.next());
                            break;
                    case 2: System.out.println("Address: "+custList.get(i).getAddress());
                            System.out.print("Enter new customer address: ");
                            custList.get(i).setAddress(scanner.next());
                            break;
                    case 3: System.out.println("Name: "+custList.get(i).getName());
                            System.out.print("Enter new customer name: ");
                            custList.get(i).setName(scanner.next());
                            System.out.println("Address: "+custList.get(i).getAddress());
                            System.out.print("Enter new customer address: ");
                            custList.get(i).setAddress(scanner.next());
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
        int choice = 0;
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
    
    public static int IPMenu(mLinkedInterface<Customer> custList,double allOrderPrice, List<OrderList> orderList)
    {
        int choice;
        int test=0;
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Invoice Payment Menu");
        System.out.println("1. Invoice Payment");
        //System.out.println("2. Invoice history");
        System.out.println("2. Exit");
        System.out.print("Enter your selection: ");
        
        while(!scanner.hasNext("[1-2]{1}"))
        {
            System.err.print("Please enter digit");
            System.out.print("Enter your selection: ");
            scanner.next();
        }
        choice = scanner.nextInt();
        
        if(choice == 1)
        {
            String id;
            System.out.print("\nEnter customer ID:");
            id = scanner.next();
            
            for(int i=0;i<custList.size();i++)
            {
                if(custList.get(i).getId().equals(id) && custList.get(i).getcType().equals("Corporate"))
                {
                    List<Order> order = new ArrayList<>();
                    int count=0;
                    Date date = new Date();
                    test = sortInvoice(orderList, id, date, order, count, test);
                    double total=0;
                    for(Order o: order)
                    {
                        System.out.println("Order Number: " + o.getOrderNum());
                        System.out.println("Quantity: " + o.getQuantity());
                        System.out.println(String.format("Price: RM %.2f",o.getQuantity()*o.getPrice()));
                        total += o.getQuantity()*o.getPrice();
                    }
                    System.out.println(String.format("\nTotal Payment: RM %.2f", total));
                    System.out.println("The payment paid?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    System.out.print("Enter your selection: ");
                    int choice2;
        
                    while(!scanner.hasNext("[1-2]{1}"))
                    {
                        System.err.print("Please enter digit");
                        System.out.print("Enter your selection: ");
                        scanner.next();
                    }
                    choice2 = scanner.nextInt();
                    changeStatus(choice2, orderList, id, date);
                }
            }//after customer for each loop
        }//after choice == 1
        return test;
    }

    public static int sortInvoice(List<OrderList> orderList, String id, Date date, List<Order> order, int count, int test) {
        for(OrderList ol: orderList)
        {
            if(ol.getCustId().equals(id) && ol.getPickUpDate().getMonth()==date.getMonth()-1)
            {
                for(Order o: ol.getOrderList())
                {
                    if(order.isEmpty())
                    {
                        order.add(new Order(o.getOrderNum(), o.getQuantity(), o.getPrice()));
                    }
                    else
                    {
                        for(Order oo: order)
                        {
                            if(oo.getOrderNum().equals(o.getOrderNum()))
                            {
                                oo.setQuantity(oo.getQuantity()+o.getQuantity());
                                count=1;
                                test=1;
                            }
                        }
                        if(count == 0)
                        {
                            order.add(new Order(o.getOrderNum(), o.getQuantity(), o.getPrice()));
                        }
                    }
                }
            }
        }
        return test;
    }

    public static int changeStatus(int choice2, List<OrderList> orderList, String id, Date date) {
        double allOrderPrice;
        int count =0;
        if(choice2 == 1)
        {
            for(OrderList ol: orderList)
            {
                if(ol.getCustId().equals(id) && ol.getPickUpDate().getMonth()==date.getMonth()-1)
                {
                    ol.setStatus("Paid");
                    allOrderPrice = 0;
                    count = 1;
                }
            }
        }
        return count;
    }
}
