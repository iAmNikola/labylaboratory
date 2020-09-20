package entities.users;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.BadEduInputException;
import exceptions.BadNameInputException;
import exceptions.BadPassInputException;
import exceptions.BadSpecInputException;
import exceptions.BadUserInputException;
import services.loadsave.coefficientbonus.LoadCoefficientBonus;

public class Laborant extends User{

	private int edu;
	private ArrayList<String> specs;
	
	private int analysis;
	
	private String eduRegex = "^([3-8]{1})$";
	
	//new laborant
	public Laborant(String username, String password, String name, String lastName, String edu, String specs)
					throws BadNameInputException, BadUserInputException, BadPassInputException, BadEduInputException, BadSpecInputException {
		this.setName(name);
		this.setLastName(lastName);
		this.setUsername(username);
		this.setPassword(password);
		this.setEdu(edu);
		this.setSpecs(specs);
		this.analysis = 0;
	}
	
	//loaded laborant
	public Laborant(String username, String password, String name, String lastName, String edu, String specs, String analysis) {
		this.name = name;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.edu = Integer.parseInt(edu);
		try {
			this.setSpecs(specs);
		} catch (BadSpecInputException e) {
			e.printStackTrace();
		}
		this.analysis = Integer.parseInt(analysis);
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


	public ArrayList<String> getSpecs() {
		return specs;
	}

	public void setSpecs(String specs) throws BadSpecInputException {
		this.specs = new ArrayList<String>();
		String[] t = specs.split(",");
		boolean v = false;
		boolean h = false;
		boolean b = false;
		boolean h1 = false;
		
		for (String s : t) {
			if (s.trim().equalsIgnoreCase("Vitamini")) {
				this.specs.add("Vitamini");
				if (v) {
					throw new BadSpecInputException("Spec repeats.");
				}
				v = true;
			} else if (s.trim().equalsIgnoreCase("Hormoni")) {
				this.specs.add("Hormoni");
				if (h) {
					throw new BadSpecInputException("Spec repeats.");
				}
				h = true;
			} else if (s.trim().equalsIgnoreCase("Biohemija")) {
				this.specs.add("Biohemija");
				if (b) {
					throw new BadSpecInputException("Spec repeats.");
				}
				b = true;
			} else if (s.trim().equalsIgnoreCase("Hematologija")) {
				this.specs.add("Hematologija");
				if (h1) {
					throw new BadSpecInputException("Spec repeats.");
				}
				h1 = true;
			} else {
				throw new BadSpecInputException("Incorrect input.");
			}
		}
	}

	public void addAnalysis(int i) {
		analysis = analysis + i;
	}
		
	@Override
	public String saveFormating() {
		String d = ";";
		String r = "";
		boolean check = false;
		for (String s : this.specs) {
			if (check) {
				r+=",";
			}
			r+=s;
			check = true;
		}
		String s = this.username +d+ this.password +d+ this.name +d+ this.lastName +d+ this.edu +d+ r +d+ this.analysis;
		return s;
	}

	public Object toCell(int col) {
		switch(col) {
		case 0: return "Laborant";
		case 1: return getName();
		case 2: return getLastName();
		case 3: return analysis;
		case 4: return 400*edu*LoadCoefficientBonus.coefficients.getLabCoefficient()+(specs.size()*LoadCoefficientBonus.bonuses.getLabBonus())/30;
		default: return null;
		}
	}

}
