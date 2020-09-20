package entities.users;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.BadEduInputException;
import exceptions.BadNameInputException;
import exceptions.BadPassInputException;
import exceptions.BadUserInputException;
import services.loadsave.coefficientbonus.LoadCoefficientBonus;
import services.loadsave.reports.LoadReports;

public class Technician extends User {

	private int edu;
	
	private String eduRegex = "^([3-8]{1})$";
	
	//new technician
	public Technician(String username, String password, String name, String lastName, String edu) 
					  throws BadNameInputException, BadUserInputException, BadPassInputException, BadEduInputException {
		this.setName(name);
		this.setLastName(lastName);
		this.setUsername(username);
		this.setPassword(password);
		this.setEdu(edu);
	}
	
	//loaded technician
	public Technician(String username, String password, String name, String lastName, String edu, boolean t) {
		this.name = name;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.edu = Integer.parseInt(edu);
	}

	public int getEdu() {
		return edu;
	}

	public void setEdu(String edu) throws BadEduInputException {
		Pattern p = Pattern.compile(eduRegex);
		Matcher m = p.matcher(edu);
		if (edu.equals("") || !m.matches()) {
			throw new BadEduInputException("Incorrect input.");
		}		
		this.edu = Integer.parseInt(edu);
	}

	@Override
	public String saveFormating() {
		String d = ";";
		String s = this.username +d+ this.password +d+ this.name +d+ this.lastName +d+ this.edu;
		return s;
	}
	
	public Object toCell(int col) {
		switch(col) {
		case 0: return "Technician";
		case 1: return getName();
		case 2: return getLastName();
		case 3: return LoadReports.technicianReports(username);
		case 4: return 400*edu*LoadCoefficientBonus.coefficients.getTechCoefficient()+(LoadReports.technicianReports(username)*LoadCoefficientBonus.bonuses.getTechBonus())/(30*4);
		default: return null;
		}
	}

}
