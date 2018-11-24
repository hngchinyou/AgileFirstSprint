package customized;

import java.util.ArrayList;
import java.util.Scanner;

import entity.CustomizedFlower;

public class CustFloArrange {
	private static Scanner scanner = new Scanner(System.in);
	private static String[] floArangeType = {"Elliptical","Vertical","Horizontal","Triangular","crescent","S' shaped","oval shaped","cascade"},
			size= {"Big","Medium","Small"},
			floType= {"Rose","Sunflower"},
			accessory= {"Bear","Card","Chocolate"},
			priorLevel= {"Express","Normal","Flexi"};
	private static ArrayList<CustomizedFlower> flowerList = new ArrayList<>();
	
	public static void custFloArrange() {
		int choice;
		do {
			System.out.println("Customized Flower Arrangement Menu");
	        System.out.println("==============================================");
	        System.out.println("1.Customized flower");
	        System.out.println("2.Display customized flower by priority");
	        System.out.println("3.Back to Main menu");
	        System.out.println("==============================================");
	        System.out.print("Enter Your Choice: ");
	        while(!scanner.hasNextInt()||!scanner.hasNext("[1-3]")) {
				scanner.next();
				System.err.println("Invalid input. Please input again (only accept[1-3])");
			}
	        choice=scanner.nextInt();
	        switch (choice) {
			case 1:
				customizedFlo();
				break;
			case 2:
				sortCustomizedFlo();
				break;
			default:
				break;
			}
		}while(choice!=6);
		
	}
	
	public static void sortCustomizedFlo() {
		
	}
	
	public static void customizedFlo() {
		//declaration
		ArrayList<CustomizedFlower> currentFlowerList = new ArrayList<>();
		CustomizedFlower flower=new CustomizedFlower();
		ArrayList<Integer> buffer;
		String respond="";
		int maxFloType=0,maxAccessory=0,selected;
		
		do {
			selectFloArrange(flower);
			
			selectSize(flower);
			if(flower.getSize().equals(size[0])) {
				maxFloType=10;
				maxAccessory=5;
			}
			else if(flower.getSize().equals(size[1])) {
				maxFloType=8;
				maxAccessory=3;
			}
			else {
				maxFloType=5;
				maxAccessory=2;
			}
			
			//third step
			selected=0;
			buffer=new ArrayList<>();
			do {
				selected++;
				if(selected<=maxFloType) {
					System.out.println("Third, select the flower type. You can select more "+ (maxFloType-selected+1) +" flower type. "+" [only accept 1-"+floType.length+"]");
					for(int i=1;i<=floType.length;i++) {
						System.out.println(i+". "+floType[i-1]);
					}
					while(!scanner.hasNextInt()||!scanner.hasNext("[1-"+floType.length+"]")) {
						scanner.next();
						System.err.println("Invalid input. Please input again (only accept[1-"+floType.length+"])");
					}
					buffer.add(scanner.nextInt());
					
					if(selected!=maxFloType) {
						System.out.println("Do you want to continue to add more flower type?[Y/N]");
						while(!scanner.hasNext("(Y|N)|(y|n)")) {
							scanner.next();
							System.err.println("Invalid input. Please input again (only accept[Y/N])");
						}
						respond=scanner.next();
					}
					else {
						respond="N";
					}
					
					
				}
				else {
					respond="N";
				}
			}while(respond.equalsIgnoreCase("Y"));
			flower.setFloType(buffer);
			respond="";
			
			//forth step
			selected=0;
			buffer=new ArrayList<>();
			do {
				selected++;
				if(selected<=maxAccessory) {
					System.out.println("Forth, select the accessory. You can select more "+(maxAccessory-selected+1)+" [only accept 1-"+accessory.length+"]");
					for(int i=1;i<=accessory.length;i++) {
						System.out.println(i+". "+accessory[i-1]);
					}
					while(!scanner.hasNextInt()||!scanner.hasNext("[1-"+accessory.length+"]")) {
						scanner.next();
						System.err.println("Invalid input. Please input again (only accept[1-"+accessory.length+"])");
					}
					buffer.add(scanner.nextInt());
					
					if(selected!=maxAccessory) {
						System.out.println("Do you want to continue to add more accessory?[Y/N]");
						while(!scanner.hasNext("(Y|N)|(y|n)")) {
							scanner.next();
							System.err.println("Invalid input. Please input again (only accept[Y/N])");
						}
						respond=scanner.next();
					}
					else {
						respond="N";
					}
				}
				else {
					respond="N";
				}
			}while(respond.equalsIgnoreCase("Y"));
			flower.setAccessory(buffer);
			respond="";
			
			//set prior level
			System.out.println("Fifth, select the priority level. [only accept 1-3]");
			for(int i=1;i<=priorLevel.length;i++) {
				System.out.println(i+". "+priorLevel[i-1]);
			}
			while(!scanner.hasNextInt()||!scanner.hasNext("[1-"+priorLevel.length+"]")) {
				scanner.next();
				System.err.println("Invalid input. Please input again (only accept[1-"+priorLevel.length+"])");
			}
			switch (scanner.nextInt()) {
			case 1:
				flower.setPriorLevel(priorLevel[0]);
				break;
			case 2:
				flower.setPriorLevel(priorLevel[1]);
				break;
			case 3:
				flower.setPriorLevel(priorLevel[2]);
				break;
			default:
				break;
			}
			
			//duplicate flower
			flowerList.add(flower);
			do {
				System.out.println("Do you want to duplicate same customized flower?[Y/N]");
				while(!scanner.hasNext("(Y|N)|(y|n)")) {
					scanner.next();
					System.err.println("Invalid input. Please input again (only accept[Y/N])");
				}
				respond=scanner.next();
				if(respond.equalsIgnoreCase("Y")) {
					flowerList.add(flower);
				}
			}while(respond.equalsIgnoreCase("Y"));
			respond="";
			
			//add more
			System.out.println("Do you want to customize more flower?[Y/N]");
			while(!scanner.hasNext("(Y|N)|(y|n)")) {
				scanner.next();
				System.err.println("Invalid input. Please input again (only accept[Y/N])");
			}
			respond=scanner.next();
			flower=new CustomizedFlower();
		}while(respond.equalsIgnoreCase("Y"));
		
		for(int i=0;i<flowerList.size();i++) {
			System.out.println("Customized Flower "+(i+1)+"\n"+flowerList.get(i)+"\n");
		}
	}
	
