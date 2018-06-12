package cn.luckydeer.common.filter;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;

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
        /** 获取包名 */
        String packageName = invocation.getMethod().getDeclaringClass().getPackage().getName();
        /** 获取类名  */
        String className = invocation.getMethod().getDeclaringClass().getSimpleName();
        String method = new StringBuilder(packageName).append(".").append(className).append(".")
            .append(invocation.getMethod().getName()).toString();

        Object[] args = invocation.getArguments();

        String params = null;

        if (null != args && args.length > 0) {
            params = JSON.toJSONString(args);
        }

        long startTime = System.currentTimeMillis();

        String severity = "[MIN],";

        boolean hasError = false;
        try {
            return invocation.proceed();
        } catch (Throwable e) {
            dalMonitorLogger.error(method, e);
            hasError = true;
            throw e;
        } finally {

            long elapseTime = System.currentTimeMillis() - startTime;
            if (elapseTime < minTime) {
                severity = "[MIN],";
            } else if (elapseTime >= minTime && elapseTime < 1000) {
                severity = "[MID],";
            } else if (elapseTime >= 1000 && elapseTime < 10000) {
                severity = "[MAX],";
            } else {
                severity = "[XMA],";
            }

            StringBuilder builder = new StringBuilder("(");
            builder.append(method);

            if (hasError) {
                builder.append(",N,").append(severity).append(elapseTime).append("ms) ;args=")
                    .append(params);
                dalMonitorLogger.info(builder.toString());
            }
            // 无异常时不打印300毫秒以下的监控日志
            if (!hasError && elapseTime >= minTime) {
                builder.append(",Y,").append(severity).append(elapseTime).append("ms)");
                if (elapseTime >= 1000) {
                    builder.append(" ;args=").append(params);
                }
                dalMonitorLogger.info(builder.toString());
            }

        }
    }

}
