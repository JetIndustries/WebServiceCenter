package service_center.dao;

import java.util.*;
import javax.persistence.*;

@Entity
public class Status {
	@Id
	@GeneratedValue
	int id;
	LinkedHashSet<String> status;

	public Status() {
	}

	public Status(LinkedHashSet<String> status) {
		this.status = status;
	}

	public LinkedHashSet<String> getStatus() {
		return status;
	}

	public void setStatus(LinkedHashSet<String> status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", status=" + status + "]";
	}

}
