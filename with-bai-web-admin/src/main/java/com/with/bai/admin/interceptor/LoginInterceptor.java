package com.with.bai.admin.interceptor;

import com.with.bai.domain.Admin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        /*ManagerService managerService = new ManagerServiceImpl();*/
        Admin manager = (Admin) request.getSession().getAttribute("admin");
        if (manager == null) {
          /*  String managerInfo = CookieUtils.getCookieValue(request, response, "managerInfo");
            if (managerInfo != null) {
                String[] arr = managerInfo.split(":");
                Manager manager1 = managerService.getManager(arr[0], arr[1]);
                if (manager1 != null) {
                    request.getSession().setAttribute(ConstantUitls.SESSION_MANAGER, manager1);
                    response.sendRedirect(request.getContextPath() + "/index");
                    return true;
                } else {
                    response.sendRedirect(request.getContextPath()+"/login");
                    return false;
                }*/
            response.sendRedirect(request.getContextPath()+"/login");
            return false;

           /* } else {
                response.sendRedirect(request.getContextPath() + "/login");
                return false;
                }*/
        }else{
            return true;
        }
    }



    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //  /login  回到index
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
