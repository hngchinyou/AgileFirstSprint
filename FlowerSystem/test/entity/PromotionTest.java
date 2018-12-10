/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class PromotionTest {
    Promotion p = new Promotion("P1111", "Lover Day", "asd", 12, 12);
    public PromotionTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getProductname method, of class Promotion.
     */
    @Test
    public void testGetProductname() {
        System.out.println("getProductname");
        //Promotion instance = null;
        String expResult = "Lover Day";
        String result = p.getProductname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setProductname method, of class Promotion.
     */
    @Test
    public void testSetProductname() {
        System.out.println("setProductname");
        String productname = "Lover";
        //Promotion instance = null;
        p.setProductname(productname);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Promotion.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        //Promotion instance = null;
        String expResult = "asd";
        String result = p.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Promotion.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "qwe";
        //Promotion instance = null;
        p.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Promotion.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        //Promotion instance = null;
        String expResult = "P1111";
        String result = p.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Promotion.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "P1112";
        //Promotion instance = null;
        p.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class Promotion.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        //Promotion instance = null;
        double expResult = 12;
        double result = p.getPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPrice method, of class Promotion.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        double price = 13;
        //Promotion instance = null;
        p.setPrice(price);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAmount method, of class Promotion.
     */
    @Test
    public void testGetAmount() {
        System.out.println("getAmount");
        //Promotion instance = null;
        int expResult = 12;
        int result = p.getAmount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setAmount method, of class Promotion.
     */
    @Test
    public void testSetAmount() {
        System.out.println("setAmount");
        int amount = 13;
       // Promotion instance = null;
        p.setAmount(amount);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Promotion.
     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        Promotion instance = null;
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
