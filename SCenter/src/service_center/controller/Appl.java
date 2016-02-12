package service_center.controller;

import org.springframework.context.support.*;

import service_center.dao.*;
import service_center.interfaces.*;

public class Appl {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		IServiceCenter controller = (IServiceCenter) ctx.getBean("database");

		Receipt receipt1 = new Receipt();
		Receipt receipt2 = new Receipt();
		
		Client client1 = new Client();	
		Client client2 = new Client("Petr", "Petrov", "050-3334567", "test@test.ua", "Artema 169sh");
		Client client3 = new Client("Sidor", "Sidorov", "050-4434567", "test1@test.ua", "Artema 50");
				
		Shop shop1 = new Shop("Netania", "N");
		Shop shop2 = new Shop("Rehovot", "R");
		
		ComplexityRepair cr1 = new ComplexityRepair("Notebook", 90);
		ComplexityRepair cr2 = new ComplexityRepair("Monitor", 30);
		controller.addComplexityRepair(cr1);
		controller.addComplexityRepair(cr2);
		
		Product product1 = new Product("Monitor", "BN123F987", 36, "LG", "1943W", cr2);
		
		controller.addProduct(product1);
					
		Product product2 = new Product("Monitor", "123F98711", 36, "Samsung", "940N");
		Product product3 = new Product("Notebook", "BN000F980", 36, "Asus", "X551C");
		Product product4 = new Product("Notebook", "BN000F980", 36, "Samsung", "P500");
		
		product2.setComplexityRepair(cr2);
		product3.setComplexityRepair(cr1);
		product4.setComplexityRepair(cr1);
				
		controller.addProduct(product2);
		controller.addProduct(product3);
		controller.addProduct(product3);
		controller.addProduct(product4);
		controller.addProduct(product3);
		
		Position position1 = new Position(1, "Tester");
		Position position2 = new Position(2, "Manager");
		
		controller.addPosition(position1);
		controller.addPosition(position2);
		controller.addPosition(position1);
						
		User user1 = new User("login1", "password1", "Terminator", "Term", "050-1234567");
		User user2 = new User("login2", "password2", "Darth", "Vader", "050-1234001");
		
		user1.setPosition(position2);
		user2.setPosition(position1);
		//user2.setTelNumber("050-1234002");
		
		controller.addUser(user1);
		controller.addUser(user2);
		//controller.addUser(user1);
								
		controller.addShop(shop1);
		controller.addShop(shop2);

		client1.setfName("Ivan");
		client1.setsName("Ivanov");
		client1.setTelNumber("050-2234567");
		controller.addClient(client1);
		controller.addClient(client2);
		controller.addClient(client3);
		
		Status st = (Status) ctx.getBean("status");
		controller.addStatus(st);
		
		/*for (String s : st.getStatus()) {
			System.out.println(s);
		}*/
			
		receipt1.setDefectClient("Super1");
		receipt1.setClient(client1);
		receipt1.setShop(shop1);
		receipt1.setUser(user1);
		receipt1.setProduct(product2);
		//receipt1.setDateTransfer(new Date());
		receipt1.setView("view1");
		receipt1.setEquipment("Equipment");
		receipt1.setDefectCorrect("Puper1");
		receipt1.setAuthorizedService("ERC");
		
		receipt1.setStatus((String)st.getStatus().toArray()[5]);
		controller.addReceipt(receipt1);
		
		System.out.println("receipt1 status old - " + receipt1.getStatus() );
		System.out.println(receipt1);
		
		receipt2.setDefectClient("Super2");
		receipt2.setClient(client1);
		receipt2.setShop(shop2);
		receipt2.setUser(user2);
		receipt2.setProduct(product1);
		receipt2.setStatus((String)st.getStatus().toArray()[0]);
		controller.addReceipt(receipt2);
		
		//receipt2.setStatus((String)st.getStatus().toArray()[5]);
		//controller.addReceipt(receipt2);
		
		RepiatRepair repiatRepair1 = new RepiatRepair();
		repiatRepair1.setUser(user1);
		repiatRepair1.setProduct(product1);
		repiatRepair1.setStatus((String)st.getStatus().toArray()[1]);
		repiatRepair1.setReceipt(receipt1);
		//controller.addRepiatRepair(repiatRepair1);
				
		receipt1.setStatus((String)st.getStatus().toArray()[7]);
		System.out.println("receipt1 status new - " + receipt1.getStatus() );
		System.out.println(receipt1);
		
		//controller.updateReceipt(receipt1);

		ctx.close();
	}

}
