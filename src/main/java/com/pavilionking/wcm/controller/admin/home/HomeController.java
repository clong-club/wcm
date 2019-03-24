package com.pavilionking.wcm.controller.admin.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pavilionking.wcm.common.annotation.LogInfo;
import com.pavilionking.wcm.common.constant.CommonConstant;
import com.pavilionking.wcm.common.constant.ResponseMessage;

@RequestMapping("home")
@Controller
public class HomeController {

	/**   
	 * @Title: carouselfigureList   
	 * @Description: TODO(首页轮播图)   
	 * @param: @return      
	 * @return: ResponseMessage      
	 * @throws   
	 * @author: CLONG
	 * @date:   2019年3月23日 下午11:42:02 
	 */ 
	@ResponseBody
	@RequestMapping("carouselfigureList")
	@LogInfo(content="",memo="首页轮播图",logTypeCode="",opeType=2)
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
