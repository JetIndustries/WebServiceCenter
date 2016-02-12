package service_center.dao;

import javax.persistence.*;

@Entity
public class ComplexityRepair{
	@Id
	@GeneratedValue
	private int id;
	private String complexity;
	private Integer timeMin;
	
	public ComplexityRepair() {
		super();
	}

	public ComplexityRepair(String complexity, int time) {
		super();
		this.complexity = complexity;
		this.timeMin = time;
	}

	public String getComplexity() {
		return complexity;
	}

	public void setComplexity(String complexity) {
		this.complexity = complexity;
	}

	public int getTime() {
		return timeMin;
	}

	public void setTime(int time) {
		this.timeMin = time;
	}

	@Override
	public String toString() {
		return "ComplexityRepair [id=" + id + ", complexity=" + complexity + ", timeMin=" + timeMin + "]";
	}
		
	
}
