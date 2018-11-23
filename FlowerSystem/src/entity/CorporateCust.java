/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Kuma
 */
public class CorporateCust extends Customer{
    private double credit;
    private Customer cust;

    public CorporateCust(Customer cust, double credit) {
        super(cust.getId(), cust.getName(), cust.getAddress(), cust.getcType());
        this.credit = credit;
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

    @Override
    public String toString() {
        return "\n================================\n" + 
                super.toString() + "\nCredit = " + String.format("RM %.2f", credit)
                + "\n================================\n";
    }
    
    
}
