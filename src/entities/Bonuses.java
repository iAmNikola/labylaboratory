package entities;

public class Bonuses {

	private double labBonus;
	private double techBonus;

	public Bonuses(String lab, String tech) {
		this.labBonus = Double.parseDouble(lab);
		this.techBonus = Double.parseDouble(tech);
	}
	
	public double getLabBonus() {
		return labBonus;
	}
	public void setLabBonus(String labBonus) throws NumberFormatException {
		this.labBonus = Double.parseDouble(labBonus);
	}
	public double getTechBonus() {
		return techBonus;
	}
	public void setTechBonus(String techBonus) throws NumberFormatException {
		this.techBonus = Double.parseDouble(techBonus);
	}

	public String[] saveFormating() {
		String lab = String.format("%.1f", this.labBonus);
		String tech = String.format("%.1f", this.techBonus);
		String[] s = {lab, tech};
		return s;
	}
	
}
