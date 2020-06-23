package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Domain.Hotel;
import com.example.Repository.HotelRepository;

/**
 * ホテル情報を操作するサービス．
 * 
 * @author yuiko.mitsui
 *
 */
@Service
@Transactional
public class HotelService {
	@Autowired
	private HotelRepository hotelRepository;

	/**
	 * 全ホテル情報を取得．
	 * 
	 * @return id昇順の全ホテル情報．
	 */
	public List<Hotel> findHotels() {

		return hotelRepository.findAll();
	}

	/**
	 * 希望宿泊価格以下のホテルを複数検索．
	 * 
	 * @param price 希望宿泊価格．
	 * @return 希望宿泊価格以下の全ホテル情報
	 */
	public List<Hotel> findHotels(Integer price) {

		return hotelRepository.findHotels(price);
	}

}
