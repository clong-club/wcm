package com.pavilionking.wcm.common.filter;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Modifier;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.pavilionking.wcm.common.annotation.LogInfo;
import com.pavilionking.wcm.common.constant.ResponseMessage;
import com.pavilionking.wcm.dto.WOperateLog;
import com.pavilionking.wcm.service.log.LogService;

import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

@Aspect
@Component
public class OperLogInterceptor {
	
	@Resource
	private LogService logService;
	
	/*@Resource
	private KUserRoleMapper kUserRoleMapper;*/
	private static final Logger logger = LoggerFactory.getLogger(OperLogInterceptor.class);

	
    //这里写的为环绕触发 ，可自行根据业务场景选择@Before @After
    //触发条件为：com.opr包下面所有类且注解为OperLog的
    @Around("within(com.pavilionking.wcm..*) && @annotation(logInfo)")
    public Object doAroundMethod(ProceedingJoinPoint pjp,LogInfo logInfo) {
    	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
    	Object[] params = pjp.getArgs();//获取请求参数
    	

        //long startTime=System.currentTimeMillis();//开始时间
        
        //System.out.println("监听到传入参数为:");
    	/*for(Object param:params) {
            System.out.println(param);
        }*/
        WOperateLog log = new WOperateLog();
        log.setStartTime(new Date());
        //###################上面代码为方法执行前#####################
        ResponseMessage result = null;
		try {
			
			String classType = pjp.getTarget().getClass().getName();    
	        Class<?> clazz = Class.forName(classType);    
	        String clazzName = clazz.getName();    
	        String methodName = pjp.getSignature().getName(); //获取方法名称   
	         //获取参数名称和值  
	        Map<String,Object > nameAndArgs = this.getFieldsName(this.getClass(), clazzName, methodName,params);   
	        //nameAndArgs的两种类型，用实体类接收的类似这样： reqParams=com.ynet.finmall.innermanage.event.SaveOrUpdateRoleReqParam@616b9c0e
	        //用Map<String,Object>接收的是这样：menuNo=56473283，遍历这个map区分两种不同，使用不同的取值方式。
	        //根据获取到的值所属的不同类型通过两种不同的方法获取参数
	        if(nameAndArgs!=null && nameAndArgs.size()>0){
	        	StringBuffer operatePara = new StringBuffer();
	            for (Map.Entry<String, Object> entry : nameAndArgs.entrySet()) {  
		            // logger.info(">>>>>>>>>>>>>>类型");
		            String key = entry.getKey();
		            Object value = entry.getValue();
		            if(!(value instanceof HttpServletRequest) && !(value instanceof HttpServletResponse) && value != null && value.toString()!=""){
		            	String valueToString = "";
		            	if(value instanceof String || value instanceof Integer || value instanceof Double || value instanceof Date){
		            		valueToString = value.toString();
		            		operatePara.append(key+":"+valueToString+"; ");
		            	}else{
//		            		valueToString = JsonUtil.fromObject(value);
		            		PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
		                    PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(value);
		                    for (int i = 0; i < descriptors.length; i++) {
		                        String name = descriptors[i].getName();
		                        if (!"class".equals(name)) {
		                        	Object property = propertyUtilsBean.getNestedProperty(value, name);
		                        	if(property != null && property.toString()!=""){
		                        		operatePara.append(name+":"+property+"; ");
		                        	}
		                        }
		                    }
		            	}
//		            	operatePara.append(key+":"+valueToString+"; ");
		            }
	            }
	            log.setOperateParam(operatePara.toString());
	        }
			
			
			result = (ResponseMessage) pjp.proceed();
			//###################下面代码为方法执行后#####################
			//System.out.println("返回参数为:" + result);
			
			String user = logInfo.logTypeCode();//操作人
			String operType = logInfo.content();//操作类型
			//System.out.println("操作人: " + user +" 操作类型: " + operType);
			
			//long endTime=System.currentTimeMillis();//结束时间
			//float excTime=(float)(endTime-startTime)/1000;
			if(result != null){
				log.setOperateResult(""+result.getCode());
				//log.setDetail(result.getMsg());
			}
			log.setOperateMethod(getControllerMethodDescription(pjp));
			String ip = request.getRemoteAddr();
			log.setOperateIp(ip);
			
			/*KUser kuser = UserConstant.getUser(request);
			if(kuser!=null){
				// 获取访问者的唯一标识
				log.setVisitorId(kuser.getId());
				// 获取用户名
				log.setOperatorName(kuser.getUsername());
				KUserRoleExample example = new KUserRoleExample();
				example.createCriteria().andUserIdEqualTo(kuser.getId());
				List<KUserRole> selectByExample = kUserRoleMapper.selectByExample(example);
				if(selectByExample!=null && !selectByExample.isEmpty()){
					KUserRole kUserRole = selectByExample.get(CommonConstant.INT0);
					log.setRoleId(kUserRole.getRoleId());
				}
				
			}*/
			log.setUrl(request.getRequestURI());
			//System.out.println("保存前：^^^^^^^^^^^^^^^^^^^^^");
			log.setEndTime(new Date());
			//String json = JSONUtils.valueToString(log);
			//logger.info(URLDecoder.decode(json,"utf-8"));
			/*SyslogIF syslog = Syslog.getInstance("udp"); 
			//设置syslog服务器端地址
			syslog.getConfig().setHost("127.0.0.1");
			//设置syslog接收端口，默认514
			syslog.getConfig().setPort(514);
			//拼接syslog日志，这个日志是自己定义的，通常我们定义成符合公司规范的格式就行，方便查询。例如 操作时间：2014年8月1日  操作者ID:张三 等。信息就是一个字符串。
			StringBuffer buffer = new StringBuffer();
			buffer.append("操作时间：" + new Date().toString().substring(4, 20) + ";");
			buffer.append("操作者ID:" + "张三" + ";");
			buffer.append("操作时间:" + new Date()+ ";");
			buffer.append("日志类别:" + "0"+ ";");
			buffer.append("执行动作:" + "动作" + ";");
			buffer.append("备注:" + "备注");
				发送信息到服务器，2表示日志级别 范围为0~7的数字编码，表示了事件的严重程度。0最高，7最低
			 *  syslog为每个事件赋予几个不同的优先级：
				LOG_EMERG：紧急情况，需要立即通知技术人员。
				LOG_ALERT：应该被立即改正的问题，如系统数据库被破坏，ISP连接丢失。
				LOG_CRIT：重要情况，如硬盘错误，备用连接丢失。
				LOG_ERR：错误，不是非常紧急，在一定时间内修复即可。
				LOG_WARNING：警告信息，不是错误，比如系统磁盘使用了85%等。
				LOG_NOTICE：不是错误情况，也不需要立即处理。
				LOG_INFO：情报信息，正常的系统消息，比如骚扰报告，带宽数据等，不需要处理。
				LOG_DEBUG：包含详细的开发情报的信息，通常只在调试一个程序时使用。
			 
			//syslog.log(0, URLDecoder.decode(json,"utf-8"));
			//syslog.log(0, URLDecoder.decode(buffer.toString(),"utf-8"));
*/			logService.saveLog(log);
			//System.out.println("保存后^^^^^^^^^^^^^^^^^^^^^");
			//System.out.println("执行时间:"+excTime+"s");
			//System.out.println(this);
			//System.out.println("#######################分隔符##########################");
			return result;
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//执行方法，获取返回参数
		return result;
        
    }
    

    private Map<String,Object> getFieldsName(Class cls, String clazzName, String methodName, Object[] args) throws Exception {   
        Map<String,Object > map=new HashMap<String,Object>(); 


        ClassPool pool = ClassPool.getDefault();    
        ClassClassPath classPath = new ClassClassPath(cls);    
        pool.insertClassPath(classPath);    
            
        CtClass cc = pool.get(clazzName);    
        CtMethod cm = cc.getDeclaredMethod(methodName);    
        MethodInfo methodInfo = cm.getMethodInfo();  
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();    
        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);    
        if (attr == null) {    
            // exception    
        }    
        int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;    
        for (int i = 0; i < cm.getParameterTypes().length; i++){    
            map.put( attr.variableName(i + pos),args[i]);//paramNames即参数名    
        }    
        return map;    
    }    


