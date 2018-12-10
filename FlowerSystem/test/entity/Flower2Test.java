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
public class Flower2Test {
    Flower2 f = new Flower2("F1111", "Clover", "asd", "Flower", 12, 12);
    public Flower2Test() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of toString method, of class Flower2.
     */
    /*@Test
    public void testToString() {
        System.out.println("toString");
        Flower2 instance = new Flower2();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }8*/

    /**
     * Test of getFlowername method, of class Flower2.
     */
    @Test
    public void testGetFlowername() {
        System.out.println("getFlowername");
        //Flower2 instance = new Flower2();
        String expResult = "Clover";
        String result = f.getFlowername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setFlowername method, of class Flower2.
     */
    @Test
    public void testSetFlowername() {
        System.out.println("setFlowername");
        String flowername = "Black Clover";
        //Flower2 instance = new Flower2();
        f.setFlowername(flowername);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Flower2.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        //Flower2 instance = new Flower2();
        String expResult = "asd";
        String result = f.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Flower2.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "qwe";
        //Flower2 instance = new Flower2();
        f.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class Flower2.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        //Flower2 instance = new Flower2();
        String expResult = "Flower";
        String result = f.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setType method, of class Flower2.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String type = "Bouquet";
        //Flower2 instance = new Flower2();
        f.setType(type);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Flower2.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        //Flower2 instance = new Flower2();
        String expResult = "F1111";
        String result = f.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Flower2.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        String id = "F1112";
        //Flower2 instance = new Flower2();
        f.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class Flower2.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        //Flower2 instance = new Flower2();
        double expResult = 12;
        double result = f.getPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPrice method, of class Flower2.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        double price = 13;
        //Flower2 instance = new Flower2();
        f.setPrice(price);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAmount method, of class Flower2.
     */
    @Test
    public void testGetAmount() {
        System.out.println("getAmount");
        //Flower2 instance = new Flower2();
        int expResult = 12;
        int result = f.getAmount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       //f/ail("The test case is a prototype.");
    }

    /**
     * Test of setAmount method, of class Flower2.
     */
    @Test
    public void testSetAmount() {
        System.out.println("setAmount");
        int amount = 13;
        //Flower2 instance = new Flower2();
        f.setAmount(amount);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
