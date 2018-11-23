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
public class Customer{
    private String id;
    private String name;
    private String address;
    private String cType;

    public Customer(String id, String name, String address, String cType) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cType = cType;
    }
    
    public Customer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    @Override
    public String toString() {
        return "Customer ID = " + id + "\nName = " + name + "\nAddress = " + address + "\nCustomer Type = " + cType;
    }

    

    
    
    
}
