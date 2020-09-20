package services.loadsave.saveanalysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.format.DateTimeFormatter;


import entities.Report;
import services.loadsave.analysistypes.LoadAnalysisTypes;

public class SaveAnalysis {
	
	public static void saveAnalysis(Report r) {
		try {
			String s = "reports/report_"+r.getId()+".txt";
			File file = new File(s);
			String t = ", ";
			PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(s),"utf-8"));
			for (int i = 0; i < r.getAnalysis().length; i++) {
				String f = LoadAnalysisTypes.analysisTypesList.get(r.getAnalysis()[i]-1).getGroup()
						   +t+ LoadAnalysisTypes.analysisTypesList.get(r.getAnalysis()[i]-1).getType()
						   +t+ r.getDate().toLocalDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy."))
						   +t+ r.getResults()[i] +t+ LoadAnalysisTypes.analysisTypesList.get(r.getAnalysis()[i]-1).getLow()
						   +t+ LoadAnalysisTypes.analysisTypesList.get(r.getAnalysis()[i]-1).getHigh()
						   +t+ LoadAnalysisTypes.analysisTypesList.get(r.getAnalysis()[i]-1).getPrice();
				out.println(f);
			}
			out.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
