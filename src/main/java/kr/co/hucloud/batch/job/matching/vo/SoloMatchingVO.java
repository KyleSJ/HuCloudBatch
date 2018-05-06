package kr.co.hucloud.batch.job.matching.vo;

public class SoloMatchingVO {

	private int soloMatchingId;
	private int fMatchingId;
	private int mMatchingId;
	private MemberVO partner;

	public int getSoloMatchingId() {
		return soloMatchingId;
	}

	public void setSoloMatchingId(int soloMatchingId) {
		this.soloMatchingId = soloMatchingId;
	}

	public int getfMatchingId() {
		return fMatchingId;
	}

	public void setfMatchingId(int fMatchingId) {
		this.fMatchingId = fMatchingId;
	}

	public int getmMatchingId() {
		return mMatchingId;
	}

	public void setmMatchingId(int mMatchingId) {
		this.mMatchingId = mMatchingId;
	}

	public MemberVO getPartner() {
		return partner;
	}

	public void setPartner(MemberVO partner) {
		this.partner = partner;
	}
	

}
