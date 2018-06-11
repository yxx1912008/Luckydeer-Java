package cn.luckydeer.common.model;

import java.io.Serializable;
import java.util.Collection;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;

import cn.luckydeer.common.enums.ViewShowEnums;

/**
 * ͨ�õķ���Json��ʽ
 * 
 * @author yuanxx
 * @version $Id: ResponseObj.java, v 0.1 2018��6��11�� ����4:09:44 yuanxx Exp $
 */
public class ResponseObj implements Serializable {

    /**  serialVersionUID */
    private static final long serialVersionUID = -3424492323959030110L;

    /**  ״̬�� :0->false 1->true */
    private int               status;
    /*ǰ̨��ʾ����ʾ��Ϣ*/
    private String            showMessage;

    /** �����쳣��� */
    public ResponseObj(int status, String showMessage) {
        this.status = status;
        this.showMessage = showMessage;
    }

    /** �������  ����Ҫ��������*/
    public ResponseObj() {
        this.status = ViewShowEnums.INFO_SUCCESS.getCode();
        this.showMessage = ViewShowEnums.INFO_SUCCESS.getDetail();
    }

    /** ������� ��Ҫ�������� */
    public ResponseObj(Object data) {
        this.data = data;
    }

    /** ������� ��Ҫ���� ״̬�롢��Ϣ���Լ����� */

    public ResponseObj(int status, String showMessage, Object data) {
        this.status = status;
        this.showMessage = showMessage;
        this.data = data;
    }

    /**
     * 
     * ע�⣺����Json�ַ���
     * @param request
     * @param response
     * @return
     * @author yuanxx @date 2018��6��11��
     */
    public String toJson() {
        //TODO ��ʱ��ȥ���ǿ�������
        String resultJson = null;
        /** �ж�data����Ϊ�յ���� */
        if (null == this.data || (data instanceof String && StringUtils.isBlank(data.toString()))
            || (data instanceof Collection && CollectionUtils.isEmpty((Collection<?>) data))) {
            resultJson = getBlankDataJson();
            return resultJson;
        }
        return JSON.toJSONString(this);
    }

    /**
     * 
     * ע�⣺���ܣ�data����Ϊ��ʱ���app��json���
     * @return
     * @author yuanxx @date 2018��6��11��
     */
    private String getBlankDataJson() {
        StringBuilder builder = new StringBuilder("{\"status\":");
        builder.append(this.getStatus());
        builder.append(",\"showMessage\":\"");
        builder.append(this.getShowMessage());
        builder.append("\",\"data\":{}}");
        return builder.toString();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getShowMessage() {
        return showMessage;
    }

    public void setShowMessage(String showMessage) {
        this.showMessage = showMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /*���������˵ĵ�json�����ַ���*/
    private Object data;

}
