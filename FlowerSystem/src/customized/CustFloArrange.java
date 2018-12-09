package customized;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import entity.CustomizedFlower;
import entity.Flower2;
import java.util.List;

public class CustFloArrange {
	private static Scanner scanner = new Scanner(System.in);
	private static String[] floArangeType = {"Elliptical","Vertical","Horizontal","Triangular","crescent","S' shaped","oval shaped","cascade"},
			size= {"Big","Medium","Small"},
			//floType= {"Rose","Sunflower"},
			accessory= {"Bear","Card","Chocolate"},
			priorLevel= {"Express","Normal","Flexi"};
	private static ArrayList<CustomizedFlower> flowerList = new ArrayList<>();
	
	public static void custFloArrange(List<Flower2> floType) {
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
	        System.out.println("");
	        switch (choice) {
			case 1:
				customizedFlo(floType);
				break;
			case 2:
				sortCustomizedFlo();
				break;
			default:
				break;
			}
		}while(choice!=3);
		
	}
	
	public static void sortCustomizedFlo() {
		if(!flowerList.isEmpty()) {
			Collections.sort(flowerList, new Comparator<CustomizedFlower>() {

				@Override
				public int compare(CustomizedFlower o1, CustomizedFlower o2) {
					// TODO Auto-generated method stub
					return o1.getPriorLevel() - o2.getPriorLevel();
				}
			});
			for(int i=0;i<flowerList.size();i++) {
				System.out.println("Customized Flower "+(i+1)+"\n"+flowerList.get(i)+"\n");
			}
		}
		else {
			System.err.println("There not have any record in the customized flower order.\n");
		}
	}
	
	public static void customizedFlo(List<Flower2> floType) {
		//declaration
		ArrayList<CustomizedFlower> currentFlowerList = new ArrayList<>();
		CustomizedFlower flower=new CustomizedFlower();
		String respond="";
		int maxFloType=0,maxAccessory=0;
		
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
			
			selectFlower(flower,maxFloType,floType);
		
			selectAccessory(flower, maxAccessory);
			
			selectPrior(flower);
			
			//duplicate flower
			currentFlowerList.add(flower);
			do {
				System.out.println("Do you want to duplicate same customized flower?[Y/N]");
				while(!scanner.hasNext("(Y|N)|(y|n)")) {
					scanner.next();
					System.err.println("Invalid input. Please input again (only accept[Y/N])");
				}
				respond=scanner.next();
				if(respond.equalsIgnoreCase("Y")) {
					currentFlowerList.add(flower);
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
		
		System.out.println("");
		for(int i=0;i<currentFlowerList.size();i++) {
			System.out.println("Customized Flower "+(i+1)+"\n"+currentFlowerList.get(i).toString(floType)+"\n");
		}
		flowerList.addAll(currentFlowerList);
		currentFlowerList.clear();
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

	//third step of customized flower
	public static void selectFlower(CustomizedFlower flower, int maxFloType, List<Flower2> floType) {
		int selected=0;
		String respond="";
		ArrayList<String> buffer = new ArrayList<>();
		do {
			selected++;
			if(selected<=maxFloType) {
				System.out.println("Third, select the flower type. You can select more "+ (maxFloType-selected+1) +" flower type. "+" [only accept number]");
				for(int i=1;i<=floType.size();i++) {
					System.out.println(i+". "+floType.get(i-1).getFlowername());
				}
				while(!scanner.hasNextInt()||!scanner.hasNext("[1-9]")) {
					scanner.next();
					System.err.println("Invalid input. Please input again (only accept number)");
				}
				int choose=scanner.nextInt();
				for(int i=0;i<floType.size();i++) {
					if((choose-1)==i) {
						buffer.add(floType.get(i).getFlowername());
					}
				}
				
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
	}

	//forth step of customized flower
	public static void selectAccessory(CustomizedFlower flower, int maxAccessory) {
		int selected=0;
		String respond="";
		ArrayList<String> buffer = new ArrayList<>();
		
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
				int choose=scanner.nextInt();
				for(int i=0;i<accessory.length;i++) {
					if((choose-1)==i) {
						buffer.add(accessory[i]);
					}
				}
				
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
	}

	//select prior level
	public static void selectPrior(CustomizedFlower flower) {
		System.out.println("Fifth, select the priority level. [only accept 1-3]");
		for(int i=1;i<=priorLevel.length;i++) {
			System.out.println(i+". "+priorLevel[i-1]);
		}
		while(!scanner.hasNextInt()||!scanner.hasNext("[1-"+priorLevel.length+"]")) {
			scanner.next();
			System.err.println("Invalid input. Please input again (only accept[1-"+priorLevel.length+"])");
		}
		flower.setPriorLevel(scanner.nextInt());
	}

}
