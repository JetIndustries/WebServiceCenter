package service_center.dao;

import javax.persistence.*;
import java.util.*;

@Entity
public class Client {
	@Id
	@GeneratedValue
	private int id;
	private String fName;
	private String sName;
	private String telNumber;
	private String email;
	private String address;
	/*@OneToMany (mappedBy = "client")
	private Set<Receipt> receipt;*/
	

	public Client() {
	}

	public Client(String fName, String sName, String telNumber, String email, String address) {
		
		this.fName = fName;
		this.sName = sName;
		this.telNumber = telNumber;
		this.email = email;
		this.address = address;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", fName=" + fName + ", sName=" + sName + ", telNumber=" + telNumber + ", email="
				+ email + ", address=" + address  + "]";
	}

}
