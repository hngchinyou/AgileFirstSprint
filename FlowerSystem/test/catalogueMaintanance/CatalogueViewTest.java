/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogueMaintanance;

import entity.Flower2;
import entity.Promotion;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class CatalogueViewTest {
    
    public CatalogueViewTest() {
    }
    
    
    @Test
    public void testViewPromotion() {
        System.out.println("ViewPromotion");
        List<Promotion> promotion = new ArrayList<>();
        promotion.add(new Promotion("P1111", "Green Plant", "asdasdasdasd",12.20, 5));
        promotion.add(new Promotion("P1112", "Lover Day", "asdasdasdasd",13.20, 5));
        promotion.add(new Promotion("P1113", "Sun Shine", "asdasdasdasd",14.20, 5));
        catalogueMaintanance.CataloguePromotion.addPromotion(promotion, "P1111", "Clover", "Clover", 12, 12);
        int result = catalogueMaintanance.CatalogueView.ViewPromotion(promotion);
        int varible = 1;
        assertEquals(varible, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
