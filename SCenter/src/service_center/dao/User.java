package service_center.dao;

import java.util.Set;

import javax.persistence.*;


@Entity
public class User {
	@Id
	@GeneratedValue
	int id;
	private String login;
	private String password;
	private String fName;
	private String sName;
	private String telNumber;
	@ManyToOne
	private Position position;
	@OneToMany (mappedBy = "user")
	private Set<Receipt> receipt;
	
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public User() {
		super();
	}

	public User(String login, String password, String fName, String sName, String telNumber) { // Position
																								// position)
																								// {
		this.login = login;
		this.password = password;
		this.fName = fName;
		this.sName = sName;
		this.telNumber = telNumber;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", fName=" + fName + ", sName="
				+ sName + ", telNumber=" + telNumber + ", position=" + position + "]";
	}

}
