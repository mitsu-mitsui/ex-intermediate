package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Domain.BaseBallTeam;
import com.example.Repository.BaseBallTeamRepository;

/**
 * 野球チーム情報を操作するサービス．
 * 
 * @author yuiko.mitsui
 *
 */
@Service
public class BaseBallTeamService {
	@Autowired
	private BaseBallTeamRepository baseBallTeamRepository;

	/**
	 * 野球チームの情報取得．
	 * 
	 * @param id 野球チームID
	 * @return 野球チーム情報
	 */
	public BaseBallTeam getBaseBallTeam(int id) {
		return baseBallTeamRepository.load(id);
	}

	/**
	 * 全野球チームの情報取得．
	 * 
	 * @return 全野球チームの情報
	 */
	public List<BaseBallTeam> getAllBaseBallTeam() {
		return baseBallTeamRepository.findAll();
	}
}
