package com.dicadut.soms.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @author Radium
 * @version 1.0
 * @date 2021-04-13 20:42:10
 */
@Aspect
@Component
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE + 1)
public class LogAop {

    /***
     * 拦截所有controller中的方法的切面
     */
    @Pointcut("execution(public * com.dicadut.soms.controller..*(..))")
    public void pointCutAt() {
    }

    /***
     * 打印所有请求
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("pointCutAt()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        final String ip = request.getRemoteAddr();
        final String method = request.getMethod();
        final String uri = request.getRequestURI();
        final String contentType = request.getContentType();
        final String queryString = request.getQueryString();
        log.info("{} {} {}, Content-Type: {}, params: {}", ip, method, uri, contentType, queryString);
        Object result = pjp.proceed();

        return result;
    }


}
