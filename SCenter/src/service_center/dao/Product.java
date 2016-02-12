package service_center.dao;

import javax.persistence.*;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String serialNumber;
	private int warranty;
	private String manufacturer;
	private String model;
	@ManyToOne(cascade=CascadeType.ALL)
	private ComplexityRepair complexityRepair;

	public Product(String name, String serialNumber, int warranty, String manufacturer, String model) {
		super();
		this.name = name;
		this.serialNumber = serialNumber;
		this.warranty = warranty;
		this.manufacturer = manufacturer;
		this.model = model;
	}
	
	
	public Product(String name, String serialNumber, int warranty, String manufacturer, String model,
			ComplexityRepair complexityRepair) {
		this.name = name;
		this.serialNumber = serialNumber;
		this.warranty = warranty;
		this.manufacturer = manufacturer;
		this.model = model;
		this.complexityRepair = complexityRepair;
	}



	public Product() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getId() {
		return id;
	}

	public ComplexityRepair getComplexityRepair() {
		return complexityRepair;
	}

	public void setComplexityRepair(ComplexityRepair complexityRepair) {
		this.complexityRepair = complexityRepair;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", serialNumber=" + serialNumber + ", warranty=" + warranty
				+ ", manufacturer=" + manufacturer + ", model=" + model + ", complexityRepair=" + complexityRepair
				+ "]";
	}
	
}
