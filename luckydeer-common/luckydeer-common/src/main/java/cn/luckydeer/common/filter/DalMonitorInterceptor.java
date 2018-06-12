package cn.luckydeer.common.filter;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

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
        System.out.println("������������");
        /** ��ȡ���� */
        String packageName = invocation.getMethod().getDeclaringClass().getPackage().getName();
        /** ��ȡ����  */
        String className = invocation.getMethod().getDeclaringClass().getSimpleName();
        String method = new StringBuilder(packageName).append(".").append(className).append(".")
            .append(invocation.getMethod().getName()).toString();
        dalMonitorLogger.info("���ؿ�ʼ:" + method);
        Object result = invocation.proceed();
        dalMonitorLogger.info("���ؽ���:" + result.toString());
        return result;
    }

}
