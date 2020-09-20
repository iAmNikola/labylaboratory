package services.loadsave.coefficientbonus;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import entities.Bonuses;
import entities.Coefficients;

public class LoadCoefficientBonus {

	public static Coefficients coefficients;
	public static Bonuses bonuses;
	
	public static void loadCoefficientBonuses() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("data/coefficientbonus.txt"), "utf-8"));
			String lab;
			String tech;
			
			lab = in.readLine();
			tech = in.readLine();
			LoadCoefficientBonus.coefficients = new Coefficients(lab, tech);
			
			lab = in.readLine();
			tech = in.readLine();
			LoadCoefficientBonus.bonuses = new Bonuses(lab, tech);
			
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
