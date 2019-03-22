package com.pavilionking.wcm.common.constant;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;



/**   
 * @ClassName:  CommonConstant   
 * @Description:TODO(公共参数表)   
 * @author: CLONG
 * @date:   2018年10月8日 下午3:40:54  
 * @Copyright: 2018 www.derlte.com Inc. All rights reserved. 
 * 注意：本内容仅限于天津德尔塔科技有限公司内部传阅，禁止外泄以及用于其他的商业目 
 */  
@Component
public  class CommonConstant {
	
	public static final Byte BYTE0 = 0;
	public static final Byte BYTE1 = 1;
	public static final Byte BYTE2 = 2;
	public static final Byte BYTE3 = 3;
	
	public static final int INT0 = 0;
	public static final int INT1 = 1;
	public static final int INT2 = 2;
	public static final int INT3 = 3;
	public static final int INT4 = 4;
	public static final int INT5 = 5;
	public static final BigDecimal BIGDECIMAL0 = new BigDecimal(0);
	public static final BigDecimal BIGDECIMAL1 = new BigDecimal(1);
	public static final BigDecimal BIGDECIMAL2 = new BigDecimal(2);
	
	/*@Value("${wsdlPath}")
	public static String wsdlPath;*/
	
	//初始化加载
    /*@PostConstruct
    public void init(){
    	wsdlPath
    }
	*/
	public static final String STR0 = "0";
	public static final String STR1 = "1";
	public static final String STR2 = "2";
	public static final String STR3 = "3";
	
	public static final int SUCCESSCODE = 211;
	public static final int SUCCESSCODE212 = 212;
	public static final String SUCCESSSTRING = "操作成功";
	
	public static final int SSOLOGINOUTCODE = 311;
	public static final String SSOLOGINOUTMSG = "sso退出成功";
	
	public static final int LOGINOUTCODE = 312;
	public static final String LOGINOUTMSG = "退出成功";
	
	public static final int EXCEPTIONCODE = 510;//服务器异常
	public static final String EXCEPTIONMSG = "服务器异常";//服务器异常
	public static final int PARAMERROR = 511;//参数错误
	public static final int NULLCODE = 512;//结果不存在
	public static final int REPEATCODE = 513;//结果重复
	public static final int FAILURECODE = 514;//操作失败
	public static final String FAILMAG = "操作失败";
	public static final String EMAILEXCEPTIONMSG = "邮件发送异常";
	public static final int INFORMATION = 516;//个人资料信息不全
	public static final int BLACKLIST = 517;//黑名单
	
	public static final int FILEERRORCODE = 515;//服务器异常
	public static final String FILEERRORMSG = "不支持该格式上传";//服务器异常
	public static final String NOFILEERRORMSG = "请上传图片";//请上传图片
	public static final String CNTEDITMSG = "当前稿件处于【%s】阶段，您没有权限操作";//不可编辑
	public static final String NOTCNTEDITMSG = "当前稿件不在【%s】阶段，不能进行【%s】操作";//不可编辑
	public static final String PARAMERRORMSG = "参数异常";//参数异常
	
	public static final int NOTLOGINCODE = 520;//未登录
	public static final String NOTLOGINMSG = "未登录";//未登录
	public static final int NORIGHT = 521;//没有权限
	public static final String LANGTYPE = "langType";
	public static final Integer SESSIONTIME = 3600;
	
	public static final int FAILUREMILLSSALT = 300;
	//TODO
	public static final int FAILUREMILLSTOKEN = 1800;//半小时1800s
	public static final Long HOURS72 = 259200000L;//72小时1800s
	public static final String USERSALT = "userSalt_";
	public static final String REDISID = "redisId_";
	public static final String ONLINUSERLIST= "onlineUserlist";
	
	public static final String doubleSprit= "\\";
	public static final String oneSprit= "/";
	public static final String NEWLINE= "<br/>";
	public static final String EN = "en";
	public static final String ZH = "zh";
	public static final String SMALL= "small";
	public static final String WATER= "watermark";
	public static final String WATERMEDIUM= "watermarkedmedium";
	public static  String SMALLHTTPPath;
	
	public static final String Site = "Site";
	public static final String Role = "Role";
	public static final String Right = "Right";
	public static final String Other = "Other";
	public static final String User = "User";
	public static final String Message = "Message";//站内信
	public static final String Notice = "Notice";//公告
	public static final String PostComment = "PostComment";//网站留言
	public static final String UserLogin = "UserLogin";
	public static final String Config = "Config";
	public static final String Email = "Email";
	public static final String Car = "Car";
	public static final String Adver = "Adver";
	public static final String Picture = "Picture";
	public static final String Favorite = "Favorite";
	public static final String LeavingMsg = "LeavingMsg";
	public static final String Needs = "Needs";
	public static final String Order = "Order";
	public static final String PhoneMsg = "PhoneMsg";
	public static final String Blacklist = "Blacklist";
	public static final String Topic = "Topic";

	public static final String PicGroupOperation = "PicGroupOperation";

	public static final String Category = "Category";
	
	//用户角色权限
	public static final String USERINFO= "Redis_UserInfo";
	public static final String CURRTROLEINFO= "Redis_CurrtRoleInfo_";
	public static final String ROLEINFO= "Redis_RoleInfo_";
	public static final String CURRTROLERIGHT= "Redis_CurrtRoleRight_";
	public static final String SESSIONID = "sessionId";//没有权限
	public static final String UUIDCODE = "UUIDCODE";
	
	public static class OpCode {
		public static final short SUCCESS = 200;
		public static final short INVALID_PARAMS = 400;
		public static final short NEED_AUTHORIZATION = 401;
		public static final short NOT_PERMITED = 403;
		public static final short RESOURCE_NOT_FOUND = 404;
		public static final short INTERNAL_EXCEPTION = 500;
	}
	
    public static String getRemoteAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    
    
}























