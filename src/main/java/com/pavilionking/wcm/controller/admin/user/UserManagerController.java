package com.pavilionking.wcm.controller.admin.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pavilionking.wcm.common.annotation.LogInfo;
import com.pavilionking.wcm.common.constant.CommonConstant;
import com.pavilionking.wcm.common.constant.PageUtils;
import com.pavilionking.wcm.common.constant.ResponseMessage;
import com.pavilionking.wcm.service.user.UserManagerService;

/**   
 * @ClassName:  UserManagerController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: CLONG
 * @date:   2019年3月23日 下午12:01:59  
 */  
@Controller
@RequestMapping("userManager")
public class UserManagerController {

	@Resource
	private UserManagerService userManagerService;
	
	@RequestMapping("list")
	@ResponseBody
	@LogInfo(memo="用户列表")
	public ResponseMessage list(Integer page,Integer rows) {
		ResponseMessage result = new ResponseMessage();
		try {
			PageUtils pageUtils = new PageUtils(page, rows);
			userManagerService.list(result,pageUtils);
			result.setCode(CommonConstant.SUCCESSCODE);
			result.setMsg(CommonConstant.SUCCESSSTRING);
		} catch (Exception e) {
			result.setCode(CommonConstant.FAILURECODE);
			result.setMsg(CommonConstant.FAILMAG);
		}
		return result;
	}
}
