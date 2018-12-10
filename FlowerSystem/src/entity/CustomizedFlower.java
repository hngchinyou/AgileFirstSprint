package entity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomizedFlower {
	private String floArrangeType,size,customizedId,status;
	private ArrayList<String> floType,accessory;
	private int priorLevel;
	private String customerId;
	private Date pickupDate;
	
	public String toString(List<Flower2> floType) {
		String result="";
		result+="Customer ID: "+customerId;
		result+="\nCustomized Flower ID: " + customizedId;
		result+="\nFlower Arrangement Type: " + floArrangeType;
		result+="\nSize: "+ size;
		
        int sizeFloType[] = new int[floType.size()];
		int i=0;
		String resultflo="";
		int a1=0,a2=0,a3=0;
		String resultacc="";
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
		result+="\nFlower Type: " + resultflo;
		
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
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		result+="\nPickup Date: "+sdf.format(pickupDate);
		result+="\nStatus: "+status;
		return result;
	}

	public CustomizedFlower() {
		super();
	}

	public CustomizedFlower(String floArrangeType, String size, String customizedId, String status,
			ArrayList<String> floType, ArrayList<String> accessory, int priorLevel, String customerId,
			Date pickupDate) {
		super();
		this.floArrangeType = floArrangeType;
		this.size = size;
		this.customizedId = customizedId;
		this.status = status;
		this.floType = floType;
		this.accessory = accessory;
		this.priorLevel = priorLevel;
		this.customerId = customerId;
		this.pickupDate = pickupDate;
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

	public String getCustomizedId() {
		return customizedId;
	}

	public void setCustomizedId(String customizedId) {
		this.customizedId = customizedId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Date getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

	
}