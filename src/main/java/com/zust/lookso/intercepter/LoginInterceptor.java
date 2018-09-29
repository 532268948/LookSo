package com.zust.lookso.intercepter;

import com.zust.lookso.dao.CommonOperate;
import com.zust.lookso.dto.UserDto;
import com.zust.lookso.entity.User;
import com.zust.lookso.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/8/28
 * 时 间： 22:09
 * 项 目： LookSo
 * 描 述：
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    @Qualifier("userDao")
    private CommonOperate userOperate;

    private User user;
    private String userName="";
    private String password = "";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Cookie[] cookies = request.getCookies();
        if(null!=cookies){
            for(Cookie cookie : cookies){
                if("userName".equals(cookie.getName())){
                    userName = cookie.getValue();
                }else if("password".equals(cookie.getName())){
                    password = cookie.getValue();
                }
                //}
            }
            if(!"".equals(userName) && !"".equals(password)){
                user.setName(userName);
                user.setPassword(password);
                List list=this.userOperate.Query(user,0);
                if(list.size()==1){
                    return true;
                }else {
                    response.sendRedirect("/Zero/friends/UnKnowUser.json");
                    return false;
                }
            }
        }
        return false;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//         System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//         System.out.println("afterCompletion");
    }

}