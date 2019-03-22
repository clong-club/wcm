package com.pavilionking.wcm.controller.admin.home;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pavilionking.wcm.common.constant.CommonConstant;
import com.pavilionking.wcm.common.constant.ResponseMessage;

@RequestMapping("home")
public class HomeController {

	@ResponseBody
	@RequestMapping("carouselfigureList")
	public ResponseMessage carouselfigureList(){
		ResponseMessage result = new ResponseMessage();
		try {
			result.setCode(CommonConstant.SUCCESSCODE);
			result.setMsg(CommonConstant.SUCCESSSTRING);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
