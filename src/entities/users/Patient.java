package entities.users;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entities.Report;
import exceptions.BadLboInputException;
import exceptions.BadNameInputException;
import exceptions.BadPassInputException;
import exceptions.BadPhoneInputException;
import exceptions.BadSexInputException;
import exceptions.BadUserInputException;
import services.loadsave.reports.LoadReports;

public class Patient extends User{

	private long lbo;
	private String sex;
	private LocalDate date;
	private long phone;
	private String address;
	private ArrayList<Integer> reportsList;
	
	private String lboRegex = "^([0-9]{11})$";
	private String phoneRegex = "^([0-9]{10})$";
	

	//new patient
	public Patient(String username, String password, String name, String lastName,
			       String lbo, String sex, String date, String phone, String address) 
			       throws BadNameInputException, BadUserInputException, BadPassInputException,
			       BadLboInputException, BadPhoneInputException, BadSexInputException {
		this.setName(name);
		this.setLastName(lastName);
		this.setUsername(username);
		this.setPassword(password);
		this.setLbo(lbo);
		this.setSex(sex);
		this.setDate(date);
		this.setPhone(phone);
		this.setAddress(address);
		this.reportsList = new ArrayList<Integer>();
	}
	
	//loaded patient
	public Patient(String username, String password, String name, String lastName,
			       String lbo, String sex, String date, String phone, String[] reports, String address) {
		this.name = name;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		try {
			this.setLbo(lbo);
		} catch (BadLboInputException e) {
			e.printStackTrace();
		}
		this.sex = sex;
		this.setDate(date);
		try {
			this.setPhone(phone);
		} catch (BadPhoneInputException e) {
			e.printStackTrace();
		}
		this.setAddress(address);
		this.reportsList = new ArrayList<Integer>();
		for (String s : reports) {
			if (s.equals("")) {
				break;
			}
			reportsList.add(Integer.parseInt(s));
		}
		
	}
	
	public long getLbo() {
		return lbo;
	}
	public void setLbo(String lbo) throws BadLboInputException {
		Pattern p = Pattern.compile(lboRegex);
		Matcher m = p.matcher(lbo);
		if (lbo.equals("") || !m.matches()) {
			throw new BadLboInputException("Incorrect input.");
		}		
		this.lbo = Long.parseLong(lbo);
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) throws BadSexInputException {
		if (sex.equalsIgnoreCase("M") || sex.equalsIgnoreCase("F")) {
			if (sex.equalsIgnoreCase("M")) {
				this.sex = "M";
			} else {
				this.sex = "F";
			}
		} else {
			throw new BadSexInputException("Bad input.");
		}
		this.sex = sex;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(String date) throws DateTimeParseException {
		LocalDate d = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy."));
		this.date = d;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(String phone) throws BadPhoneInputException {
		Pattern p = Pattern.compile(phoneRegex);
		Matcher m = p.matcher(phone);
		if (phone.equals("") || !m.matches()) {
			throw new BadPhoneInputException("Incorrect input.");
		}		
		this.phone = Long.parseLong(phone);
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public ArrayList<Integer> getReportsList() {
		return reportsList;
	}
	public void setReportsList(ArrayList<Integer> reportsList) {
		this.reportsList = reportsList;
	}
	public void addReport(Report r) {
		this.reportsList.add(r.getId());
	}
	
	
	@Override
	public String saveFormating() {
		String d = ";";
		String r = "";
		boolean check = false;
		for (Integer i : this.reportsList) {
			if (check) {
				r+=",";
			}
			r+=i;
			check = true;
		}
		String s = this.username +d+ this.password +d+ this.name +d+ this.lastName +d+ 
				   this.lbo +d+ this.sex +d+ this.date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy.")) +d+
				   this.phone +d+ r +d+ this.address;
		return s;
	}

	private double total() {
		double d = 0;
		for (Integer i : reportsList) {
			for (Report r : LoadReports.reportsList) {
				if(i == r.getId()) {
					d = d + r.getPrice();
				}
			}
		}
		return d;
	}
	
	public Object toCell(int col) {
		switch(col) {
		case 0: return getName();
		case 1: return getLastName();
		case 2: return reportsList.size()-1;
		case 3: return total();
		default: return null;
		}
	}
	
	
}
