package com.thoth.my.shop.web.admin.web.interceptor;

import com.thoth.my.shop.common.constant.ConstantUtil;
import com.thoth.my.shop.domain.TbUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: my-shop
 * @description: 登录拦截
 * @author: yyj
 * @create: 2019-12-04 19:13
 **/
public class permissionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null && modelAndView.getViewName() != null &&modelAndView.getViewName().endsWith("login")) {
            TbUser user = (TbUser) request.getSession().getAttribute(ConstantUtil.SESSION_USER);
            if (user!= null) {
                response.sendRedirect("/main");
                return;
            }
        }
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
