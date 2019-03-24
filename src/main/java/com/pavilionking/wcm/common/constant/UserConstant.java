package com.pavilionking.wcm.common.constant;

import javax.servlet.http.HttpServletRequest;

import com.pavilionking.wcm.dto.WUser;

public class UserConstant {

	public static WUser getUserInfo(HttpServletRequest request) {
		WUser user = (WUser) request.getSession().getAttribute(CommonConstant.USERINFO);
		return user;
	}
	
	public static void setUserInfo(HttpServletRequest request,WUser user) {
		request.getSession().setAttribute(CommonConstant.USERINFO, user);
		request.getSession().setMaxInactiveInterval(CommonConstant.SESSIONTIME);
	}
	
}
