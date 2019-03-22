package com.pavilionking.wcm.controller.mainsite;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.context.Context;

import com.pavilionking.wcm.common.constant.CommonConstant;
import com.pavilionking.wcm.common.constant.ResponseMessage;
import com.pavilionking.wcm.common.constant.thymeleaf.FreemarkerUtils;
import com.pavilionking.wcm.service.user.UserManagerService;

@Controller
@RequestMapping("indexPage")
public class IndexPageController {

	@Autowired
	private FreemarkerUtils freeUtrils;
	
	@Autowired 
	private UserManagerService userManagerService;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
/*	@RequestMapping("/test")
	public ResponseMessage index(HttpServletRequest request) {
		ResponseMessage result = new ResponseMessage();
		try {
			Context context = new Context();
			context.setVariable("name", "张三");
			freeUtrils.process("index", context, "./htmlfile/"+dateFormat.format(new Date()));
			result.setCode(CommonConstant.SUCCESSCODE);
			result.setMsg(CommonConstant.SUCCESSSTRING);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}*/
	
	@RequestMapping(value = "/greeting")
	public ModelAndView test(ModelAndView mv) {
	    mv.setViewName("/greeting");
	    mv.addObject("title","欢迎使用Thymeleaf!");
	    return mv;
	}
	
	@RequestMapping(value = "/index")
	public ModelAndView index(ModelAndView mv) {
	    mv.setViewName("/index2");
	    mv.addObject("name","欢迎使用Thymeleaf!");
	    return mv;
	}
	
	@RequestMapping(value = "/home")
	public ModelAndView home(ModelAndView mv) {
	    mv.setViewName("/home");
	    mv.addObject("name","欢迎使用Thymeleaf!");
	    return mv;
	}
}
