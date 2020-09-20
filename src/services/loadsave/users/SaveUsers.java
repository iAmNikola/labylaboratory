package services.loadsave.users;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import entities.users.User;

public class SaveUsers {

	public static void saveUsers() {
		try {
			PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream("data/users.txt"),"utf-8"));
			for (User u : LoadUsers.usersList) {
				String s = u.saveFormating();
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
