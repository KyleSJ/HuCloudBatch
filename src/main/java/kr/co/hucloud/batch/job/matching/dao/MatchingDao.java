package kr.co.hucloud.batch.job.matching.dao;

import java.util.List;

import kr.co.hucloud.batch.job.matching.vo.MatchingTeamMemberVO;
import kr.co.hucloud.batch.job.matching.vo.MatchingTeamVO;
import kr.co.hucloud.batch.job.matching.vo.MemberVO;

public interface MatchingDao {
	
	public int insertSoloMatching(int fMemberId, int mMemberId);
	
	public List<MemberVO> selectAllMaleList();
	
	public List<MemberVO> selectAllFemaleList();
	
	public List<MatchingTeamVO> selectAllTeamListByGenderAndNOP(String gender, int nop);
	
	public List<MatchingTeamMemberVO> selectTeamMember(int matchingTeamId);
	
	public List<Integer> selectStyleList(int memberId);
	
	public List<Integer> selectPreferStyleList(int memberId);
	
	public int updateInvitableNo(int memberId);
	
	public int updateTeamMatchingStatusYes(int matchingTeamId);
	
	public int insertMatching(int fMatchingTeamId, int mMatchingTeamId, int nop);
	

}
