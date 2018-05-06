package kr.co.hucloud.batch.job.matching.vo;

public class MemberVO {

	private int memberId;
	private String userId;
	private String password;
	private String salt;
	private String name;
	private String nickname;
	private String gender;
	private String birthday; //년,월,일 합친거
	private String birthYear;
	private String birthMonth;
	private String birthDay;
	private int admissionYear;
	private String phoneNumber;
	private String addrStr;
	private int addrId;
	private int schoolId;
	private int majorId;
	private String livingAlone;
	private String militaryService;
	private String preferLivingAlone;
	private int preferAgeStart;
	private int preferAgeEnd;
	private StyleVO styleVO;
	private PreferStyleVO preferStyleVO;
	private PreferCollegeVO preferCollegeVO;
	private PreferAddrVO preferAddrVO;
	private String aboutMe;
	private String registDate;

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}

	public String getName() {
		return name;
	}

	public String getAddrStr() {
		return addrStr;
	}

	public void setAddrStr(String addrStr) {
		this.addrStr = addrStr;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getBirthMonth() {
		return birthMonth;
	}

	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public int getAdmissionYear() {
		return admissionYear;
	}

	public void setAdmissionYear(int admissionYear) {
		this.admissionYear = admissionYear;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public int getMajorId() {
		return majorId;
	}

	public String getLivingAlone() {
		return livingAlone;
	}

	public void setLivingAlone(String livingAlone) {
		this.livingAlone = livingAlone;
	}

	public String getMilitaryService() {
		return militaryService;
	}

	public void setMilitaryService(String militaryService) {
		this.militaryService = militaryService;
	}

	public StyleVO getStyleVO() {
		return styleVO;
	}

	public void setStyleVO(StyleVO styleVO) {
		this.styleVO = styleVO;
	}

	public PreferStyleVO getPreferStyleVO() {
		return preferStyleVO;
	}

	public void setPreferStyleVO(PreferStyleVO preferStyleVO) {
		this.preferStyleVO = preferStyleVO;
	}

	public PreferCollegeVO getPreferCollegeVO() {
		return preferCollegeVO;
	}

	public void setPreferCollegeVO(PreferCollegeVO preferCollegeVO) {
		this.preferCollegeVO = preferCollegeVO;
	}

	public PreferAddrVO getPreferAddrVO() {
		return preferAddrVO;
	}

	public void setPreferAddrVO(PreferAddrVO preferAddrVO) {
		this.preferAddrVO = preferAddrVO;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public int getAddrId() {
		return addrId;
	}

	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}

	public String getPreferLivingAlone() {
		return preferLivingAlone;
	}

	public void setPreferLivingAlone(String preferLivingAlone) {
		this.preferLivingAlone = preferLivingAlone;
	}

	public int getPreferAgeStart() {
		return preferAgeStart;
	}

	public void setPreferAgeStart(int preferAgeStart) {
		this.preferAgeStart = preferAgeStart;
	}

	public int getPreferAgeEnd() {
		return preferAgeEnd;
	}

	public void setPreferAgeEnd(int preferAgeEnd) {
		this.preferAgeEnd = preferAgeEnd;
	}

	public String getRegistDate() {
		return registDate;
	}

	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}

}
