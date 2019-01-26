package com.with.bai.admin.interceptor;

import com.with.bai.domain.Admin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PermissionInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        //  /login
        if(modelAndView!=null && modelAndView.getViewName()!=null && modelAndView.getViewName().endsWith("login")){
            //有没有登录
            Admin admin = (Admin) request.getSession().getAttribute("admin");
            if(admin!=null){
                response.sendRedirect(request.getContextPath()+"/info/index");
            }
        }

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
