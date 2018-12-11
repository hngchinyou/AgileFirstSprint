package customized;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import entity.CorporateCust;
import entity.Customer;
import entity.CustomizedFlower;
import entity.Flower2;

public class CustFloArrangeTest {

	@Test
	public void testBillResult() {
		String expected="Customer ID: Cn0001\n" + 
				"--------------------\n" + 
				"Customized Flower ID: CF0001\n" + 
				"1.Flower Arrangement Type: Vertical| RM 10.00\n" + 
				"2.Size: Big| RM 5.00\n" + 
				"3.Flower Type: \n" + 
				"  Clover(16.20) x1| RM 16.20\n" + 
				"4.Accessory: \n" + 
				"  Bear(RM 8.50) x1| RM 8.50\n" + 
				"Priority Level: Express | RM 10.00\n" + 
				"Total: RM 49.70\n";
		String actual="";
		
		String custId = "Cn0001";
		List<Customer> custList = new ArrayList<>();
		custList.add(new Customer("Cn0001", "yohku", "Wangsa Maju", "Consumer"));
		ArrayList<CustomizedFlower> flowerList = new ArrayList<>();
		ArrayList<String> floType = new ArrayList<>(Arrays.asList("Clover"));
		ArrayList<String> accessory = new ArrayList<>(Arrays.asList("Bear"));
		CustomizedFlower custflower = new CustomizedFlower("Vertical", "Big", "CF0001", "Processing", floType,
				accessory, 1, "Cn0001", new Date());
		flowerList.add(custflower);
		List<Flower2> flower = new ArrayList<>();
        flower.add(new Flower2("B1111", "Sun Shine", "asdasdasdasd", "Bouquet", 12.20, 5));
        flower.add(new Flower2("B1112", "Lover Bouquets", "asdasdasdasd", "Bouquet", 13.0, 2));
        flower.add(new Flower2("F1111", "Buttercup", "asdasdasdasd", "Flower", 14.20, 2));
        flower.add(new Flower2("F1112", "Cherry Blosom", "sdaqwefgwre", "Flower", 15.20, 2));
        flower.add(new Flower2("F1113", "Clover", "asdiuqwheasd", "Flower", 16.20, 5));
        
        actual=CustFloArrange.billResult(flower, flowerList, custId);
        
		assertEquals(expected, actual);
	}

}
