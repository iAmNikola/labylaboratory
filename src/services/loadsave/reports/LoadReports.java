package services.loadsave.reports;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import entities.Report;
import entities.users.Patient;
import services.loadsave.users.LoadUsers;

public class LoadReports {
	public static ArrayList<Report> reportsList = new ArrayList<Report>();
	
	public static void loadReports() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("data/reports.txt"), "utf-8"));
			String data;
			while((data = in.readLine()) != null) {
				if (data.equals("")) {
					continue;
				}
				String[] tokens = data.split(";");
				Report r = new Report(tokens[0],tokens[1],tokens[2].split(","),tokens[3].split(","), tokens[4], tokens[5]);
				LoadReports.reportsList.add(r);
			}
			in.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int technicianReports(String tech) {
		int i = 0;
		for (Report r : reportsList) {
			if (r.getTechnician().equals(tech)) {
				i++;
			}
		}
		return i;
	}

	public static ArrayList<Report> getPatientReports(String lbo) throws NumberFormatException{
		ArrayList<Patient> patient = LoadUsers.getPatients();
		ArrayList<Report> ret = new ArrayList<Report>();
		for (Patient p : patient) {
			if (p.getLbo() == Long.parseLong(lbo)) {
				for (Report r : reportsList) {
					for (Integer i : p.getReportsList()) {
						if (i == r.getId()) {
							ret.add(r);
						}
					}
				}
			}
		}
		return ret;
	}
	
	public static ArrayList<Report> getLaborantReports(){
		ArrayList<Report> ret = new ArrayList<Report>();
		for (Report r : reportsList) {
			if (!r.getTechnician().equals("")) {
				ret.add(r);
			}
		}
		return ret;
	}
	
	public static ArrayList<Report> getTechnicianReports(){
		ArrayList<Report> ret = new ArrayList<Report>();
		for (Report r : reportsList) {
			if (r.getTechnician().equals("")) {
				ret.add(r);
			}
		}
		return ret;
	}
}
