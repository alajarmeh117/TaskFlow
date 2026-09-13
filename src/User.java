
public class User {
	
	private int id;
	private String name;
	private String email;

	public User(String name, String email) throws InvalidEmailException { // validation from User Email --> like => [
																			// Example@gmail.com ] . 
		boolean result = email.matches("^[a-zA-Z]+@[a-zA-Z]+\\.[a-zA-Z]+$");
		
		if (result) {
			this.name = name;
			this.email = email;
		}
		else
			throw new InvalidEmailException("Invalid email");
	}

}
