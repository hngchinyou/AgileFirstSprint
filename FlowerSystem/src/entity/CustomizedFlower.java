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
	
	
	public double calculateSize() {
		double sizePrice=0;
		if(size.equals("Big")) {
			sizePrice=5.00;
		}
		else if(size.equals("Medium")) {
			sizePrice=3.00;
		}
		else {
			sizePrice=1.00;
		}
		return sizePrice;
	}
	
	public double calculatePriority(){
		double priorPrice=0;
		switch (priorLevel) {
		case 1:
			priorPrice=10;
			break;
		case 2:
			priorPrice=8;
			break;
		case 3:
			priorPrice=5;
			break;
		default:
			break;
		}
		return priorPrice;
	}
	
	public String displayBill(List<Flower2> floType) {
		String result="";
		double totalFloType=0,totalAccessory=0;
		result+="Customized Flower ID: " + customizedId;
		result+="\n1.Flower Arrangement Type: " + floArrangeType +"| RM 10.00";
		result+="\n2.Size: " + size+ String.format("| RM %.2f", calculateSize());
		
		int sizeFloType[] = new int[floType.size()];
		int i=0;
		String resultflo="";
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
                resultflo+= "  "+floType.get(i).getFlowername()+"("+String.format("%.2f", floType.get(i).getPrice()) + ") x" + sft + "| RM "
            +String.format("%.2f", (floType.get(i).getPrice()*sft))+"\n";
                totalFloType+=floType.get(i).getPrice()*sft;
            }
            i++;
        }
		result+="\n3.Flower Type: \n" + resultflo;
		
		int a1=0,a2=0,a3=0;
		String resultacc="";
		for(String a: accessory)
		{
			if(a.equals("Bear"))
				a1++;
			else if(a.equals("Card"))
				a2++;
			else
				a3++;
		}
		if(a1!=0) {
			resultacc+="  Bear(RM 8.50) x" + a1 + "| RM "+String.format("%.2f", (8.50*a1))+"\n";
			totalAccessory+=8.50*a1;
		}
		if(a2!=0) {
			resultacc+="  Card(RM 3.00) x" + a2 + "| RM "+String.format("%.2f", (3.00*a2))+"\n";
			totalAccessory+=3.00*a2;
		}
		if(a3!=0) {
			resultacc+="  Chocolate(RM 7.00) x" + a3 + "| RM "+String.format("%.2f", (7.00*a3))+"\n";
			totalAccessory+=7.00*a3;
		}
			
		result+="4.Accessory: \n" + resultacc;
		
		result+="Priority Level: ";
		switch (priorLevel) {
		case 1:
			result+="Express | RM "+String.format("%.2f", calculatePriority());
			break;
		case 2:
			result+="Normal| RM "+String.format("%.2f", calculatePriority());
			break;
		case 3:
			result+="Flexi| RM "+String.format("%.2f", calculatePriority());
			break;
		default:
			break;
		}
		result+="\nTotal: RM "+String.format("%.2f", (10+calculateSize()+totalFloType+totalAccessory+calculatePriority()));
		
		return result;
	}
        
        public double getTotalPrice(List<Flower2> floType){
            double total = 0;
            double totalFloType = 0;
            double totalAccessory = 0;

            int sizeFloType[] = new int[floType.size()];
            int i = 0;
            for (Flower2 f : floType) {
                for (String ftName : this.floType) {
                    if (ftName.equalsIgnoreCase(f.getFlowername())) {
                        sizeFloType[i]++;
                    }
                }
                i++;
            }
            i = 0;
            for (int sft : sizeFloType) {
                if (sft != 0) {
                    totalFloType += floType.get(i).getPrice() * sft;
                }
                i++;
            }

            int a1 = 0, a2 = 0, a3 = 0;
            for (String a : accessory) {
                if (a.equals("Bear")) {
                    a1++;
                } else if (a.equals("Card")) {
                    a2++;
                } else {
                    a3++;
                }
            }
            if (a1 != 0) {
                totalAccessory += 8.50 * a1;
            }
            if (a2 != 0) {
                totalAccessory += 3.00 * a2;
            }
            if (a3 != 0) {
                totalAccessory += 7.00 * a3;
            }

            total += 10 + calculateSize() + totalFloType + totalAccessory + calculatePriority();

            return total;
        }
	
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
			break;
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