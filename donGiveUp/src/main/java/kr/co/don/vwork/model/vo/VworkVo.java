package kr.co.don.vwork.model.vo;


public class VworkVo {
	private int vworkNo;
	private String vworkTitle;
	private String vworkReqDate;
	private String vworkDlDate;
	private String vworkJoinDate;
	private int vworkPer;
	private String vworkIntro;
	private String vworkDetail;
	private String vworkAddress;
	private int vworkFee;
	private String vworkFilename;
	private String vworkFilepath;
	private String vworkWriter;
	private String vworkSelect;
	private String vworkState;
	private String vworkNegative;
	private int joindCnt;
	private String companyName;
	private String memberPhone;
	private String companyFilename;
	private String companyFilepath;
	private int vserperCnt;
	public VworkVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VworkVo(int vworkNo, String vworkTitle, String vworkReqDate, String vworkDlDate, String vworkJoinDate,
			int vworkPer, String vworkIntro, String vworkDetail, String vworkAddress, int vworkFee,
			String vworkFilename, String vworkFilepath, String vworkWriter, String vworkSelect, String vworkState,
			String vworkNegative, int joindCnt, String companyName, String memberPhone, String companyFilename,
			String companyFilepath, int vserperCnt) {
		super();
		this.vworkNo = vworkNo;
		this.vworkTitle = vworkTitle;
		this.vworkReqDate = vworkReqDate;
		this.vworkDlDate = vworkDlDate;
		this.vworkJoinDate = vworkJoinDate;
		this.vworkPer = vworkPer;
		this.vworkIntro = vworkIntro;
		this.vworkDetail = vworkDetail;
		this.vworkAddress = vworkAddress;
		this.vworkFee = vworkFee;
		this.vworkFilename = vworkFilename;
		this.vworkFilepath = vworkFilepath;
		this.vworkWriter = vworkWriter;
		this.vworkSelect = vworkSelect;
		this.vworkState = vworkState;
		this.vworkNegative = vworkNegative;
		this.joindCnt = joindCnt;
		this.companyName = companyName;
		this.memberPhone = memberPhone;
		this.companyFilename = companyFilename;
		this.companyFilepath = companyFilepath;
		this.vserperCnt = vserperCnt;
	}
	
	public String getVworkIntroBr(){
        return vworkIntro.replaceAll("\r\n", "<br>");
     }
	
	public int getVworkNo() {
		return vworkNo;
	}
	public void setVworkNo(int vworkNo) {
		this.vworkNo = vworkNo;
	}
	public String getVworkTitle() {
		return vworkTitle;
	}
	public void setVworkTitle(String vworkTitle) {
		this.vworkTitle = vworkTitle;
	}
	public String getVworkReqDate() {
		return vworkReqDate;
	}
	public void setVworkReqDate(String vworkReqDate) {
		this.vworkReqDate = vworkReqDate;
	}
	public String getVworkDlDate() {
		return vworkDlDate;
	}
	public void setVworkDlDate(String vworkDlDate) {
		this.vworkDlDate = vworkDlDate;
	}
	public String getVworkJoinDate() {
		return vworkJoinDate;
	}
	public void setVworkJoinDate(String vworkJoinDate) {
		this.vworkJoinDate = vworkJoinDate;
	}
	public int getVworkPer() {
		return vworkPer;
	}
	public void setVworkPer(int vworkPer) {
		this.vworkPer = vworkPer;
	}
	public String getVworkIntro() {
		return vworkIntro;
	}
	public void setVworkIntro(String vworkIntro) {
		this.vworkIntro = vworkIntro;
	}
	public String getVworkDetail() {
		return vworkDetail;
	}
	public void setVworkDetail(String vworkDetail) {
		this.vworkDetail = vworkDetail;
	}
	public String getVworkAddress() {
		return vworkAddress;
	}
	public void setVworkAddress(String vworkAddress) {
		this.vworkAddress = vworkAddress;
	}
	public int getVworkFee() {
		return vworkFee;
	}
	public void setVworkFee(int vworkFee) {
		this.vworkFee = vworkFee;
	}
	public String getVworkFilename() {
		return vworkFilename;
	}
	public void setVworkFilename(String vworkFilename) {
		this.vworkFilename = vworkFilename;
	}
	public String getVworkFilepath() {
		return vworkFilepath;
	}
	public void setVworkFilepath(String vworkFilepath) {
		this.vworkFilepath = vworkFilepath;
	}
	public String getVworkWriter() {
		return vworkWriter;
	}
	public void setVworkWriter(String vworkWriter) {
		this.vworkWriter = vworkWriter;
	}
	public String getVworkSelect() {
		return vworkSelect;
	}
	public void setVworkSelect(String vworkSelect) {
		this.vworkSelect = vworkSelect;
	}
	public String getVworkState() {
		return vworkState;
	}
	public void setVworkState(String vworkState) {
		this.vworkState = vworkState;
	}
	public String getVworkNegative() {
		return vworkNegative;
	}
	public void setVworkNegative(String vworkNegative) {
		this.vworkNegative = vworkNegative;
	}
	public int getJoindCnt() {
		return joindCnt;
	}
	public void setJoindCnt(int joindCnt) {
		this.joindCnt = joindCnt;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getCompanyFilename() {
		return companyFilename;
	}
	public void setCompanyFilename(String companyFilename) {
		this.companyFilename = companyFilename;
	}
	public String getCompanyFilepath() {
		return companyFilepath;
	}
	public void setCompanyFilepath(String companyFilepath) {
		this.companyFilepath = companyFilepath;
	}
	public int getVserperCnt() {
		return vserperCnt;
	}
	public void setVserperCnt(int vserperCnt) {
		this.vserperCnt = vserperCnt;
	}
	
	
	
}

