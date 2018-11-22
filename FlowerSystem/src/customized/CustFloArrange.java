package customized;

import java.util.ArrayList;
import java.util.Scanner;

import entity.CustomizedFlower;

public class CustFloArrange {
	public static void custFloArrange() {
		//declaration
		ArrayList<CustomizedFlower> flowerList = new ArrayList<>();
		CustomizedFlower flower=new CustomizedFlower();
		Scanner scanner = new Scanner(System.in);
		String[] floArangeType = {"Elliptical","Vertical","Horizontal","Triangular","crescent","S' shaped","oval shaped","cascade"}
		,size= {"Big","Medium","Small"},floType= {"Rose","Sunflower"},accessory= {"Bear","Card"};
		ArrayList<Integer> buffer;
		String respond="";
		int maxFloType=0,maxAccessory=0,selected;
		
		do {
			//first step
			System.out.println("First, select the flower arrangement style. [only accept 1-"+floArangeType.length+"]");
			for(int i=1;i<=floArangeType.length;i++) {
				System.out.println(i+". "+floArangeType[i-1]);
			}
			while(!scanner.hasNextInt()||!scanner.hasNext("[1-"+floArangeType.length+"]")) {
				scanner.next();
				System.err.println("Invalid input. Please input again (only accept[1-"+floArangeType.length+"])");
			}
			flower.setFloArrangeType(scanner.nextInt());
			
			//second step
			System.out.println("Second, select the flower size. [only accept 1-"+size.length+"]");
			for(int i=1;i<=size.length;i++) {
				System.out.println(i+". "+size[i-1]);
			}
			while(!scanner.hasNextInt()||!scanner.hasNext("[1-"+size.length+"]")) {
				scanner.next();
				System.err.println("Invalid input. Please input again (only accept[1-"+size.length+"])");
			}
			flower.setSize(scanner.nextInt());
			
			switch (flower.getSize()) {
			case 1:
				maxFloType=10;
				maxAccessory=5;
				break;
			case 2:
				maxFloType=8;
				maxAccessory=3;
				break;
			case 3:
				maxFloType=5;
				maxAccessory=2;
				break;
			default:
				break;
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
			
			flowerList.add(flower);
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
}
