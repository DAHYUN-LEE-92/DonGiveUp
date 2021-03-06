package kr.co.don.vwork.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import kr.co.don.vserver.model.vo.VserverVo;
import kr.co.don.vwork.model.service.VworkServiceImpl;
import kr.co.don.vwork.model.vo.VworkData;
import kr.co.don.vwork.model.vo.VworkVo;

@Controller

public class VworkController {
	@Autowired
	@Qualifier("vworkService")
	private VworkServiceImpl service;
	
	@RequestMapping(value="/vworklist.don")
	public String vworklist(int count,Model model) {
		
		ArrayList<VworkVo> list = service.vworkList(count);
	  //System.out.println(list);
		for( VworkVo j : list) {
			int vworkNo = j.getVworkNo();
			int result = service.vserperCnt(vworkNo);
			j.setVserperCnt(result);

			String str = j.getVworkJoinDate();
			
			StringTokenizer st = new StringTokenizer(str,",");
			String arr[] = new String[st.countTokens()];
			int i =0;
			while(st.hasMoreElements()) {
				arr[i++] = st.nextToken();
			}
			j.setJoindCnt(arr.length);
		}
		
		//String button ="<button id=\"moreList\" value="+(count+1)+">더 보기</button>";
		String button;
	      //System.out.println(list.size());
	      if( list.size() == 6) {
	         button ="<button id=\"moreList\" value="+(count+1)+">더 보기</button>";
	      }else {
	         button = "";
	         
	      }
		
		model.addAttribute("list",list);
		model.addAttribute("button", button);
		
		return "vwork/vworklist";
	}
	
	@ResponseBody
	@RequestMapping(value="/morevwList.don",produces = "application/json; charset=utf-8;")
	public String morevwList(int count, VworkVo vw) {
		ArrayList<VworkVo> list = service.vworkList(count);
		for( VworkVo j : list) {
			int vworkNo = j.getVworkNo();
			
			int result = service.vserperCnt(vworkNo);
			j.setVserperCnt(result);
			String str = j.getVworkJoinDate();
			
			StringTokenizer st = new StringTokenizer(str,",");
			String arr[] = new String[st.countTokens()];
			int i =0;
			while(st.hasMoreElements()) {
				arr[i++] = st.nextToken();
			}
			j.setJoindCnt(arr.length);
			//System.out.println("봉사날짜 :"+(arr.length-1));
		}
		
		String button;
		if( list.size() == 6) {
	         button ="<button id=\"moreList\" value="+(count+1)+">더 보기</button>";
	      }else {
	         button = "";
	         
	      }
		
		VworkData data = new VworkData();
		data.setVworkList(list);
		data.setButton(button);
		
		return new Gson().toJson(data);
	}
	
	@RequestMapping(value="/vwListsearch.don")
	public String vwListsearch(String keyword,int count,Model model) {
		ArrayList<VworkVo> list = service.vwListsearch(keyword,count);
		for( VworkVo j : list) {
			int vworkNo = j.getVworkNo();
			
			int result = service.vserperCnt(vworkNo);
			j.setVserperCnt(result);
			
			String str = j.getVworkJoinDate();
			
			StringTokenizer st = new StringTokenizer(str,",");
			String arr[] = new String[st.countTokens()];
			int i =0;
			while(st.hasMoreElements()) {
				arr[i++] = st.nextToken();
			}
			j.setJoindCnt(arr.length);
		}
		String button;
		 
		   if( list.size() == 6) {
	         button ="<button id=\"moreList\" value="+(count+1)+"_"+keyword+">더 보기</button>";
		   }else {
	         button = "";
	         
		   }
		model.addAttribute("list",list);
		model.addAttribute("button", button);
		
		return "vwork/vwListSR";
	}
	@ResponseBody
	@RequestMapping(value="/morevwListsearch.don",produces = "application/json; charset=utf-8;")
	public String morevwListsearch(int count, String keyword, VworkVo vw) {
		ArrayList<VworkVo> list = service.vwListsearch(keyword,count);
		for( VworkVo j : list) {
			int vworkNo = j.getVworkNo();
			System.out.println(vworkNo);
			int result = service.vserperCnt(vworkNo);
			System.out.println(result);
			j.setVserperCnt(result);
			
			String str = j.getVworkJoinDate();
			
			StringTokenizer st = new StringTokenizer(str,",");
			String arr[] = new String[st.countTokens()];
			int i =0;
			while(st.hasMoreElements()) {
				arr[i++] = st.nextToken();
			}
			j.setJoindCnt(arr.length);
		}
		
		String button;
		if( list.size() == 6) {
	         button ="<button id=\"moreList\" value="+(count+1)+"_"+keyword+">더 보기</button>";
	      }else {
	         button = "";
	         
	      }
		
		VworkData data = new VworkData();
		data.setVworkList(list);
		data.setButton(button);
		
		return new Gson().toJson(data);
	}
	@ResponseBody
	@RequestMapping(value="/vwticketCnt.don",produces = "application/json; charset=utf-8;")
	public String vwticketCnt(String vserdate,int vworkNo) {
		System.out.println(vserdate);
		ArrayList<VserverVo> list = service.selectvwticketCnt(vserdate,vworkNo);
		System.out.println("구매매수~~~~");
		
		VserverVo vs = new VserverVo();
		if(! list.isEmpty()) {
			int count = 0;
			int i = 0;
			for(VserverVo j : list) {
			System.out.println(j.getVserverPer());
			count += j.getVserverPer();
			System.out.println((i++) +"번째:"+count);
			}
			vs.setTicketcount(count);
		}else {
			vs.setTicketcount(0);
		}
		return new Gson().toJson(vs);
	}
	
