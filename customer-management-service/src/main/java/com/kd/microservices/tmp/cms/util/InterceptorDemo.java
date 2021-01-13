//package com.kd.microservices.tmp.cms.util;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class InterceptorDemo extends HandlerInterceptorAdapter {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
//                             Object handler) throws Exception {
//        System.out.println("\n-------- InterceptorDemo.preHandle --- ");
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response,
//                           Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("-------- InterceptorDemo.postHandle --- ");
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
//                                Object handler, Exception ex) throws Exception {
//        System.out.println("-------- InterceptorDemo.afterCompletion --- ");
//    }
//}
