package services.loadsave.users;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import entities.users.Admin;
import entities.users.Laborant;
import entities.users.Patient;
import entities.users.Technician;
import entities.users.User;

public class LoadUsers {
	public static ArrayList<User> usersList = new ArrayList<User>();
	
	public static void loadUsers() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("data/users.txt"), "utf-8"));
			String data;
			while((data = in.readLine()) != null) {
				if (data.equals("")) {
					continue;
				}
				String[] tokens = data.split(";");
				if (tokens.length == 4) {
					Admin a = new Admin(tokens[0], tokens[1], tokens[2], tokens[3]);
					LoadUsers.usersList.add(a);
				} else if (tokens.length == 5) {
					Technician t = new Technician(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], true);
					LoadUsers.usersList.add(t);
				} else if (tokens.length == 7) {
					Laborant l = new Laborant(tokens[0], tokens[1], tokens[2], tokens[3],tokens[4], tokens[5], tokens[6]);
					LoadUsers.usersList.add(l);
				} else if (tokens.length == 10) {
					Patient p = new Patient(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6], 
											tokens[7], tokens[8].split(","), tokens[9]);
					LoadUsers.usersList.add(p);
				}
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
	
	public static ArrayList<User> getEmployees(){
		ArrayList<User> ret = new ArrayList<User>();
		for (User u : usersList) {
			if (u instanceof Technician || u instanceof Laborant) {
				ret.add(u);
			}
		}
		return ret;
	}
	
	public static ArrayList<Patient> getPatients(){
		ArrayList<Patient> ret = new ArrayList<Patient>();
		for (User u : usersList) {
			if (u instanceof Patient) {
				ret.add((Patient) u);
			}
		}
		return ret;
	}
	
	public static User getCurrentUser(String username) {
		for (User u : usersList) {
			if (u.getUsername().equals(username)) {
				return u;
			}
		}
		return null;
	}
}
