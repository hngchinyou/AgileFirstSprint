/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import custMaintenanceNPayment.mLinkedInterface;

/**
 *
 * @author Kuma
 */
public class CorporateCust extends Customer{
    private double credit;
    private String companyName;
    private String contactNo;
    private Customer cust;

    public CorporateCust(Customer cust, double credit) {
        super(cust.getId(), cust.getName(), cust.getAddress(), cust.getcType());
        this.credit = credit;
    }

    public CorporateCust(String id, String name, String address, String cType, 
            double credit, String companyName, String contactNo) {
        super(id, name, address, cType);
        this.credit = credit;
        this.companyName = companyName;
        this.contactNo = contactNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public CorporateCust(String id, String name, String address, String cType) {
        super(id, name, address, cType);
    }
    
    public CorporateCust(String id, String name, String address, String cType, double credit) {
        super(id, name, address, cType);
        this.credit = credit;
    }

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }
    
    public CorporateCust() {
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    
    public String toString() {
        return  super.toString() + "\nCredit = " + String.format("RM %.2f", credit)
                + "\nCompany Name: " + companyName + "\nContact No: "
                + contactNo + "\n================================\n";
    }
    
    
}
