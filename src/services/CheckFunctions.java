package services;

import entities.users.Patient;
import entities.users.User;
import services.loadsave.users.LoadUsers;

public class CheckFunctions {

	public static boolean isUsernameFree(String username) {
		for (User u : LoadUsers.usersList) {
			if (u.getUsername().equals(username)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean lboExists(String lbo) {
		for (User u : LoadUsers.usersList) {
			if (u instanceof Patient) {
				Patient p = (Patient) u;
				if (String.valueOf(p.getLbo()).equals(lbo)) {
					return true;
				}
			}
		}
		return false;
	}
}
