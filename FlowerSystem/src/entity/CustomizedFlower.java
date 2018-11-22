package entity;
import java.util.ArrayList;

public class CustomizedFlower {
	int floArrangeType,size;
	ArrayList<Integer> floType,accessory;
	
	@Override
	public String toString() {
		String result="Flower Arrangement Type: ";
		switch (floArrangeType) {
		case 1:
			result+="Elliptical";
			break;
		case 2:
			result+="Vertical";
			break;
		case 3:
			result+="Horizontal";
			break;
		case 4:
			result+="Triangular";
			break;
		case 5:
			result+="crescent";
			break;
		case 6:
			result+="S' shaped";
			break;
		case 7:
			result+="oval shaped";
			break;
		case 8:
			result+="cascade";
			break;
 		default:
			break;
		}
		result+="\nSize: ";
		switch (size) {
		case 1:
			result+="big";
			break;
		case 2:
			result+="medium";
			break;
		case 3:
			result+="small";
			break;
 		default:
			break;
		}
		result+="\nFlower Type: ";
		for(int i=0;i<floType.size();i++) {
			switch (floType.get(i)) {
			case 1:
				result+="Rose";
				break;
			case 2:
				result+="Sunflower";
				break;
 			default:
				break;
			}
			if((i+1)<floType.size()) {
				result+=", ";
			}
		}
		result+="\nAccessory: ";
		for(int i=0;i<accessory.size();i++) {
			switch (accessory.get(i)) {
			case 1:
				result+="Bear";
				break;
			case 2:
				result+="Card";
				break;
 			default:
				break;
			}
			if((i+1)<accessory.size()) {
				result+=", ";
			}
		}
		return result;
	}

	public CustomizedFlower() {
		super();
	}

	public CustomizedFlower(int floArrangeType, int size, ArrayList<Integer> floType, ArrayList<Integer> accessory) {
		super();
		this.floArrangeType = floArrangeType;
		this.size = size;
		this.floType = floType;
		this.accessory = accessory;
	}

	public int getFloArrangeType() {
		return floArrangeType;
	}

	public void setFloArrangeType(int floArrangeType) {
		this.floArrangeType = floArrangeType;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public ArrayList<Integer> getFloType() {
		return floType;
	}

	public void setFloType(ArrayList<Integer> floType) {
		this.floType = floType;
	}

	public ArrayList<Integer> getAccessory() {
		return accessory;
	}

	public void setAccessory(ArrayList<Integer> accessory) {
		this.accessory = accessory;
	}
	
}