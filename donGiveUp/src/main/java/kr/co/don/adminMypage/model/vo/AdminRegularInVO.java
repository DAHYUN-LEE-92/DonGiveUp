package kr.co.don.adminMypage.model.vo;

import lombok.Data;

@Data
public class AdminRegularInVO {
	private int rNum;
	private int regularInNo;
	private String groupName;
	private String regularId;
	private int regularInMoney;
	private int regularInPayNum;
	private int regularNo;
	private int regularInCancel;
	private String memberPhone;
	private String memberEmail;
}