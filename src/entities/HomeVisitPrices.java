package entities;

public class HomeVisitPrices {
	
	private double date;
	private double datetime;
	private double temp;
	
	public HomeVisitPrices(String date, String datetime) {
		this.date = Double.parseDouble(date);
		this.datetime = Double.parseDouble(datetime);
	}

	public double getDate() {
		return date;
	}
	public void setDate(String date) throws NumberFormatException {
		this.date = Double.parseDouble(date);
	}
	public double getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) throws NumberFormatException {
		this.datetime = Double.parseDouble(datetime);
	}
	
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}

	public String[] saveFormating() {
		String lab = String.format("%.1f", this.date);
		String tech = String.format("%.1f", this.datetime);
		String[] s = {lab, tech};
		return s;
	}
}
