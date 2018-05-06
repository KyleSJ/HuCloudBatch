package kr.co.hucloud.batch.job.matching.service;

import java.util.List;

import kr.co.hucloud.batch.job.matching.vo.MatchingTeamMemberVO;
import kr.co.hucloud.batch.job.matching.vo.MatchingTeamVO;
import kr.co.hucloud.batch.job.matching.vo.MemberVO;

public interface MatchingService {
	
	public boolean createSoloMatching(int fMemberId, int mMemberId);
	
	public boolean createTeamMatching(int fMatchingTeamId, int mMatchingTeamId, int nop);
	
	public List<MemberVO> readAllMale();
	
	public List<MemberVO> readAllFemale();
	
	public List<MatchingTeamVO> readAllTeamByGenderAndNOP(String gender, int nop);
	
	public List<MatchingTeamMemberVO> readTeamMember(int matchingTeamId);
	
}
