package com.sl.core.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sl.core.mvc.exception.ServletErrorParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebAppUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static boolean isJsonRequest(HttpServletRequest request){
        String requestUri =  (String)request.getAttribute(ServletErrorParam.REQUEST_URI);
        if(requestUri!=null&&requestUri.endsWith(".json")){
            return true;
        }else{
            return (request.getHeader("Accept").contains("application/json") || (request.getHeader("X-Requested-With") != null
                    && request.getHeader("X-Requested-With").contains("XMLHttpRequest")));
        }
    }


    public static void writeJson(HttpServletResponse response, Object result){
        response.setContentType("application/json;charset=utf-8");
        try {
            response.getWriter().write(objectMapper.writeValueAsString(result));
        } catch (IOException e) {
            // ignore
        }
    }


}
