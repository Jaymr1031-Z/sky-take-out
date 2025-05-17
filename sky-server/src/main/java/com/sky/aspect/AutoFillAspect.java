package com.sky.aspect;

import com.sky.annotation.AutoFill;
import com.sky.constant.AutoFillConstant;
import com.sky.context.BaseContext;
import com.sky.enumeration.OperationType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * @Author: Jaymr
 * @Date: 2025/5/17 10:54
 * @Version: v1.0.0
 * @Description: 自定义切面 实现公共字段自动填充处理逻辑
 **/
@Aspect
@Component
@Slf4j
public class AutoFillAspect {
    /**
     * 切入点
     */
    @Pointcut("execution(* com.sky.mapper.*.*(..)) && @annotation(com.sky.annotation.AutoFill)")
    public void autoFillPointCut(){

    }

    /**
     * 前置通知，为公共字段赋值
     */
    @Before("autoFillPointCut()")
    public void autoFill(JoinPoint joinpoint) throws Exception {
        log.info("开始进行公共字段自动填充......");

        //获取当前被拦截的方法上数据库操作类型
        MethodSignature signature = (MethodSignature) joinpoint.getSignature();//方法签名对象
        AutoFill autoFill = signature.getMethod().getAnnotation(AutoFill.class);//获得方法上的注解对象
        OperationType operationType = autoFill.value();//获得数据库操作类型
        //获取到当前被拦截的方法的参数--实体对象
        Object[] args = joinpoint.getArgs();//获取所有参数
        if(args == null || args.length == 0){
            return;
        }

        Object entity = args[0];//接收实体对象(第一个)
        //准备赋值的数据（时间 用户id）
        LocalDateTime now = LocalDateTime.now();
        Long currentId = BaseContext.getCurrentId();
        // 根据不同的操作类型对属性赋值（反射）
        if (operationType == OperationType.INSERT){
            //四个公共字段都要赋值
            Method setCreateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_CREATE_TIME, LocalDateTime.class);
            Method setCreateUser = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_CREATE_USER, Long.class);
            Method setUpdateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class);
            Method setUpdateUser = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_USER, Long.class);

            //通过反射为对象属性赋值
            setCreateTime.invoke(entity,now);
            setCreateUser.invoke(entity,currentId);
            setUpdateTime.invoke(entity,now);
            setUpdateUser.invoke(entity,currentId);
        }else if (operationType == OperationType.UPDATE){
            //两个公共字段赋值
            Method setUpdateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class);
            Method setUpdateUser = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_USER, Long.class);

            //通过反射为对象属性赋值
            setUpdateTime.invoke(entity,now);
            setUpdateUser.invoke(entity,currentId);
        }

    }

}
