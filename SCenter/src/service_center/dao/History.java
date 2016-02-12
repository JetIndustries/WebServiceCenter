package service_center.dao;

import java.util.*;
import javax.persistence.*;

@Entity
public class History {
	@Id
	@GeneratedValue
	private int id;
	@OneToOne(cascade=CascadeType.ALL)
	private Receipt receipt;
	private String status;
	private Date date;
	@OneToOne
	private User user;

	public History() {
		super();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	@Override
	public String toString() {
		return "History [id=" + id + ", receipt=" + receipt + ", status=" + status + ", date=" + date + ", user=" + user
				+ "]";
	}	

	
}
