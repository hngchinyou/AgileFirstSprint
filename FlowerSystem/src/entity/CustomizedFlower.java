package entity;
import java.util.ArrayList;

public class CustomizedFlower {
	String floArrangeType,size;
	ArrayList<Integer> floType,accessory;
	String priorLevel;
	
	@Override
	public String toString() {
		String result="Flower Arrangement Type: " + floArrangeType;
		result+="\nSize: "+ size;
		result+="\nFlower Type: ";
		for(int i=0;i<floType.size();i++) {
			switch (floType.get(i)) {
			case 1:
				result+="Rose";
				break;
			case 2:
				result+="Sunflower";
				break;
			case 3:
				result+="Chocolate";
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
		result+="\nPriority Level: "+priorLevel;
		return result;
	}

	public CustomizedFlower() {
		super();
	}

	public CustomizedFlower(String floArrangeType, String size, ArrayList<Integer> floType,
			ArrayList<Integer> accessory, String priorLevel) {
		super();
		this.floArrangeType = floArrangeType;
		this.size = size;
		this.floType = floType;
		this.accessory = accessory;
		this.priorLevel = priorLevel;
	}

	public String getFloArrangeType() {
		return floArrangeType;
	}

	public void setFloArrangeType(String floArrangeType) {
		this.floArrangeType = floArrangeType;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
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

	public String getPriorLevel() {
		return priorLevel;
	}

	public void setPriorLevel(String priorLevel) {
		this.priorLevel = priorLevel;
	}
	
	
}