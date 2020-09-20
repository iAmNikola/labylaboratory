package services.loadsave.analysistypes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import entities.Analysis;

public class SaveAnalysisTypes {
	
	public static void saveAnalysisTypes() {
		try {
			PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("data/analysistypes.txt"),"utf-8"));
			for (Analysis a : LoadAnalysisTypes.analysisTypesList) {
				String s = a.saveFormating();
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
