package com.pavilionking.wcm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Example {
	
	@RequestMapping("/")
	public String indere(){
		return "redirect:/index";
	}
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/about")
	public String about(){
		return "about";
	}
	@RequestMapping("/content1")
	public String content1(){
		return "content1";
	}

	@RequestMapping("/content2")
	public String content2(){
		return "content2";
	}
	@RequestMapping("/content3")
	public String content3(){
		return "content3";
	}
	@RequestMapping("/childrenCom")
	public String childrenCom(HttpServletRequest request, String childrenName,Model model){
		model.addAttribute("childrenName", childrenName);
		return "childrenCom";
	}
	@RequestMapping("/footer")
	public String footer(){
		return "footer";
	}
	
	

}
