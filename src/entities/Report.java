package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;

import entities.users.Patient;
import entities.users.User;
import services.loadsave.analysistypes.LoadAnalysisTypes;
import services.loadsave.reports.LoadReports;
import services.loadsave.users.LoadUsers;

public class Report {

	private int id;
	private String technician;
	private int[] analysis; //id analiza
	private double[] results; //vrednost analiza(def = 0.0)
	private LocalDateTime date;
	private double price;
	
	//def
	public Report() {
		id = 0;
		technician = "";
		analysis = new int[]{};
		results = new double[]{};
		date = LocalDateTime.now();
		price = 0;
	}
	
	
	//patient creates
	public Report(int[] analysis, String date, double price) throws DateTimeParseException{
		this.id = LoadReports.reportsList.size()+1;
		this.technician = "";
		this.analysis = analysis;
		this.results = new double[this.analysis.length];
		this.setDate(date);
		this.price = price;
	}
	
	//tech creates
	public Report(String technician, int[] analysis, double price) {
		this.id = LoadReports.reportsList.size()+1;
		this.technician = technician;
		this.analysis = analysis;
		this.results = new double[this.analysis.length];
		this.date = LocalDateTime.now();
		this.price = price;
	}
	
	//loaded report
	public Report(String id, String technician, String[] analysis, String[] results, String date, String price) {
		this.id = Integer.parseInt(id);
		this.technician = technician;
		this.setAnalysis(analysis); 
		this.setResults(results);
		this.setDate(date);
		this.setPrice(price);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTechnician() {
		return technician;
	}
	public void setTechnician(String technician) {
		this.technician = technician;
	}
	public int[] getAnalysis() {
		return analysis;
	}
	public void setAnalysis(String[] analysis) {
		int[] a = new int[analysis.length];
		for (int i = 0; i < analysis.length; i++) {
			a[i] = Integer.parseInt(analysis[i]);
		}
		this.analysis = a;
	}
	public double[] getResults() {
		return results;
	}
	public void setResults(String[] results) throws NumberFormatException {
		double[] r = new double[results.length];
		for (int i = 0; i < results.length; i++) {
			r[i] = Double.parseDouble(results[i]);
		}
		this.results = r;
	}	
	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(String date) throws DateTimeParseException {
		DateTimeFormatter formatter = new DateTimeFormatterBuilder()
		        .appendPattern("d.MM.yyyy.[ HH:mm:ss]")
		        .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
		        .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
		        .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
		        .toFormatter();
		LocalDateTime d = LocalDateTime.parse(date, formatter);
		this.date = d;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = Double.parseDouble(price);
	}

	public String saveFormating() {
		String d = ";";
		String a = "";
		boolean check = false;
		for (Integer i : this.analysis) {
			if (check) {
				a+=",";
			}
			a+=i;
			check = true;
		}
		String r = "";
		check = false;
		for (Double x : this.results) {
			if (check) {
				r+=",";
			}
			String dd = String.format("%.1f", x);
			r+=dd;
			check = true;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm:ss");
		String date = this.date.format(formatter);
		String p = String.valueOf(this.price);
		String s = this.id +d+ this.technician +d+ a +d+ r +d+ date +d+ p;
		return s;
	}
	
	private String getName(int id) {
		for (User u : LoadUsers.usersList) {
			if (u instanceof Patient) {
				Patient p = (Patient) u;
				for (int i : p.getReportsList()) {
					if(id == i) {
						return p.getName();
					}
				}
			}
		}
		return null;
	}
	
	private String getLastName(int id) {
		for (User u : LoadUsers.usersList) {
			if (u instanceof Patient) {
				Patient p = (Patient) u;
				for (int i : p.getReportsList()) {
					if(id == i) {
						return p.getLastName();
					}
				}
			}
		}
		return null;
	}

	public Object toCell(int col) {
		switch(col) {
		case 0: return id;
		case 1: return getName(id);
		case 2: return getLastName(id);
		case 3: return analysis.length;
		case 4: return price;
		default: return null;
		}
	}

	public Object toCell(int id, int col) {
		if (id == 0) {
			return null;
		}
		switch(col) {
		case 0: return LoadAnalysisTypes.analysisTypesList.get(id-1).getGroup();
		case 1: return LoadAnalysisTypes.analysisTypesList.get(id-1).getType();
		case 2: return date.toLocalDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy."));
		case 3: {int x = 0; for (int i = 0; i < analysis.length; i++) {if (analysis[i] == id) {x = i;break;}} return results[x];}
		case 4: return LoadAnalysisTypes.analysisTypesList.get(id-1).getLow();
		case 5: return LoadAnalysisTypes.analysisTypesList.get(id-1).getHigh();
		case 6: return LoadAnalysisTypes.analysisTypesList.get(id-1).getPrice();
		default: return null;
		}
	}
	
	public String toString() {
		String s;
		if(id == 0) {
			s = "";
        } else {
        	s = "Report: "+ id +", "+ date.toLocalDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy."))+", "+analysis.length;
        }
		return s;
	}
}
