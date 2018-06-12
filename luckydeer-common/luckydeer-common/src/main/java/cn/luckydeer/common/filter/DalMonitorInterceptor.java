package cn.luckydeer.common.filter;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;

/**
 * 
 * ������ݿ����
 * �����������ڼ�����ݿ����
 * ������ݿ����ʱ�����������Խ������ݿ��Ż�
 * @author yuanxx
 * @version $Id: DalMonitorInterceptor.java, v 0.1 2018��6��12�� ����11:45:49 yuanxx Exp $
 */
public class DalMonitorInterceptor implements MethodInterceptor {

    /** ��С����ʱ�� */
    private final static int    minTime          = 500;

    private final static Logger dalMonitorLogger = Logger.getLogger("DAL-MONITOR-LOGGER");

    /**
     * ȱʡ�Ĺ��췽��.
     */
    public DalMonitorInterceptor() {
        super();
    }

    /**
     * ��¼����������
     * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        /** ��ȡ���� */
        String packageName = invocation.getMethod().getDeclaringClass().getPackage().getName();
        /** ��ȡ����  */
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
            // ���쳣ʱ����ӡ300�������µļ����־
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
