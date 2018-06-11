package cn.luckydeer.common.model;

import java.io.Serializable;

/**
 * 通用的返回Json格式
 * 
 * @author yuanxx
 * @version $Id: ResponseObj.java, v 0.1 2018年6月11日 下午4:09:44 yuanxx Exp $
 */
public class ResponseObj implements Serializable {

    /**  serialVersionUID */
    private static final long serialVersionUID = -3424492323959030110L;

    /*状态码*/
    private int               status;
    /*前台显示的提示信息*/
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

    /*返回其他端的的json数据字符串*/
    private Object data;

}
