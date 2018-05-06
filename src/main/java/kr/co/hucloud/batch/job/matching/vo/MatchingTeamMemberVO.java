package kr.co.hucloud.batch.job.matching.vo;

import java.util.List;

public class MatchingTeamMemberVO {

	private int matchingTeamId;
	private int memberId;
	private List<Integer> styleList;
	private List<Integer> preferStyleList;

	public int getMatchingTeamId() {
		return matchingTeamId;
	}

	public void setMatchingTeamId(int matchingTeamId) {
		this.matchingTeamId = matchingTeamId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public List<Integer> getStyleList() {
		return styleList;
	}

	public void setStyleList(List<Integer> styleList) {
		this.styleList = styleList;
	}

	public List<Integer> getPreferStyleList() {
		return preferStyleList;
	}

	public void setPreferStyleList(List<Integer> preferStyleList) {
		this.preferStyleList = preferStyleList;
	}

}
