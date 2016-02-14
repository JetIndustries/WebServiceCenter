package service_center.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import service_center.dao.*;
import service_center.interfaces.IServiceCenter;

public class Appl_update {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		IServiceCenter controller = (IServiceCenter) ctx.getBean("database");

		Receipt receiptFromDB1 = controller.getReceiptById(1);
		// System.out.println(receiptFromDB1);
		// System.out.println("Status = " + receiptFromDB1.getStatus());

		//Status st = (Status) ctx.getBean("status");
		String stTemp = controller.getStatus(0);
		
		receiptFromDB1.setStatus(stTemp);
		//receiptFromDB1.setStatus((String) st.getStatus().toArray()[7]);
		//System.out.println(receiptFromDB1);
		// System.out.println("Status = " + receiptFromDB1.getStatus());

		controller.updateReceipt(receiptFromDB1);

		Receipt receiptFromDB2 = controller.getReceiptById(1);
		receiptFromDB2.setAuthorizedService("DataLux");

		// controller.updateReceipt(receiptFromDB2);

		RepiatRepair repiatRepair1 = new RepiatRepair();
		repiatRepair1.setUser(receiptFromDB2.getUser());
		repiatRepair1.setProduct(receiptFromDB2.getProduct());
		//repiatRepair1.setStatus((String) st.getStatus().toArray()[5]);
		repiatRepair1.setReceipt(receiptFromDB2);

		// controller.addRepiatRepair(repiatRepair1);

		ctx.close();

	}

}
