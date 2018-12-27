package com.sl.core.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 暂时不用统一的Map存储线程数据
 * 所有参数通过方法接口调用
 * 防止线程未及时释放造成内存泄漏（加入未定义的参数名，且没有及时覆盖）
 */
public class ThreadLocalUtil {

	private static final ThreadLocal<HttpServletRequest> threadLocalRequest = new ThreadLocal<>();

	private static final ThreadLocal<HttpServletResponse> threadLocalResponse = new ThreadLocal<>();

	public static void setHttpServletRequest(HttpServletRequest request) {
		threadLocalRequest.set(request);
	}

	public static HttpServletRequest getHttpServletRequest() {
		return threadLocalRequest.get();
	}

	public static void setHttpServletResponse(HttpServletResponse response) {
		threadLocalResponse.set(response);
	}

	public static HttpServletResponse getHttpServletResponse() {
		return threadLocalResponse.get();
	}

	public static void remove() {
		threadLocalRequest.remove();
		threadLocalResponse.remove();
	}


	public static HttpSession getSession(){
		return threadLocalRequest.get().getSession();
	}

	public static String getRequestIP(){
		return IpUtil.getIpAddr(threadLocalRequest.get());
	}
}
