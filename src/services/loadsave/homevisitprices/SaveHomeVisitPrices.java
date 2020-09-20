package services.loadsave.homevisitprices;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class SaveHomeVisitPrices {
	
	public static void saveHomeVisitPrices() {
		try {
			PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("data/homevisitprices.txt"),"utf-8"));
			String[] h = LoadHomeVisitPrices.homeVisitPrices.saveFormating();
			
			out.println(h[0]);
			out.println(h[1]);
			
			out.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
