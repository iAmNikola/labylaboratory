package entities.users;

import java.util.regex.*;

import exceptions.BadNameInputException;
import exceptions.BadPassInputException;
import exceptions.BadUserInputException;

public abstract class User {
	protected String name;
	protected String lastName;
	protected String username;
	protected String password;
	
	private String nameRegex = "^[A-Z](?=.*[a-z]).{3,20}$";
	private String passRegex = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{6,20}$";
	private String userRegex = "^[a-z]\\w{5,19}$";


	public String getName() {
		return name;
	}
	public void setName(String name) throws BadNameInputException {
		
		Pattern p = Pattern.compile(nameRegex);
		Matcher m = p.matcher(name);
		if (name.equals("") || !m.matches()) {
			throw new BadNameInputException("Incorrect input.");
		}
		this.name = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) throws BadNameInputException {
		Pattern p = Pattern.compile(nameRegex);
		Matcher m = p.matcher(lastName);
		if (lastName.equals("") || !m.matches()) {
			throw new BadNameInputException("Incorrect input.");
		}
		this.lastName = lastName;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) throws BadUserInputException {
		Pattern p = Pattern.compile(userRegex);
		Matcher m = p.matcher(username);
		if (!m.matches()) {
			throw new BadUserInputException("Incorrect input.");
		}
		this.username = username;
		
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) throws BadPassInputException {
		Pattern p = Pattern.compile(passRegex);
		Matcher m = p.matcher(password);
		if (!m.matches()) {
			throw new BadPassInputException("Incorrect input.");
		}
		this.password = password;
	}
	
	public abstract String saveFormating();
}
