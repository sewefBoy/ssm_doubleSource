package com.soecode.lyf.aop;

/**
 * Created by sewef on 2018/6/14.
 */
import java.lang.reflect.Proxy;


import com.soecode.lyf.datasource.MultipleDataSource;
import org.apache.commons.lang3.ClassUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


/**
 * 数据源切换AOP
 *
 */
@Component
@Aspect
public class MultipleDataSourceInterceptor {
    /**
     * 拦截器对所有的业务实现类请求之前进行数据源切换
     * 特别注意,由于用到了多数据源,Mapper的调用最好只在*ServiceImpl,不然调用到非默认数据源的表时,会报表不存在的异常
     * @param joinPoint execution (* com.cms.art.service.*.*(..))"
     * @throws Throwable
     */
    @Before( "execution (* com.soecode.lyf.service.impl.*.*(..))" )
    public void setDataSoruce(JoinPoint joinPoint) throws Throwable {
        System.out.println("enter AOP Before+++++++++++++++++++++++==================================================");
        Class<?> clazz = joinPoint.getTarget().getClass();
        String className = clazz.getName();
        if (ClassUtils.isAssignable(clazz, Proxy.class)) {
            className = joinPoint.getSignature().getDeclaringTypeName();
        }
        //对类名含有business的设置为app数据源,否则默认为后台的数据源
        if(className.contains("Oracle")){
            MultipleDataSource.setDataSourceKey(MultipleDataSource.DATA_SOURCE_ORACLE);
        }else{
            MultipleDataSource.setDataSourceKey(MultipleDataSource.DATA_SOURCE_MYSQL);
        }
    }
    /**
     * 当操作完成时,释放当前的数据源
     * 如果不释放,频繁点击时会发生数据源冲突,本是另一个数据源的表,结果跑到另外一个数据源去,报表不存在
     * @param joinPoint
     * @throws Throwable
     */
    @After( "execution (* com.soecode.lyf.service.impl.*.*(..))" )
    public void removeDataSoruce(JoinPoint joinPoint) throws Throwable {
        System.out.println("enter  After Before++++++++++++++++++++==================================================");
        MultipleDataSource.removeDataSourceKey();
    }
}
