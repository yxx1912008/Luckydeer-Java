package cn.luckydeer.note.model.enums;

public enum NoteEnums {

    SUCCEED(0, "成功"), DEFEATED(1, "失败");

    private int    code;

    private String detail;

    NoteEnums(int code, String detail) {
        this.code = code;
        this.detail = detail;
    }

    /**
     * 
     * 注解：根据编码获取枚举
     * @param status
     * @return
     * @author yuanxx @date 2018年6月5日
     */
    public static NoteEnums getEnumByCode(Integer code) {
        if (null == code) {
            return null;
        }
        for (NoteEnums noteEnums : NoteEnums.values()) {
            if (code.equals(noteEnums.getCode())) {
                return noteEnums;
            }
        }
        return null;
    }

    /**
     * 
     * 注解：判断是否成功
     * @return
     * @author yuanxx @date 2018年6月5日
     */
    public boolean isSucceed() {
        switch (this) {
            case SUCCEED:
                return true;
            default:
                return false;
        }
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
