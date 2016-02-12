package service_center.dao;

import java.util.*;
import javax.persistence.*;

@Entity
public class Receipt {
	@Id
	@GeneratedValue
	private int id;
	private Date date;
	@ManyToOne
	private Client client;
	@ManyToOne
	private Shop shop;
	@ManyToOne
	private User user;
	@ManyToOne
	private Product product;
	private String defectClient;
	private String equipment;
	private String view;
	private String status;
	private String defectCorrect;
	private String authorizedService;
	private Date dateTransfer;
	private String infoTransfer;
	@OneToMany
	private Set <RepiatRepair> repiatRepair;

	public Receipt() {
	}

	public int getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
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

	public String getDefectClient() {
		return defectClient;
	}

	public void setDefectClient(String defectClient) {
		this.defectClient = defectClient;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
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

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<RepiatRepair> getRepiatRepair() {
		return repiatRepair;
	}

	public void setRepiatRepair(Set<RepiatRepair> repiatRepair) {
		this.repiatRepair = repiatRepair;
	}

	@Override
	public String toString() {
		return "Receipt [id=" + id + ", date=" + date + ", client=" + client + ", shop=" + shop + ", user=" + user
				+ ", product=" + product + ", defectClient=" + defectClient + ", equipment=" + equipment + ", view="
				+ view + ", status=" + status + ", defectCorrect=" + defectCorrect + ", authorizedService="
				+ authorizedService + ", dateTransfer=" + dateTransfer + ", infoTransfer=" + infoTransfer
				+ ", repiatRepair=" + repiatRepair + "]";
	}

}
