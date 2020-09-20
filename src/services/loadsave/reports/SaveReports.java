package services.loadsave.reports;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import entities.Report;

public class SaveReports {

	public static void saveReports() {
		try {
			PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("data/reports.txt"),"utf-8"));
			for (Report r : LoadReports.reportsList) {
				String s = r.saveFormating();
				out.println(s);
			}
			out.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
