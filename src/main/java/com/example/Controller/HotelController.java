package com.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hotel")
public class HotelController {
	
	@RequestMapping("")
	public String index() {
		return "find-hotel";
	}

	@RequestMapping("/find")
	public String find() {
		
		
		
		return "redirect:/hotel";
	}

	
}
