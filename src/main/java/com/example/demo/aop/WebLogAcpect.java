package com.example.demo.aop;


import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by Administrator on 2021/4/4.
 */
@Aspect
@Component
public class WebLogAcpect {
    private Logger logger= LoggerFactory.getLogger(WebLogAcpect.class);

    @Pointcut("execution(public * com.example.demo.controller..*(..))")
    public void webLog(){

    }
    @Before("webLog()")
    public void before(JoinPoint joinPoint) throws Exception {
        Object[] object=joinPoint.getArgs();
        RequestAttributes attributes2 =  RequestContextHolder.getRequestAttributes();
        HttpServletRequest request2 = (HttpServletRequest) attributes2.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        HttpSession session=request2.getSession();
        logger.info("SessionId:"+session.getId());
        Enumeration<String> e= request2.getParameterNames();
        Map paramters=new HashMap<>();
        while (e.hasMoreElements()){
            String key=e.nextElement();
            paramters.put(key,request2.getParameter(key));
        }

        String str= JSON.toJSONString(paramters);
        if(object.length>0){
            logger.info("请求参数："+str);
            for (int i = 0; i <object.length ; i++) {
              logger.info(object[i].toString());
            }
        }


        // 记录下请求内容
        logger.info("URL : " + request2.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request2.getMethod());
        logger.info("IP : " + request2.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }


   @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void afterReturning(Object ret){
        logger.info("RESPONSE"+ret);
   }

    @AfterThrowing(value = "webLog()",throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint,Throwable exception){
        //目标方法名：
        logger.info(joinPoint.getSignature().getName());
        if(exception instanceof NullPointerException){
            logger.info("发生了空指针异常1!!!!!");
        }

    }

    @After(value = "webLog()")
    public void after(JoinPoint joinPoint){
        joinPoint.getArgs();
        logger.info("后置最终通知执行了!!!!");
    }

}
