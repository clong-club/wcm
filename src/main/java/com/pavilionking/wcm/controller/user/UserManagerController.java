package com.pavilionking.wcm.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pavilionking.wcm.common.constant.ResponseMessage;
import com.pavilionking.wcm.service.user.UserManagerService;

@Controller
@RequestMapping("userManager")
public class UserManagerController {

	@Resource
	private UserManagerService userManagerService;
	
	@RequestMapping("list")
	@ResponseBody
	public ResponseMessage list() {
		ResponseMessage result = new ResponseMessage();
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
}
