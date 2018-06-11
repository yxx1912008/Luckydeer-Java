package cn.luckydeer.common.model;

import java.io.Serializable;
import java.util.Collection;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;

import cn.luckydeer.common.enums.ViewShowEnums;

/**
 * 通用的返回Json格式
 * 
 * @author yuanxx
 * @version $Id: ResponseObj.java, v 0.1 2018年6月11日 下午4:09:44 yuanxx Exp $
 */
public class ResponseObj implements Serializable {

    /**  serialVersionUID */
    private static final long serialVersionUID = -3424492323959030110L;

    /**  状态码 :0->false 1->true */
    private int               status;
    /*前台显示的提示信息*/
    private String            showMessage;

    /** 返回异常情况 */
    public ResponseObj(int status, String showMessage) {
        this.status = status;
        this.showMessage = showMessage;
    }

    /** 正常情况  不需要返回数据*/
    public ResponseObj() {
        this.status = ViewShowEnums.INFO_SUCCESS.getCode();
        this.showMessage = ViewShowEnums.INFO_SUCCESS.getDetail();
    }

    /** 正常情况 需要返回数据 */
    public ResponseObj(Object data) {
        this.data = data;
    }

    /** 正常情况 需要返回 状态码、信息、以及数据 */

    public ResponseObj(int status, String showMessage, Object data) {
        this.status = status;
        this.showMessage = showMessage;
        this.data = data;
    }

    /**
     * 
     * 注解：返回Json字符串
     * @param request
     * @param response
     * @return
     * @author yuanxx @date 2018年6月11日
     */
    public String toJson() {
        //TODO 暂时不去考虑跨域问题
        String resultJson = null;
        /** 判断data参数为空的情况 */
        if (null == this.data || (data instanceof String && StringUtils.isBlank(data.toString()))
            || (data instanceof Collection && CollectionUtils.isEmpty((Collection<?>) data))) {
            resultJson = getBlankDataJson();
            return resultJson;
        }
        return JSON.toJSONString(this);
    }

    /**
     * 
     * 注解：功能：data数据为空时配合app的json结果
     * @return
     * @author yuanxx @date 2018年6月11日
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

    /*返回其他端的的json数据字符串*/
    private Object data;

}
