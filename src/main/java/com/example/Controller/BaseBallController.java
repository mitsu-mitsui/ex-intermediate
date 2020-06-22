package com.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class BaseBallController {

	@RequestMapping("/list")
	public String inex() {
		return "baseball-team-list";
	}
	
}
