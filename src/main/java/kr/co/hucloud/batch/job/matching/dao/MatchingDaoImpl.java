package kr.co.hucloud.batch.job.matching.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import kr.co.hucloud.batch.job.matching.vo.MatchingTeamMemberVO;
import kr.co.hucloud.batch.job.matching.vo.MatchingTeamVO;
import kr.co.hucloud.batch.job.matching.vo.MemberVO;

public class MatchingDaoImpl extends SqlSessionDaoSupport implements MatchingDao {

	@Override
	public List<MemberVO> selectAllMaleList() {
		return getSqlSession().selectList("MatchingDao.selectAllMaleList");
	}

	@Override
	public List<MemberVO> selectAllFemaleList() {
		return getSqlSession().selectList("MatchingDao.selectAllFemaleList");
	}

	@Override
	public int insertSoloMatching(int fMemberId, int mMemberId) {
		Map<String, Integer> param = new HashMap<>();
		param.put("fMemberId", fMemberId);
		param.put("mMemberId", mMemberId);
		return getSqlSession().insert("MatchingDao.insertSoloMatching", param);
	}

	@Override
	public int updateInvitableNo(int memberId) {
		return getSqlSession().update("MatchingDao.updateInvitableNo", memberId);
	}

	@Override
	public List<MatchingTeamVO> selectAllTeamListByGenderAndNOP(String gender, int nop) {
		Map<String, Object> param = new HashMap<>();
		param.put("gender", gender);
		param.put("nop", nop);
		return getSqlSession().selectList("MatchingDao.selectAllTeamListByGenderAndNOP", param);
	}

	@Override
	public List<MatchingTeamMemberVO> selectTeamMember(int matchingTeamId) {
		return getSqlSession().selectList("MatchingDao.selectTeamMember", matchingTeamId);
	}

	@Override
	public List<Integer> selectStyleList(int memberId) {
		return getSqlSession().selectList("MatchingDao.selectStyleList", memberId);
	}

	@Override
	public List<Integer> selectPreferStyleList(int memberId) {
		return getSqlSession().selectList("MatchingDao.selectPreferStyleList", memberId);
	}

	@Override
	public int insertMatching(int fMatchingTeamId, int mMatchingTeamId, int nop) {
		Map<String, Integer> param = new HashMap<>();
		param.put("fMatchingTeamId", fMatchingTeamId);
		param.put("mMatchingTeamId", mMatchingTeamId);
		param.put("nop", nop);
		return getSqlSession().insert("MatchingDao.insertMatching", param);
	}

	@Override
	public int updateTeamMatchingStatusYes(int matchingTeamId) {
		return getSqlSession().update("MatchingDao.updateTeamMatchingStatusYes", matchingTeamId);
	}

}
