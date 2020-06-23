package com.example.Controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Domain.Hotel;
import com.example.Service.HotelService;

@Controller
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@RequestMapping("")
	public String index() {
		return "find-hotel";
	}

	@RequestMapping("/find")
	public String find(Model model, String price) {

		// もしpriceが空文字でないばあい
		// もしpriceが数値でないばあい
		// エラーメッセージをスコープにいれる

		// 以降はprice が空文字or数値
		// サービスクラスのメソッドを呼ぶ priceを渡す

		if (!"".equals(price)) {// 空

			Pattern p = Pattern.compile("^[0-9]*$");
			Matcher m = p.matcher(price);

			if (!m.matches()) {// 数値ではない
				model.addAttribute("errorMessage", "err：有効な数値を入力してください");
				return index();
			} 
		} 
		
		List<Hotel> hotelList = hotelService.searchByLessThanPrice(price);
		model.addAttribute("hotelList", hotelList);
		
		/*
		 * try {// 数字 List<Hotel> hotelList =
		 * hotelService.getHotels(Integer.parseInt(price));
		 * 
		 * if(hotelList.size()==0) { model.addAttribute("errorMessage",
		 * "該当するホテルがありません"); }else { model.addAttribute("hotelList", hotelList); }
		 * 
		 * } catch (NumberFormatException e) { if ("".equals(price)) {// null
		 * List<Hotel> hotelList = hotelService.getAllHotels();
		 * model.addAttribute("hotelList", hotelList);
		 * 
		 * } else {//文字・その他 model.addAttribute("errorMessage", "err：有効な数値を入力してください"); }
		 * }
		 */
		return "find-hotel";
	}

}
