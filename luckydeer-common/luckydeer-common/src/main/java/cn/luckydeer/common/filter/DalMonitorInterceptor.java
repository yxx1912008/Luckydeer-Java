package cn.luckydeer.common.filter;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

/**
 * 
 * 监控数据库操作
 * 此拦截器用于监控数据库操作
 * 如果数据库操作时间过长，则可以进行数据库优化
 * @author yuanxx
 * @version $Id: DalMonitorInterceptor.java, v 0.1 2018年6月12日 上午11:45:49 yuanxx Exp $
 */
public class DalMonitorInterceptor implements MethodInterceptor {

    /** 最小操作时间 */
    private final static int    minTime          = 500;

    private final static Logger dalMonitorLogger = Logger.getLogger("DAL-MONITOR-LOGGER");

    /**
     * 缺省的构造方法.
     */
    public DalMonitorInterceptor() {
        super();
    }

    /**
     * 记录服务调用情况
     * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("拦截器起作用");
        /** 获取包名 */
        String packageName = invocation.getMethod().getDeclaringClass().getPackage().getName();
        /** 获取类名  */
        String className = invocation.getMethod().getDeclaringClass().getSimpleName();
        String method = new StringBuilder(packageName).append(".").append(className).append(".")
            .append(invocation.getMethod().getName()).toString();
        dalMonitorLogger.info("拦截开始:" + method);
        Object result = invocation.proceed();
        dalMonitorLogger.info("拦截结束:" + result.toString());
        return result;
    }

}
