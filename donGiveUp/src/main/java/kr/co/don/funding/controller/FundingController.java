package kr.co.don.funding.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kr.co.don.funding.model.service.FundingService;
import kr.co.don.funding.model.vo.Funding;
import kr.co.don.funding.model.vo.FundingData;

@Controller
public class FundingController {
	
	@Autowired
	@Qualifier("fundingService")
	private FundingService fundingService; 
	
	@RequestMapping(value="/test.don")
	public String test() {
		return "funding/tt";
	}
	
	@RequestMapping(value="/fundingMain.don")
	public String fundingMain(Funding funding,int reqPage,Model model,String type) {
		
		/*Member m = (Member) session.getAttribute("member");
		String memberId = m.getMemberId();
		*/
		
		 HashMap<String,String> map = new HashMap<String,String>(); 
		 map.put("reqPage", String.valueOf(reqPage)); 
		 FundingData fd = new FundingData();
		 
		 if( type != null) {
			 
			 map.put("type",type);
			 fd = fundingService.selectList(map);
			 switch(type){
				 	
				 case "0" : 
					 type = "공익 나눔";
					 break;
				 case "1" :
					 type = "대안 상생";
					 break;
				 case "2" : 
					 type = "미디어 나눔";
					 break;
				
			 }
		 
		 }else {
			 fd = fundingService.selectList(map);
			 type = "전체";
		 }
		 
		System.out.println("컨트롤러"+type);
		System.out.println("컨트롤러"+fd.getList());
		
		model.addAttribute("list",fd.getList());
		model.addAttribute("pageNavi",fd.getPageNavi());
		model.addAttribute("totalCount",fd.getTotalCount());
		model.addAttribute("type",type);
		
		return "funding/fundingMain";
		
	}
	
	@ResponseBody
	//produces에 제이슨을 지정할수 있다.
	@RequestMapping(value="/fundingEndList.don", produces="application/json; charset=utf-8")
	public String fundingEndList(Funding funding,int reqPage,String type) {
		/*Member m = (Member) session.getAttribute("member");
		String memberId = m.getMemberId();
		*/

		 HashMap<String,String> map = new HashMap<String,String>(); 
		 map.put("reqPage", String.valueOf(reqPage)); 
		 FundingData fd = new FundingData();
		 
		 if( type != null) {
			 
			 map.put("type",type);
			 fd = fundingService.selectList(map);
			 switch(type){
				 	
				 case "0" : 
					 type = "공익 나눔";
					 break;
				 case "1" :
					 type = "대안 상생";
					 break;
				 case "2" : 
					 type = "미디어 나눔";
					 break;
				
			 }
		 
		 }else {
			 fd = fundingService.selectList(map);
			 type = "전체";
		 }
		 
		
		return new Gson().toJson(fd);
		
	}
	
}