	@ResponseBody
	@RequestMapping(value="/vserverinsert.don",produces = "text/html; charset=utf-8;")
	public String vserverinsert(String vserverDay, int vserverPer, String vserverVms, String vserverWriter,
								int vserverRef, int amount) {
		
		VserverVo vs = new VserverVo();
		
		vs.setVserverDay(vserverDay);
		//System.out.println(vserverPer);
		vs.setVserverPer(vserverPer);
		//System.out.println(vserverVms);
		if(vserverVms=="") {
			vs.setVserverVms("null");
		}else {
			vs.setVserverVms(vserverVms);
		}
		//System.out.println(vserverWriter);
		vs.setVserverWriter(vserverWriter);
		//System.out.println(vserverRef);
		vs.setVserverRef(vserverRef);
		//System.out.println(amount);
		vs.setVserverPrice(amount);
		
		int result = service.insertvserver(vs);
		if(result>0) {
			return "1";
		}else {
			return "0";
		}
		
	}
	
	@RequestMapping(value="/vworkeditFrm.don")
	public String vworkeditFrm(int vworkNo,Model model) {
		VworkVo v = service.selectOneVwork(vworkNo);
		model.addAttribute("v",v);
		
		return "vwork/vworkeditFrm";
	}
	
	@RequestMapping(value="/vworkwrite.don")
	public String vworkwrite() {
		return "vwork/vworkwrite";
	}
	
	@RequestMapping(value="/vworkbooking.don")
	public String vworkbooking(int vworkNo, Model model) {
		VworkVo v = service.selectOneVwork(vworkNo);
		//System.out.println(v);
		model.addAttribute("v",v);
		
		return "vwork/vworkbooking";
	}
	@RequestMapping(value="/vworkpayment.don")
	public String vworkpayment(VserverVo vs, Model model) {
		int vworkNo = vs.getVserverRef();
		VworkVo vw = service.selectOneVwork(vworkNo);
		model.addAttribute("vw",vw);
		model.addAttribute("vs",vs);
		return "vwork/vworkpayment";
	}
	
	@RequestMapping(value="/vworkupdate.don")
	public String vworkupdate(int vworkNo,VworkVo v,Model model) {
		String str = v.getVworkJoinDate();
		
		StringTokenizer st = new StringTokenizer(str,",");
		String arr[] = new String[st.countTokens()];
		int i =0;
		while(st.hasMoreElements()) {
			arr[i++] = st.nextToken();
		}
		int j = arr.length-1;
		String lastdate = arr[j];
		
		v.setVworkDlDate(lastdate);
		v.setVworkNo(vworkNo);
		
		int result = service.vworkupdate(v);
		
		if(result>0) {
			model.addAttribute("msg", "수정완료");
			model.addAttribute("loc","/vworklist.don?count=1");
			return "vwork/msg";
		}else {
			model.addAttribute("msg", "수정 실패");
			model.addAttribute("loc","/vworklist.don?count=1");
			return "vwork/msg";
		}
	}
	@RequestMapping(value="/vworkinsert.don")
	public String vworkinsert(HttpServletRequest request,MultipartFile file, VworkVo vw,Model model) {
		
		//System.out.println(vw.getVworkJoinDate());
		
		String str = vw.getVworkJoinDate();
		
		StringTokenizer st = new StringTokenizer(str,",");
		String arr[] = new String[st.countTokens()];
		int i =0;
		while(st.hasMoreElements()) {
			arr[i++] = st.nextToken();
		}
		int j = arr.length-1;
		String lastdate = arr[j];
		
		vw.setVworkDlDate(lastdate);
		
		if(!file.isEmpty()){
			try {
				String savaPath = request.getSession().getServletContext().getRealPath("/resources/upload/images/");
				//업로드한 파일의 실제 파일명 -> test.txt
				String originalFilename = file.getOriginalFilename();
				//확장자를 제외한 파일명 -> test
				String onlyFilenme = originalFilename.substring(0,originalFilename.lastIndexOf("."));
				//확장자->.txt
				String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
				String filepath = onlyFilenme+"_"+getCurrentTime()+extension;
				String fullpath = savaPath+filepath;
				byte[] bytes = file.getBytes();
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(fullpath)));
				bos.write(bytes);
				bos.close();
				//System.out.println("파일업로드 완료");
				vw.setVworkFilename(originalFilename);
				vw.setVworkFilepath(filepath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int result = service.insertvwork(vw);
		if(result>0) {
			model.addAttribute("msg", "등록완료");
			model.addAttribute("loc","/vworklist.don?count=1");
			return "vwork/msg";
		}else {
			model.addAttribute("msg", "등록실패");
			model.addAttribute("loc","/vworklist.don?count=1");
			return "vwork/msg";
		}
	}
		
		public long getCurrentTime() {
			Calendar today = Calendar.getInstance();
			return today.getTimeInMillis();
			
		}
}
