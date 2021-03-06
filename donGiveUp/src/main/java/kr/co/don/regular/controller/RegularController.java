package kr.co.don.regular.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javafx.scene.control.Alert;
import kr.co.don.donation.model.service.DonationService;
import kr.co.don.donation.model.vo.DonationData;
import kr.co.don.donationIn.model.vo.DonationInVo;
import kr.co.don.member.model.vo.Member;
import kr.co.don.regular.model.service.RegularService;
import kr.co.don.regular.model.vo.Regular;
import kr.co.don.regular.model.vo.RegularData;
import kr.co.don.regularIn.model.vo.RegularInVo;
import kr.co.don.donation.model.vo.Donation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
public class RegularController {
	@Autowired
	private RegularService service;
	
	@RequestMapping(value = "/regular.don")
	public String regular(int reqPage, String type, Model model) {
		ArrayList<Member> list = service.RegularList(reqPage, type);
		int count = list.size();
		model.addAttribute("count", count);
		model.addAttribute("regular", list);
		return "regular/regular";

	}
	
	@RequestMapping(value = "/regularInsertFrm.don")
	public String regularInsertFrm() {
		return "regular/regularInsert";
	}
	
	@RequestMapping(value = "/regularDetail2.don")
	public String regularDetailFrm(Regular regular, Model model) {

		
		model.addAttribute("r", regular);
	
	
		return "regular/regularDetail2";	
	}
	
	
	@RequestMapping(value = "/regularInsert.don")
	public String regularInsert(Regular regular,Model model) {
		
		regular.setRegularType("전체,"+regular.getRegularType());
		
		int result = service.regularInsert(regular);
		
		
		
		int reqPage =1;
		String type="전체";
		ArrayList<Member> list = service.RegularList(reqPage, type);
	
		int count = list.size();
		model.addAttribute("count", count);
		model.addAttribute("regular", list);
		
		
		if (result > 0) {
			return "regular/regular";
		} else {
			return "regular/regularInsert";
		}
	}
	@RequestMapping(value = "/regularDetail.don")
	public String regularDetail(String regularWriter,Model model) {
		
		Regular detail = service.RegularDetail(regularWriter);
		List<RegularInVo> count  = service.RegularInCount(regularWriter);
		Member m = service.MemberDetail(regularWriter);
		int size = count.size();
		System.out.println("재무제표 : " + m.getChartFilename());
		System.out.println("재무제표 경로: " + m.getChartFilepath());
		model.addAttribute("company", m);
		model.addAttribute("size",size);
		model.addAttribute("detail", detail);
	
		return "regular/regularDetail";	
	}
	
	@RequestMapping(value = "/regularMoney.don")
	public String regularMoney(Regular regular,String companyName,String memberId ,Model model) {
		
		Member m = service.MemberMoney(memberId);
		model.addAttribute("m",m);
		model.addAttribute("r", regular);
		model.addAttribute("companyName", companyName);
	
		return "regular/regularMoney";	
	}
	
	@RequestMapping(value = "/regularInInsert.don")
	public String regularInInsert(Member m,String companyName, RegularInVo r, Model model) {
		
		Member mem = service.MemberIdSearch(companyName);
		r.setRegularId(mem.getMemberId());
		System.out.println("r : "+r.getRegularId());
	      SimpleDateFormat format2 = new SimpleDateFormat ( "yy/MM/");
	      SimpleDateFormat format1 = new SimpleDateFormat ( "yy년 MM월 dd일");
			

		
			
	      Date time = new Date();
	            
	      String time1 = format1.format(time);
	      String time2 = format2.format(time);
	            
	      

	      r.setRegularInPayNum(time2+r.getRegularInPayNum());

		int result = service.RegularInInsert(r);
		
		
		
		int memMon= m.getMemberMoney();
		int regInMon = r.getRegularInMoney();
		int resultMon = memMon-regInMon;
		
		m.setMemberId(r.getRegularInId());
		m.setMemberMoney(resultMon);
		model.addAttribute("m",m);
		model.addAttribute("r",r);
		model.addAttribute("time",time1);
		if (result > 0) {
//			int result2 = service.MemberMoneyUpdate(m);
//			if(result2>0) {
//			return "regular/regularInSuccess";
//		} else {
//			return "regular/regularInFail";
//			
//		}
			return "regular/regularInSuccess";
	}else {
		return "regular/regularInFail";
	}
		
	}
	
}