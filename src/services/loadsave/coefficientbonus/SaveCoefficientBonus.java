package services.loadsave.coefficientbonus;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class SaveCoefficientBonus {

	public static void saveCoefficientBonus() {
		try {
			PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("data/coefficientbonus.txt"),"utf-8"));
			String[] c = LoadCoefficientBonus.coefficients.saveFormating();
			String[] b = LoadCoefficientBonus.bonuses.saveFormating();
			
			out.println(c[0]);
			out.println(c[1]);
			
			out.println(b[0]);
			out.println(b[1]);
			
			out.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
