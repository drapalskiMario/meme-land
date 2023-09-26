package com.ebac.memeland.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class RequestLoggingInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(RequestLoggingInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        var startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        logger.info("Received request in method: " + request.getMethod() + ", path: " + request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        var startTime = (Long) request.getAttribute("startTime");
        var endTime = System.currentTimeMillis();
        var totalTime = endTime - startTime;
        logger.info("Total processing time: " + totalTime + " ms");
    }
}
