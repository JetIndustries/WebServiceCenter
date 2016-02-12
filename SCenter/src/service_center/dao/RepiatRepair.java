package service_center.dao;

import java.util.*;
import javax.persistence.*;

@Entity
public class RepiatRepair {
	@Id
	@GeneratedValue
	private int id;
	private Date date;
	@ManyToOne(cascade=CascadeType.ALL)
	private Receipt receipt;
	@ManyToOne(cascade=CascadeType.ALL)
	private User user;
	@ManyToOne(cascade=CascadeType.ALL)
	private Product product;
	private String defectCorrect;
	private String authorizedService;
	//@ManyToOne
	private String status;
	private Date dateTransfer;
	private String infoTransfer;

	public RepiatRepair() {
		super();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDefectCorrect() {
		return defectCorrect;
	}

	public void setDefectCorrect(String defectCorrect) {
		this.defectCorrect = defectCorrect;
	}

	public String getAuthorizedService() {
		return authorizedService;
	}

	public void setAuthorizedService(String authorizedService) {
		this.authorizedService = authorizedService;
	}

	public Date getDateTransfer() {
		return dateTransfer;
	}

	public void setDateTransfer(Date dateTransfer) {
		this.dateTransfer = dateTransfer;
	}

	public String getInfoTransfer() {
		return infoTransfer;
	}

	public void setInfoTransfer(String infoTransfer) {
		this.infoTransfer = infoTransfer;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "RepiatRepair [id=" + id + ", date=" + date + ", receipt=" + receipt + ", user=" + user + ", product="
				+ product + ", defectCorrect=" + defectCorrect + ", authorizedService=" + authorizedService
				+ ", status=" + status + ", dateTransfer=" + dateTransfer + ", infoTransfer=" + infoTransfer + "]";
	}

}
