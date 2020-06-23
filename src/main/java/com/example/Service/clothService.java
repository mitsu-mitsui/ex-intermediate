package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Domain.cloth;
import com.example.Repository.clothRepository;

/**
 * 衣服情報を操作するサービス．
 * 
 * @author yuiko.mitsui
 *
 */
@Service
@Transactional
public class clothService {
	@Autowired
	private clothRepository clothrepository;

	/**
	 * 衣服に設定された色と性別に合致する衣服を取得．
	 * 
	 * @param color  色
	 * @param gender 性別コード
	 * @return 衣服情報
	 */
	public List<cloth> searchByColorAndGender(String color, Integer gender) {

		return clothrepository.findCloth(gender, color);
	}

}
