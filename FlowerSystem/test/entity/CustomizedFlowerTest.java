package entity;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.junit.Test;

public class CustomizedFlowerTest {
	ArrayList<String> floType = new ArrayList<>(Arrays.asList("Clover"));
	ArrayList<String> accessory = new ArrayList<>(Arrays.asList("Bear"));
	CustomizedFlower flower=new CustomizedFlower("Vertical", "Big", "CF0001", "Processing", floType, accessory, 1, "Cr0002",new Date());

	@Test
	public void testCalculateSize() {
		double expected=5.00;
		double actual;

		if(flower.getSize().equals("Big")) {
			actual=5.00;
		}
		else if(flower.getSize().equals("Medium")) {
			actual=3.00;
		}
		else {
			actual=1.00;
		}
		
		assertEquals(expected, actual,0.0);
	}

	@Test
	public void testCalculatePriority() {
		double expected=10;
		double actual=0;
		switch (flower.getPriorLevel()) {
		case 1:
			actual=10;
			break;
		case 2:
			actual=8;
			break;
		case 3:
			actual=5;
			break;
		default:
			break;
		}
		
		assertEquals(expected, actual,0.0);
	}

	@Test
	public void testGetFloArrangeType() {
		String expected="Vertical";
		String actual=flower.getFloArrangeType();
		
		assertEquals(expected, actual);
	}

	@Test
	public void testSetFloArrangeType() {
		flower.setFloArrangeType("Vertical2");
	}

	@Test
	public void testGetSize() {
		String expected="Big";
		String actual=flower.getSize();
		
		assertEquals(expected, actual);
	}

	@Test
	public void testSetSize() {
		flower.setSize("Medium");
	}

	@Test
	public void testGetCustomizedId() {
		String expected="CF0001";
		String actual=flower.getCustomizedId();
		
		assertEquals(expected, actual);
	}

	@Test
	public void testSetCustomizedId() {
		flower.setCustomizedId("CF0002");
	}

	@Test
	public void testGetStatus() {
		String expected="Processing";
		String actual=flower.getStatus();
		
		assertEquals(expected, actual);
	}

	@Test
	public void testSetStatus() {
		flower.setStatus("Completed");
	}

	@Test
	public void testGetFloType() {
		ArrayList<String> expected=floType;
		ArrayList<String> actual=flower.getFloType();
		
		assertEquals(expected, actual);
	}

	@Test
	public void testSetFloType() {
		ArrayList<String> newFloType=new ArrayList<>(Arrays.asList("Cherry"));
		flower.setFloType(newFloType);
	}

	@Test
	public void testGetAccessory() {
		ArrayList<String> expected= new ArrayList<>(Arrays.asList("Bear"));
		ArrayList<String> actual=flower.getAccessory();
		
		assertEquals(expected, actual);
		
	}

	@Test
	public void testSetAccessory() {
		ArrayList<String> newAccessory= new ArrayList<>(Arrays.asList("Card"));
		flower.setAccessory(newAccessory);
	}

	@Test
	public void testGetPriorLevel() {
		int expected=1;
		int actual=flower.getPriorLevel();
		
		assertEquals(expected, actual);
	}

	@Test
	public void testSetPriorLevel() {
		flower.setPriorLevel(2);
	}

	@Test
	public void testGetCustomerId() {
		String expected="Cr0002";
		String actual=flower.getCustomerId();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetCustomerId() {
		flower.setCustomerId("Cn0001");
	}

	@Test
	public void testGetPickupDate() {
		Date expected=new Date();
		Date actual=flower.getPickupDate();
		
		assertEquals(expected, actual);
	}

	@Test
	public void testSetPickupDate() {
		Date newDate=new Date();
		flower.setPickupDate(newDate);
	}

}
