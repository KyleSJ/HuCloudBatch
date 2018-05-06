package kr.co.hucloud.batch.job.matching.service;

import java.util.List;

import kr.co.hucloud.batch.job.matching.dao.MatchingDao;
import kr.co.hucloud.batch.job.matching.vo.MatchingTeamMemberVO;
import kr.co.hucloud.batch.job.matching.vo.MatchingTeamVO;
import kr.co.hucloud.batch.job.matching.vo.MemberVO;

public class MatchingServiceImpl implements MatchingService{
	
	private MatchingDao matchingDao;
	
	public void setMatchingDao(MatchingDao matchingDao) {
		this.matchingDao = matchingDao;
	}

	@Override
	public List<MemberVO> readAllMale() {
		return matchingDao.selectAllMaleList();
	}

	@Override
	public List<MemberVO> readAllFemale() {
		return matchingDao.selectAllFemaleList();
	}

	@Override
	public boolean createSoloMatching(int fMemberId, int mMemberId) {
		return matchingDao.updateInvitableNo(mMemberId) > 0 &&
				matchingDao.updateInvitableNo(fMemberId) > 0 &&
				matchingDao.insertSoloMatching(fMemberId, mMemberId) > 0;
	}

	@Override
	public List<MatchingTeamVO> readAllTeamByGenderAndNOP(String gender, int nop) {
		return matchingDao.selectAllTeamListByGenderAndNOP(gender, nop);
	}

	@Override
	public List<MatchingTeamMemberVO> readTeamMember(int matchingTeamId) {
		List<MatchingTeamMemberVO> matchingTeamMemberList = matchingDao.selectTeamMember(matchingTeamId);
		for(int i=0; i<matchingTeamMemberList.size(); i++) {
			int memberId = matchingTeamMemberList.get(i).getMemberId();
			List<Integer> styleList = matchingDao.selectStyleList(memberId);
			List<Integer> preferStyleList = matchingDao.selectPreferStyleList(memberId);
			matchingTeamMemberList.get(i).setStyleList(styleList);
			matchingTeamMemberList.get(i).setPreferStyleList(preferStyleList);
		}
		return matchingTeamMemberList;
	}

	@Override
	public boolean createTeamMatching(int fMatchingTeamId, int mMatchingTeamId, int nop) {
		return matchingDao.insertMatching(fMatchingTeamId, mMatchingTeamId, nop) > 0
				&& matchingDao.updateTeamMatchingStatusYes(fMatchingTeamId) > 0
				&& matchingDao.updateTeamMatchingStatusYes(mMatchingTeamId) > 0;
	}

}
