package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Domain.cloth;
import com.example.Service.clothService;

/**
 * 衣服情報を操作するサービス．
 * 
 * @author yuiko.mitsui
 *
 */
@Controller
@RequestMapping("/cloth")
public class clothController {
	@Autowired
	private clothService clothservice;

	/**
	 * 衣服検索画面へ画面遷移．
	 * 
	 * @return 衣服検索画面
	 */
	@RequestMapping("")
	public String index() {

		return "find-cloth";
	}

	@RequestMapping("/find")
	public String find(Integer gender, String color, Model model) {

		List<cloth> clothList = clothservice.searchByColorAndGender(color, gender);
		model.addAttribute("clothList", clothList);

		return "find-cloth";
	}
}
