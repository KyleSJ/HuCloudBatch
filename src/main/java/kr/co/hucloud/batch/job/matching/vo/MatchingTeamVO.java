package kr.co.hucloud.batch.job.matching.vo;

import java.util.List;

public class MatchingTeamVO {

	private int matchingTeamId;
	private String matchingTeamName;
	private int teamNOP;
	private String invite;
	private String teamGender;
	private int matchingTeamMaster;
	private List<MatchingTeamMemberVO> matchingTeamMemberVO;
	private List<Integer> teamStyleList;
	private List<Integer> teamPreferStyleList;

	public int getMatchingTeamId() {
		return matchingTeamId;
	}

	public void setMatchingTeamId(int matchingTeamId) {
		this.matchingTeamId = matchingTeamId;
	}

	public String getMatchingTeamName() {
		return matchingTeamName;
	}

	public void setMatchingTeamName(String matchingTeamName) {
		this.matchingTeamName = matchingTeamName;
	}

	public int getTeamNOP() {
		return teamNOP;
	}

	public void setTeamNOP(int teamNOP) {
		this.teamNOP = teamNOP;
	}

	public String getInvite() {
		return invite;
	}

	public void setInvite(String invite) {
		this.invite = invite;
	}

	public String getTeamGender() {
		return teamGender;
	}

	public void setTeamGender(String teamGender) {
		this.teamGender = teamGender;
	}

	public List<MatchingTeamMemberVO> getMatchingTeamMemberVO() {
		return matchingTeamMemberVO;
	}

	public void setMatchingTeamMemberVO(List<MatchingTeamMemberVO> matchingTeamMemberVO) {
		this.matchingTeamMemberVO = matchingTeamMemberVO;
	}

	public int getMatchingTeamMaster() {
		return matchingTeamMaster;
	}

	public void setMatchingTeamMaster(int matchingTeamMaster) {
		this.matchingTeamMaster = matchingTeamMaster;
	}

	public List<Integer> getTeamStyleList() {
		return teamStyleList;
	}

	public void setTeamStyleList(List<Integer> teamStyleList) {
		this.teamStyleList = teamStyleList;
	}

	public List<Integer> getTeamPreferStyleList() {
		return teamPreferStyleList;
	}

	public void setTeamPreferStyleList(List<Integer> teamPreferStyleList) {
		this.teamPreferStyleList = teamPreferStyleList;
	}

	
}
