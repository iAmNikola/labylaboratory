package entities.users;

public class Admin extends User{

	public Admin(String username, String password, String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}
	
	@Override
	public String saveFormating() {
		String d = ";";
		String s = this.username +d+ this.password +d+ this.name +d+ this.lastName;
		return s;
	}
	
}