    /*@AfterThrowing(pointcut = "serviceAspect()", throwing = "e")
	public void doAfterThrowing(ProceedingJoinPoint pjd,LogInfo logInfo) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		// 获取请求ip
		String ip = request.getRemoteAddr();
		LogException logException = new LogException();
		try {
			 ==========数据库日志========= 
			logException.setExceptionCode(e.getClass().getName());
			logException.setExceptionMessage(e.getMessage());
			logException.setExceptionMethod(
					(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
			System.out.println("保存前：#################################");
			System.out.println(this);
			System.out.println(logException.getLogOperateId() + "$$");
			logException.setMethodDescription(getServiceMthodDescription(joinPoint));
			// 保存数据库
			logService.saveLogException(logException);
			System.out.println("保存后：#################################");
		} catch (Exception exception) {
			// 记录本地异常日志
			exception.printStackTrace();
			logger.error("==serivce通知异常==");
			logger.error(String.format("异常信息:{}", e.getMessage()));
		}
		 ==========记录本地异常日志========== 
		logger.error(String.format("异常方法:{}异常代码:{}异常信息:{}参数:{}",
				joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName(), e.getClass().getName(),
				e.getMessage()));

	}

	public static String getServiceMthodDescription(ProceedingJoinPoint joinPoint) throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		String description = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					description = method.getAnnotation(LogInfo.class).memo();
					break;
				}
			}
		}
		return description;
	}*/
    static String menu = "";
    public static String getControllerMethodDescription(ProceedingJoinPoint pjp) throws Exception {
		String targetName = pjp.getTarget().getClass().getName();
		String methodName = pjp.getSignature().getName();
		Object[] arguments = pjp.getArgs();
		
		ClassPool pool = ClassPool.getDefault();    
//	    ClassClassPath classPath = new ClassClassPath(pjp.getTarget().getClass());    
//	    pool.insertClassPath(classPath);    
	    CtClass cc = pool.get(targetName);    
	    CtMethod method = cc.getDeclaredMethod(methodName);    
	    CtClass[] clazzs = method.getParameterTypes();
	        
//		Class targetClass = Class.forName(targetName);
//		Method[] methods = targetClass.getMethods();
		String description = "";
//		for (Method method : methods) {
//			if (method.getName().equals(methodName)) {
//				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					if(methodName.equals("getMenuList")){
						Object[] args = pjp.getArgs();
						if(pjp.getArgs()[1].toString().equals("1")){
							description = "进入首页";
							menu = "首页-";
						}else if(pjp.getArgs()[1].toString().equals("2")){
							description = "进入单位查询";
							menu = "单位查询-";
						}else if(pjp.getArgs()[1].toString().equals("3")){
							description = "进入资源分析";
							menu = "资源分析-";
						}else if(pjp.getArgs()[1].toString().equals("4")){
							description = "进入区域分析";
							menu = "区域分析-";
						}else if(pjp.getArgs()[1].toString().equals("5")){
							description = "进入行业分析";
							menu = "行业分析-";
						}else if(pjp.getArgs()[1].toString().equals("6")){
							description = "进入专题分析";
							menu = "专题分析-";
						}else if(pjp.getArgs()[1].toString().equals("7")){
							description = "进入后台管理";
							menu = "后台管理-";
						}
					} else{
//						description = menu+method.getAnnotation(LogInfo.class).memo();
						Object[] annotations = method.getAnnotations();
				        String annotationString = annotations[annotations.length-1].toString();
				        int beginIndex = annotationString.indexOf("(memo=\"")+"(memo=\"".length();
				        int endIndex = annotationString.indexOf("\")", beginIndex);
				        description = menu+annotationString.substring(beginIndex, endIndex);
					}
//					break;
				}
//			}
//		}
		return description;
	} 
   
}