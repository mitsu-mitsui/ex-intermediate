package com.example.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.Domain.Hotel;

/**
 * ホテル情報を操作するリポジトリ．
 * 
 * @author yuiko.mitsui
 *
 */
@Repository
public class HotelRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs, i) -> {
		Hotel hotel = new Hotel(rs.getInt("id"), rs.getString("area_name"), rs.getString("hotel_name"),
				rs.getString("address"), rs.getString("nearest_station"), rs.getInt("price"), rs.getString("parking"));

		return hotel;
	};

	/**
	 * ホテルを全件検索する．
	 * 
	 * @return 全ホテル情報
	 */
	public List<Hotel> findAll() {

		String sql = "SELECT id,area_name,hotel_name,address, nearest_station,price,parking " + " FROM hotels ORDER BY id ASC;";

		List<Hotel> hotelList = template.query(sql, HOTEL_ROW_MAPPER);

		return hotelList;
	}

	/**
	 * 希望宿泊価格以下のホテルを複数検索．
	 * 
	 * @param price 希望宿泊価格．
	 * @return 希望宿泊価格以下で宿泊できる全ホテル情報．
	 */
	public List<Hotel> findHotels(Integer price) {

		String sql = "SELECT id,area_name,hotel_name,address, nearest_station,price,parking " + " FROM hotels"
				+ " WHERE price<= :price" + " ORDER  BY price DESC ,id ASC;";

		SqlParameterSource param = new MapSqlParameterSource("price", price);

		List<Hotel> hotelList = template.query(sql, param, HOTEL_ROW_MAPPER);

		return hotelList;
	}

}
