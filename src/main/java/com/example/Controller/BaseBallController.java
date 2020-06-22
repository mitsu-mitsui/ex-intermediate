package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Domain.BaseBallTeam;
import com.example.Service.BaseBallTeamService;

@Controller
@RequestMapping("")
public class BaseBallController {
	@Autowired
	private BaseBallTeamService baseBallTeamService;
	
	
	@RequestMapping("/list")
	public String inex(Model model) {
		
		List<BaseBallTeam> baseBallTeams = baseBallTeamService.getAllBaseBallTeam();
		
		model.addAttribute("baseBallTeams", baseBallTeams);
		
		return "baseball-team-list";
	}
	
}