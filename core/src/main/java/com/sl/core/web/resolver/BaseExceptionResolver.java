package com.sl.core.web.resolver;

import com.sl.core.mvc.exception.impl.DaoException;
import com.sl.core.mvc.exception.impl.ServiceException;
import com.sl.core.mvc.exception.impl.TipException;
import com.sl.core.util.WebAppUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class BaseExceptionResolver implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception exception) {

        if (WebAppUtil.isJsonRequest(httpServletRequest)) {
            WebAppUtil.writeJson(httpServletResponse, exception.getMessage());
            return null;
        } else {
            if (exception instanceof TipException) {
                ModelAndView view = new ModelAndView("/common/tip.view");
                view.addObject("exception", exception);
                return view;
            } else if (exception instanceof ServiceException || exception instanceof DaoException) {

            } else {
                ModelAndView view = new ModelAndView("/common/500.view");
                view.addObject("exception", exception);
                return view;
            }

            return null;
        }
    }
}
