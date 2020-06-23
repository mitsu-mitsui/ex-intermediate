package com.example.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.Domain.cloth;

/**
 * 衣服情報を操作するリポジトリ．
 * 
 * @author yuiko.mitsui
 *
 */
@Repository
public class clothRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<cloth> CLOTH_ROW_MAPPER = (rs, i) -> {
		cloth cloth_ = new cloth(rs.getInt("id"), rs.getString("category"), rs.getString("genre"), rs.getInt("gender"),
				rs.getString("color"), rs.getInt("price"), rs.getString("size"));

		return cloth_;
	};

	/**
	 * 衣服に設定された性別、色から合致する衣服を取得．
	 * 
	 * @param gender 性別（0:男/1:女）
	 * @param color  色
	 * @return 衣服情報
	 */
	public List<cloth> findCloth(Integer gender, String color) {

		String sql = "SELECT id,category,genre,gender,color,price,size FROM clothes"
				+ " WHERE gender=:gender AND color =:color;";

		SqlParameterSource param = new MapSqlParameterSource().addValue("gender", gender).addValue("color", color);

		List<cloth> clothList = template.query(sql, param, CLOTH_ROW_MAPPER);

		return clothList;
	}

}
