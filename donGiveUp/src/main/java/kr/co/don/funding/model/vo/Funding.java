package kr.co.don.funding.model.vo;

import lombok.Data;

@Data
public class Funding {
	
	private int fundingNo;
	private String fundingTitle;
	private String fundingContent;
	private String fundingGroup;
	private String fundingGroupIntroduce;
	private int fundingClass;
	private int fundingType;
	private String fundingStartDate;
	private String fundingEndDate;
	private String fundingManager;
	private int fundingGoalPrice;
	private int fundingNowPrice;
	private int fundingNegative;
	private String fundingFilepath;
	
	
}
