package entities;

public class Coefficients {

	private double labCoefficient;
	private double techCoefficient;
	
	public Coefficients(String lab, String tech) {
		this.labCoefficient = Double.parseDouble(lab);
		this.techCoefficient = Double.parseDouble(tech);
	}
	
	public double getLabCoefficient() {
		return labCoefficient;
	}
	public void setLabCoefficient(String labCoefficient) throws NumberFormatException {
		this.labCoefficient = Double.parseDouble(labCoefficient);
	}
	public double getTechCoefficient() {
		return techCoefficient;
	}
	public void setTechCoefficient(String techCoefficient) throws NumberFormatException {
		this.techCoefficient = Double.parseDouble(techCoefficient);
	}

	public String[] saveFormating() {
		String lab = String.format("%.3f", this.labCoefficient);
		String tech = String.format("%.3f", this.techCoefficient);
		String[] s = {lab, tech};
		return s;
	}
}
