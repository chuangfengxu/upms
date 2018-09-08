package com.dev.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author XuChuangFeng
 */
@Aspect
@Order(1)
@Component
public class WebLogAspect {

    protected final Log logger = LogFactory.getLog(this.getClass());

    //ThreadLocal<Long> startTime = new ThreadLocal<>();
    @Pointcut("execution(public * com.dev.web.*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        //startTime.userToTree(SystemPo.currentTimeMillis());

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.debug("URL : " + request.getRequestURL().toString());
        logger.debug("HTTP_METHOD : " + request.getMethod());
        logger.debug("REMOTE_HOST : " + request.getRemoteHost());
        logger.debug("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.debug("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "resp", pointcut = "webLog()")
    public void doAfterReturning(JoinPoint joinPoint, Object resp) throws Throwable {
        // 处理完请求，返回内容
        logger.debug("Controller Response: " + resp);
        //logger.debug("SPEND TIME : " + (SystemPo.currentTimeMillis() - startTime.get()));
    }
}

