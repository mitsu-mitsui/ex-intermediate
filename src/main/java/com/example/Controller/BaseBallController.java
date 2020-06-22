package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Domain.BaseBallTeam;
import com.example.Service.BaseBallTeamService;

/**
 * 野球チーム情報を操作するコントローラ．
 * 
 * @author yuiko.mitsui
 *
 */
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

	@RequestMapping("/team-info")
	public String teamInfo(int id, Model model) {

		BaseBallTeam baseBallTeam = baseBallTeamService.getBaseBallTeam(id);
		
		model.addAttribute("baseBallTeam", baseBallTeam);

		return "team-info";
	}

}
