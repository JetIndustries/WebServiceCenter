package service_center.dao;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Shop {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String code;
	/*@OneToMany (mappedBy = "shop")
	private Set<Receipt> receipt;*/

	public Shop(String name, String code) {
		this.name = name;
		this.code = code;
	}

	public Shop() {
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Shop [id=" + id + ", name=" + name + ", code=" + code + "]";
	}

}
