package entity;
import java.util.ArrayList;
import java.util.List;

public class CustomizedFlower {
	String floArrangeType,size;
	ArrayList<String> floType,accessory;
	int priorLevel;
	
	public String toString(List<Flower2> floType) {
		String result="Flower Arrangement Type: " + floArrangeType;
		result+="\nSize: "+ size;
		
		//
                int sizeFloType[] = new int[floType.size()];
		int i=0;
		String resultflo="";
		int a1=0,a2=0,a3=0;
		String resultacc="";
		//
		//
                for(Flower2 f:floType){
                    for(String ftName:this.floType){
                        if(ftName.equalsIgnoreCase(f.getFlowername())){
                            sizeFloType[i]++;
                        }
                    }
                    i++;
                }
                i=0;
                for(int sft:sizeFloType){
                    if(sft!=0){
                        resultflo+= floType.get(i).getFlowername() + " x" + sft + ",";
                    }
                    i++;
                }
//		for(String f: floType)
//		{
//			if(f.equals("Rose"))
//				f1++;
//			else
//				f2++;
//		}
//		if(f1!=0)
//		{
//			resultflo+="Rose x" + f1 + ", ";
//		}
//		if(f2!=0)
//		{
//			resultflo+="Sunflower x" + f2 + ", ";
//		}
		result+="\nFlower Type: " + resultflo;
		//
		//
		for(String a: accessory)
		{
			if(a.equals("Bear"))
				a1++;
			else if(a.equals("Card"))
				a2++;
			else
				a3++;
		}
		if(a1!=0)
			resultacc+="Bear x" + a1 + ", ";
		if(a2!=0)
			resultacc+="Card x" + a2 + ", ";
		if(a3!=0)
			resultacc+="Chocolate x" + a3 + ", ";
		result+="\nAccessory: " + resultacc;
		//
		
		result+="\nPriority Level: ";
		switch (priorLevel) {
		case 1:
			result+="Express";
			break;
		case 2:
			result+="Normal";
			break;
		case 3:
			result+="Flexi";
		default:
			break;
		}
		return result;
	}

	public CustomizedFlower() {
		super();
	}

	public CustomizedFlower(String floArrangeType, String size, ArrayList<String> floType, ArrayList<String> accessory,
			int priorLevel) {
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

	public ArrayList<String> getFloType() {
		return floType;
	}

	public void setFloType(ArrayList<String> floType) {
		this.floType = floType;
	}

	public ArrayList<String> getAccessory() {
		return accessory;
	}

	public void setAccessory(ArrayList<String> accessory) {
		this.accessory = accessory;
	}

	public int getPriorLevel() {
		return priorLevel;
	}

	public void setPriorLevel(int priorLevel) {
		this.priorLevel = priorLevel;
	}
	
}