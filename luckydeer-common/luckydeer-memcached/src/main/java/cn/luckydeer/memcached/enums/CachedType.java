package cn.luckydeer.memcached.enums;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * 缓存类型
 * @author yuanxx
 * @version $Id: CachedType.java, v 0.1 2018年6月8日 下午3:09:14 yuanxx Exp $
 */
public enum CachedType {

    USER_SESSION("USER_SESSION", "用户登录缓存"), STATISTICS("STATISTICS", "业务数据缓存");

    //枚举的代码
    private String code;
    //枚举的详情
    private String detail;

    /**
     * 
     * 注解：根据编码获得枚举对象
     * 如果编码有误，返回空
     * @param code
     * @return
     * @author yuanxx @date 2018年6月8日
     */
    public static CachedType getEnumByCode(String code) {

        if (StringUtils.isNotBlank(code)) {
            for (CachedType type : CachedType.values()) {
                if (StringUtils.equals(code, type.getCode())) {
                    return type;
                }
            }
        }
        return null;
    }

    /**
     * 
     * 注解：根据枚举的Code 获取枚举的对象
     * 如果编码有误，返回空
     * @param code
     * @return
     * @author yuanxx @date 2018年6月8日
     */
    public static String getDetailByCode(String code) {
        if (StringUtils.isNotBlank(code)) {
            for (CachedType cachedType : CachedType.values()) {

                if (StringUtils.equals(code, cachedType.getDetail())) {
                    return cachedType.getDetail();
                }
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    private CachedType(String code, String detail) {
        this.code = code;
        this.detail = detail;
    }

}
