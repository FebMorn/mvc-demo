package com.sl.core.context.authority.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * 自定义sessionId获取
 * 针对前后端分离情况的重写
 */
public class SessionManager extends DefaultWebSessionManager {

    private static final String AUTHORIZATION = "Authorization";

    private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";


    public SessionManager() {
        super();
    }

    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        //?
        String sessionId = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
        //如果请求头中有Authorization 则所对应值为 sessionId
        if (StringUtils.isNotBlank(sessionId)) {
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE,REFERENCED_SESSION_ID_SOURCE);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID,sessionId);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID,Boolean.TRUE);
            return sessionId;
        } else {
            //否则按默认规则从cookie中取sessionId
            return super.getSessionId(request,response);
        }
    }

    public static void setAttribute(String key,Object value){
        SecurityUtils.getSubject().getSession(false).setAttribute(key, value);
    }

    public static <T> T getAttribute(String key){
        return (T)SecurityUtils.getSubject().getSession(false).getAttribute(key);
    }

    public static <T> T getLoginUser(){
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        if(principals!=null&&!principals.isEmpty()){
            return (T)principals.iterator().next();
        }
        return null;
    }
}
























