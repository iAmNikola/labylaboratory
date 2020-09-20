package services.loadsave.analysistypes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import entities.Analysis;

public class LoadAnalysisTypes {
	public static ArrayList<Analysis> analysisTypesList = new ArrayList<Analysis>();
	
	public static void loadAnalysisTypes() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("data/analysistypes.txt"), "utf-8"));
			String data;
			while((data = in.readLine()) != null) {
				if (data.equals("")) {
					continue;
				}
				String[] tokens = data.split(";");
				Analysis a = new Analysis(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6]);
				LoadAnalysisTypes.analysisTypesList.add(a);
				
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
}
	
	
	
	
	
	