/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kuma
 */
public class CustomerTest {
    Customer c = new Customer("Cn0003", "yohku", "lkj", "Consumer");
    public CustomerTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getId method, of class Customer.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
       // Customer instance = new Customer();
        String expResult = "Cn0003";
        String result = c.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Customer.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "Cn0004";
       // Customer instance = new Customer();
        c.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Customer.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
    //    Customer instance = new Customer();
        String expResult = "yohku";
        String result = c.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Customer.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "aaa";
        //Customer instance = new Customer();
        c.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class Customer.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        //Customer instance = new Customer();
        String expResult = "lkj";
        String result = c.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setAddress method, of class Customer.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "ccc";
       // Customer instance = new Customer();
        c.setAddress(address);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getcType method, of class Customer.
     */
    @Test
    public void testGetcType() {
        System.out.println("getcType");
        //Customer instance = new Customer();
        String expResult = "Consumer";
        String result = c.getcType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setcType method, of class Customer.
     */
    @Test
    public void testSetcType() {
        System.out.println("setcType");
        String cType = "sss";
       // Customer instance = new Customer();
        c.setcType(cType);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Customer.
     */
  //  @Test
//    public void testToString() {
//        System.out.println("toString");
//        Customer instance = new Customer();
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
