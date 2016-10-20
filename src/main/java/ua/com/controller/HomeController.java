package ua.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(){
		return "home";
	}
	@RequestMapping(value="/select")
	public String sel(@RequestParam String fromSelect){
		System.out.println("from select "+fromSelect);
		return "home";
	}
	
}
