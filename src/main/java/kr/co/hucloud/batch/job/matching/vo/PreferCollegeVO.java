package kr.co.hucloud.batch.job.matching.vo;

import java.util.List;

public class PreferCollegeVO {

	private int memberId;
	private List<Integer> collegeId;
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public List<Integer> getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(List<Integer> collegeId) {
		this.collegeId = collegeId;
	}
	
	
	
}
