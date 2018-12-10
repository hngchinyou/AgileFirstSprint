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
public class CorporateCustTest {
    CorporateCust c = new CorporateCust("Cr0003", "yohku", "lkj", "Corporate", 5000, "yohku", "0123456789");
    public CorporateCustTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getCompanyName method, of class CorporateCust.
     */
    @Test
    public void testGetCompanyName() {
        System.out.println("getCompanyName");
        //CorporateCust instance = new CorporateCust();
        String expResult = "yohku";
        String result = c.getCompanyName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCompanyName method, of class CorporateCust.
     */
    @Test
    public void testSetCompanyName() {
        System.out.println("setCompanyName");
        String companyName = "lkjlkj";
        //CorporateCust instance = new CorporateCust();
        c.setCompanyName(companyName);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getContactNo method, of class CorporateCust.
     */
    @Test
    public void testGetContactNo() {
        System.out.println("getContactNo");
        CorporateCust instance = new CorporateCust();
        String expResult = "0123456789";
        String result = c.getContactNo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setContactNo method, of class CorporateCust.
     */
    @Test
    public void testSetContactNo() {
        System.out.println("setContactNo");
        String contactNo = "0124567893";
        //CorporateCust instance = new CorporateCust();
        c.setContactNo(contactNo);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCust method, of class CorporateCust.
     */
    @Test
    public void testGetCust() {
        System.out.println("getCust");
        //CorporateCust instance = new CorporateCust();
        Customer expResult = null;
        Customer result = c.getCust();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCust method, of class CorporateCust.
     */
    @Test
    public void testSetCust() {
        System.out.println("setCust");
        Customer cust = new CorporateCust("Cr0004", "kuma", "lkjlkj", "Consumer");
        //CorporateCust instance = ;
        c.setCust(cust);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCredit method, of class CorporateCust.
     */
    @Test
    public void testGetCredit() {
        System.out.println("getCredit");
        //CorporateCust instance = new CorporateCust();
        double expResult = 5000;
        double result = c.getCredit();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCredit method, of class CorporateCust.
     */
    @Test
    public void testSetCredit() {
        System.out.println("setCredit");
        double credit = 4000;
        //CorporateCust instance = new CorporateCust();
        c.setCredit(credit);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class CorporateCust.
     */
    /*@Test
    public void testToString() {
        System.out.println("toString");
        CorporateCust instance = new CorporateCust();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
