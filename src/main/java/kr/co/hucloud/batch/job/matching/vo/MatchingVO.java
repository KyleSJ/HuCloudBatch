package kr.co.hucloud.batch.job.matching.vo;

public class MatchingVO {

	private int matchingId;
	private MatchingTeamVO manMatchingTeam;
	private MatchingTeamVO womenMatchingTeam;

	public int getMatchingId() {
		return matchingId;
	}

	public void setMatchingId(int matchingId) {
		this.matchingId = matchingId;
	}

	public MatchingTeamVO getManMatchingTeam() {
		return manMatchingTeam;
	}

	public void setManMatchingTeam(MatchingTeamVO manMatchingTeam) {
		this.manMatchingTeam = manMatchingTeam;
	}

	public MatchingTeamVO getWomenMatchingTeam() {
		return womenMatchingTeam;
	}

	public void setWomenMatchingTeam(MatchingTeamVO womenMatchingTeam) {
		this.womenMatchingTeam = womenMatchingTeam;
	}

}
