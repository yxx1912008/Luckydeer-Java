package cn.luckydeer.common.enums;

/**
 * 
 * ��ҵ������ö��
 * 
 * @author yuanxx
 * @version $Id: ViewShowEnums.java, v 0.1 2018��6��11�� ����4:17:55 yuanxx Exp $
 */
public enum ViewShowEnums {

    NOT_LOGIN(-1, "���µ�¼"), ERROR_FAILED(0, "ϵͳ�쳣"), INFO_SUCCESS(1, "�����ɹ�");

    private int    code;

    private String detail;

    /**
     * 
     * ע�⣺��������Ƿ��Ǵ���
     * @return
     * @author yuanxx @date 2018��6��11��
     */
    public boolean isError() {

        switch (this) {
            case INFO_SUCCESS:
                return false;
            default:
                return true;
        }
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