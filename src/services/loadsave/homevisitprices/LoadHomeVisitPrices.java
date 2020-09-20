package services.loadsave.homevisitprices;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import entities.HomeVisitPrices;

public class LoadHomeVisitPrices {
	
	public static HomeVisitPrices homeVisitPrices;
	
	public static void loadHomeVisitPrices() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("data/homevisitprices.txt"), "utf-8"));
			String date;
			String datetime;
			
			date = in.readLine();
			datetime = in.readLine();
			
			LoadHomeVisitPrices.homeVisitPrices = new HomeVisitPrices(date, datetime);
			
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
