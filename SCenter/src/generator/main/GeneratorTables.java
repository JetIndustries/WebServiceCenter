package generator.main;

import java.util.*;

import service_center.dao.Client;
import service_center.dao.ComplexityRepair;
import service_center.dao.Position;
import service_center.dao.Product;
import service_center.dao.Shop;
import service_center.dao.User;

public class GeneratorTables {

	public List<Client> genClients(int count) {
		String name, lname, phone, email, adress;
		List<Client> res = new LinkedList<Client>();
		for (int i = 0; i < count; i++) {
			name = Generator.genName();
			lname = Generator.genLastName();
			phone = Generator.genPhoneNumber(10);
			email = Generator.genEmail(name, lname);
			adress = Generator.genAdress();
			res.add(new Client(name, lname, phone, email, adress));
		}
		return res;
	}
	
	public List<Position> genPosJobs(int count) {
		List<Position> res = new LinkedList<Position>();
		for (int i = 0; i < count; i++) {
			int access = Generator.genInt(9);
			String job = Generator.genPosJob();
			res.add(new Position(access, job));
		}
		return res;
	}
	
	public List<Shop> genShops(int count) {
		List<Shop> res = new LinkedList<Shop>();
		for (int i = 0; i < count; i++) {
			String name = Generator.genCities();
			String code = Generator.genSerialNumber(3, name);
			res.add(new Shop(name, code));
		}
		return res;
	}
	
	public List<ComplexityRepair> genCRepairs(int count) {
		List<ComplexityRepair> res = new LinkedList<ComplexityRepair>();
		for (int i = 0; i < count; i++) {
			String name = Generator.genManufactur();
			int time = Generator.genInt(9) * 10;
			res.add(new ComplexityRepair(name, time));
		}
		return res;
	}
	
	public List<Product> genProducts(int count) {
		List<Product> res = new LinkedList<Product>();
		for (int i = 0; i < count; i++) {
			String name = Generator.genProduct();
			String sn = Generator.genSerialNumber(10, name);
			int waranty = Generator.genInt(3);
			String mn = Generator.genManufactur();
			String model = Generator.genSerialNumber(5, name);
			res.add(new Product(name, sn, waranty, mn, model));
		}
		return res;
	}
	
	public List<User> genUsers(int count) {
		List<User> res = new LinkedList<User>();
		for (int i = 0; i < count; i++) {
			String name = Generator.genName();
			String lname = Generator.genLastName();
			String phone = Generator.genPhoneNumber(10);
			String login = Generator.genName().substring(1, 3).toLowerCase() + Generator.genPhoneNumber(4) + Generator.genSerialNumber(3, lname);
			String password = "admin";
			res.add(new User(login, password, name, lname, phone));
		}
		return res;
	}
}
// тут что то новенькое будет