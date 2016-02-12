package service_center.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import service_center.dao.Receipt;
import service_center.interfaces.IServiceCenter;

public class Appl_update {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		IServiceCenter controller = (IServiceCenter) ctx.getBean("database");
		
		controller.getReceiptById(2);
		
		//Receipt receipt1 = new Receipt();
		
		
		
		ctx.close();

	}

}
