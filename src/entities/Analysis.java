package entities;

public class Analysis {

	private int id;
	private String type;
	private String group;
	private double low;
	private double high;
	private String unit;
	private double price;
	
	public Analysis(String id, String type, String group, String low, String high, String unit, String price) {
		this.id = Integer.parseInt(id);
		this.type = type;
		this.group = group;
		this.low = Double.parseDouble(low);
		this.high = Double.parseDouble(high);
		this.unit = unit;
		this.price = Double.parseDouble(price);	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String saveFormating() {
		String d = ";";
		String low = String.format("%.1f", this.low);
		String high = String.format("%.1f", this.high);
		String price = String.format("%.1f", this.price);
		String s = this.id +d+ this.type +d+ this.group +d+ low +d+ high +d+ this.unit +d+ price;
		return s;
	}
	
}