package com.example.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.Domain.BaseBallTeam;

/**
 * 野球チーム情報を処理するリポジトリ．
 * 
 * @author yuiko.mitsui
 *
 */
@Repository
public class BaseBallTeamRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<BaseBallTeam> BASE_BALL_TEAM_ROW_MAPPER = (rs, i) -> {
		BaseBallTeam baseBallTeam = new BaseBallTeam(rs.getInt("id"), rs.getString("league_name"),
				rs.getString("team_name"), rs.getString("headquarters"), rs.getString("inauguration"),
				rs.getString("history"));
		return baseBallTeam;
	};

	/**
	 * 野球チーム情報の取得．
	 * 
	 * @param id 野球チームID
	 * @return 野球チーム情報
	 */
	public BaseBallTeam load(int id) {

		String sql = "SELECT id,league_name , team_name , headquarters , inauguration ,history" + " FROM teams"
				+ " WHERE id =:id";

		SqlParameterSource param = new MapSqlParameterSource().addValue("id",id);

		BaseBallTeam baseBallTeam =  template.queryForObject(sql, param, BASE_BALL_TEAM_ROW_MAPPER);
		
		return baseBallTeam;
	}

	/**
	 * 全野球チーム情報を取得．
	 * 
	 * @return 全野球チーム情報
	 */
	public List<BaseBallTeam> findAll() {
		String sql = "SELECT id,league_name , team_name , headquarters , inauguration ,history" + " FROM teams"
				+ " ORDER BY inauguration ASC";

		List<BaseBallTeam> baseBallTeams = template.query(sql, BASE_BALL_TEAM_ROW_MAPPER);

		return baseBallTeams;
	}

}
