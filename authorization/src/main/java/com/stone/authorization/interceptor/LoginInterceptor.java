package com.stone.authorization.interceptor;

//import com.alibaba.fastjson.JSONObject;
//import igalaxy.model.User;
//import igalaxy.util.JwtUtil;
//import io.jsonwebtoken.Claims;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
//    @Autowired
//    private JwtUtil jwt;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截了");
//        String token = request.getParameter("token");
//        if (token != null) {
//            Claims claims = jwt.parseJWT(token);
//            String json = claims.getSubject();
//            User user = JSONObject.parseObject(json, User.class);
//            String subject = JwtUtil.generalSubject(user);
//            String refreshToken = jwt.createJWT(Constant.JWT_ID, subject, Constant.JWT_TTL);
//            if (!token.equals(refreshToken)) {
////            request.getRequestDispatcher("login.html").forward(request, response);
//                response.sendRedirect(request.getContextPath() + "/login.html");
//                return false;
//            }
//        }else{
//            response.sendRedirect(request.getContextPath() + "/login.html");
//            return false;
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截了");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception ex) throws Exception {
        System.out.println("拦截了");
    }

}
