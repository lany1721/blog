package cn.zpeace.blog.aspect;

import cn.zpeace.blog.util.MyBlogUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class logAspect {

    @Pointcut("execution(* cn.zpeace.blog.controller.*.*(..))")
    public void log(){
    }



    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attributes.getRequest();

        String ip = MyBlogUtil.getRemortIP(req);
        String url = req.getRequestURL().toString();


        String proxyMethod = joinPoint.getSignature().getDeclaringTypeName()  + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        log.info("访问者IP:{} ,请求的URL:{} ,调用的方法:{} ,方法参数:{}",ip,url,proxyMethod,args);

    }


}
