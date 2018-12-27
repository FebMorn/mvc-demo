package com.sl.core.mvc.exception;

public class ServletErrorParam {

    //错误的状态码 : Integer
    public static final String STATUS_CODE = "javax.servlet.error.status_code";

     //异常类 : Class
     public static final String EXCEPTION_TYPE = "javax.servlet.error.exception_type";

     //抛出异常的信息 : String
     public static final String MESSAGE = "javax.servlet.error.message";

     //异常发生时所对应的URL : String
     public static final String REQUEST_URI = "javax.servlet.error.request_uri";

     //实际的异常 : Throwable
     public static final String EXCEPTION = "javax.servlet.error.exception";

     //捕获该异常的 Servlet : String
     public static final String SERVLET_NAME = "javax.servlet.error.servlet_name";

}
