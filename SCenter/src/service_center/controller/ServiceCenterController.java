package service_center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service_center.interfaces.IServiceCenter;

@Controller
@RequestMapping("/")
public class ServiceCenterController {
	@Autowired
	IServiceCenter sc;
	
	@RequestMapping({"/", "home"})
	public String home(){
		
		return "home";
	}
	
	@RequestMapping("addForm")
	public String addForm(){
		
		return "addForm";
	}

	@RequestMapping("add")
	public String addReceipt(){

		return null;
		
	

	}

}
