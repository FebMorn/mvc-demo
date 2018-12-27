//package com.sl.core.mvc.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.sl.core.mvc.exception.ServletErrorParam;
//import com.sl.core.mvc.exception.impl.TipException;
//import com.sl.core.mvc.exception.impl.ViewException;
//import com.sl.core.util.WebAppUtil;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.*;
//
///**
// * HandlerExceptionResolver
// * WebMvcConfigurerAdapter
// * spring 中还可以通过@ControllerAdvice以及@ExceptionHandler(ApplicationException.class)注解对指定的异常做全局处理
// *
// * 以上两种方式只能处理Controller层之内的异常
// * 以tomcat为例，容器在处理请求时，遇到异常情况，首先会去找错误页面，如果没有配置错误页面，会HttpStatus默认转发到/error路径，所以我们可以写一个controller类来处理/error 请求，而springboot中默认有一个处理/error 请求的controller类 AbstractErrorController
// */
//
//@Controller
//public class CustomErrorController extends AbstractErrorController {
//
//	private static final String ERROR_PATH = "/error";
//	Log log = LogFactory.getLog(ErrorController.class);
//
//	@Autowired
//	ObjectMapper objectMapper;
//
//	public CustomErrorController() {
//		super(new DefaultErrorAttributes());
//	}
//
//
//	@Override
//	public String getErrorPath() {
//		return ERROR_PATH;
//	}
//
//	@RequestMapping(value = ERROR_PATH)
//	public ModelAndView getErrorPath(HttpServletRequest request, HttpServletResponse response) {
//
//
//		Map<String,Object> errorAttr = Collections.unmodifiableMap(getErrorAttributes(request,false));
//
//		Throwable exception = (Throwable)request.getAttribute(ServletErrorParam.EXCEPTION);
//
//		List<FieldError> filedErrors = (List<FieldError>)errorAttr.get("errors");
//
//		int status = (Integer)errorAttr.get("status");
//		//错误信息
//		String message = (String)errorAttr.get("message");
//
//		String requestPath = (String)errorAttr.get("path");
//        //友好提示
//		String errorMessage = exception.getCause().getMessage();
//
//		//后台打印日志信息方方便查错
//		log.info(status+":"+message+filedErrors, exception.getCause());
//		log.info("requestPath"+":"+requestPath);
//
//		if(WebAppUtil.isJsonRequest(request)){
//			if(filedErrors==null){
//
//				if(status==404){
//					WebAppUtil.writeJson(response,"");
//				}else{
//					WebAppUtil.writeJson(response,"");
//				}
//
//			}else{
//				List<Map<String,String>> list = new ArrayList<Map<String,String>>();
//				for(FieldError e:filedErrors){
//					Map<String,String> errorMap = new HashMap<String,String>();
//					errorMap.put("field", e.getField());
//					errorMap.put("message", e.getDefaultMessage());
//					list.add(errorMap);
//				}
//
//				WebAppUtil.writeJson(response,list);
//			}
//			return null;
//		}else{
//
//			if (exception instanceof ViewException) {
//				ModelAndView view = new ModelAndView("/common/500.view");
//				view.addObject("exception", exception);
//				return view;
//			}else if (exception instanceof TipException) {
//				ModelAndView view = new ModelAndView("/common/tip.view");
//				view.addObject("exception", exception);
//				return view;
//			} else {
//				ModelAndView view = new ModelAndView("/error.html");
//				view.addAllObjects(errorAttr);
//				view.addObject("errorMessage", errorMessage);
//				view.addObject("filedErrors", filedErrors);
//				view.addObject("cause", errorMessage);
//				view.addObject("requestPath", requestPath);
//				view.addObject("exception", exception);
//				return view;
//			}
//		}
//	}
//}
