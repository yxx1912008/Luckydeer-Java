package cn.luckydeer.common.enums;

/**
 * 
 * 非业务类型枚举
 * 
 * @author yuanxx
 * @version $Id: ViewShowEnums.java, v 0.1 2018年6月11日 下午4:17:55 yuanxx Exp $
 */
public enum ViewShowEnums {

    NOT_LOGIN(-1, "重新登录"), ERROR_FAILED(0, "系统异常"), INFO_SUCCESS(1, "操作成功");

    private int    code;

    private String detail;

    /**
     * 
     * 注解：操作结果是否是错误
     * @return
     * @author yuanxx @date 2018年6月11日
     */
    public boolean isError() {
        switch (this) {
            case INFO_SUCCESS:
                return false;
            default:
                return true;
        }
    }

    /**
     * 
     * 注解：操作是否成功
     * @return
     * @author yuanxx @date 2018年6月11日
     */
    public boolean isSuccess() {
        switch (this) {
            case INFO_SUCCESS:
                return true;
            default:
                return false;
        }
    }

    /**
     * 
     * 注解：根据Code获取枚举
     * @param code
     * @return
     * @author yuanxx @date 2018年6月11日
     */
    public static ViewShowEnums getEnumsByCode(Integer code) {

        if (null != code) {
            for (ViewShowEnums activitie : ViewShowEnums.values()) {
                if (code.intValue() == activitie.getCode()) {
                    return activitie;
                }
            }
        }
        return null;
    }

    private ViewShowEnums(int code, String detail) {
        this.code = code;
        this.detail = detail;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
