package business;

import java.io.Serializable;

final public class Author extends Person implements Serializable {
	private String bio;
	private String credentials;

	public String getBio() {
		return bio;
	}
	
	public String getCredentials() {
		return credentials;
	}


	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}
	
	public Author(String f, String l, String t, Address a, String bio) {
		super(f, l, t, a);
		this.bio = bio;
		this.credentials = null;
	}
	

	public Author(String f, String l, String t, Address a, String bio, String credentials) {
		super(f, l, t, a);
		this.bio = bio;
		this.credentials = credentials;
	}

	private static final long serialVersionUID = 7508481940058530471L;

}
