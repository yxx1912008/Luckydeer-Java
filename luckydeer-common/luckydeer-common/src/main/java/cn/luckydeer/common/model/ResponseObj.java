package cn.luckydeer.common.model;

import java.io.Serializable;

/**
 * ͨ�õķ���Json��ʽ
 * 
 * @author yuanxx
 * @version $Id: ResponseObj.java, v 0.1 2018��6��11�� ����4:09:44 yuanxx Exp $
 */
public class ResponseObj implements Serializable {

    /**  serialVersionUID */
    private static final long serialVersionUID = -3424492323959030110L;

    /*״̬��*/
    private int               status;
    /*ǰ̨��ʾ����ʾ��Ϣ*/
    private String            showMessage;

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
