package cn.luckydeer.movie.model.enums;

public enum TestEnums {

    SUCCEED(0, "成功"), DEFEATED(1, "失败");

    private int    code;

    private String detail;

    TestEnums(int code, String detail) {
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
