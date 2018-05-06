package kr.co.hucloud.batch.job.matching.vo;

public class SimilarObject {

	private int indexOfFemaleList;
	private int indexOfMaleList;
	private int similarFtoM;
	private int similarMtoF;
	
	public void setAll(int i, int j, int k, int m) {
		this.indexOfFemaleList = i;
		this.indexOfMaleList = j;
		this.similarFtoM = k;
		this.similarMtoF = m;
	}
	
	public int similar() {
		return similarFtoM+similarMtoF;
	}
	
	public int getIndexOfFemaleList() {
		return indexOfFemaleList;
	}

	public void setIndexOfFemaleList(int indexOfFemaleList) {
		this.indexOfFemaleList = indexOfFemaleList;
	}

	public int getIndexOfMaleList() {
		return indexOfMaleList;
	}

	public void setIndexOfMaleList(int indexOfMaleList) {
		this.indexOfMaleList = indexOfMaleList;
	}

	public int getSimilarFtoM() {
		return similarFtoM;
	}

	public void setSimilarFtoM(int similarFtoM) {
		this.similarFtoM = similarFtoM;
	}

	public int getSimilarMtoF() {
		return similarMtoF;
	}

	public void setSimilarMtoF(int similarMtoF) {
		this.similarMtoF = similarMtoF;
	}

}