	//first step of customized flower
	public static void selectFloArrange(CustomizedFlower flower) {
		//first step
		System.out.println("First, select the flower arrangement style. [only accept 1-"+floArangeType.length+"]");
		for(int i=1;i<=floArangeType.length;i++) {
			System.out.println(i+". "+floArangeType[i-1]);
		}
		while(!scanner.hasNextInt()||!scanner.hasNext("[1-"+floArangeType.length+"]")) {
			scanner.next();
			System.err.println("Invalid input. Please input again (only accept[1-"+floArangeType.length+"])");
		}
		switch (scanner.nextInt()) {
		case 1:
			flower.setFloArrangeType(floArangeType[0]);
			break;
		case 2:
			flower.setFloArrangeType(floArangeType[1]);
			break;
		case 3:
			flower.setFloArrangeType(floArangeType[2]);
			break;
		case 4:
			flower.setFloArrangeType(floArangeType[3]);
			break;
		case 5:
			flower.setFloArrangeType(floArangeType[4]);
			break;
		case 6:
			flower.setFloArrangeType(floArangeType[5]);
			break;
		case 7:
			flower.setFloArrangeType(floArangeType[6]);
			break;
		case 8:
			flower.setFloArrangeType(floArangeType[7]);
			break;
 		default:
			break;
		}
	}
	
	//second step of customized flower
	public static void selectSize(CustomizedFlower flower) {
		System.out.println("Second, select the flower size. [only accept 1-"+size.length+"]");
		for(int i=1;i<=size.length;i++) {
			System.out.println(i+". "+size[i-1]);
		}
		while(!scanner.hasNextInt()||!scanner.hasNext("[1-"+size.length+"]")) {
			scanner.next();
			System.err.println("Invalid input. Please input again (only accept[1-"+size.length+"])");
		}
		switch (scanner.nextInt()) {
		case 1:
			flower.setSize(size[0]);
			break;
		case 2:
			flower.setSize(size[1]);
			break;
		case 3:
			flower.setSize(size[2]);
			break;
 		default:
			break;
		}
	}
}
