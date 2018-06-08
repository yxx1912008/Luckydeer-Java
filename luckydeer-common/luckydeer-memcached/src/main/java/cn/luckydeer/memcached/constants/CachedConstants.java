package cn.luckydeer.memcached.constants;

/**
 * 缓存系统常用 常量
 * 
 * @author yuanxx
 * @version $Id: CachedConstants.java, v 0.1 2018年6月8日 下午3:44:25 yuanxx Exp $
 */
public interface CachedConstants {

    /** 最大缓存时间   当前设置为30天 */
    int MAX_CACHE_TIME     = 60 * 60 * 24 * 30;

    /** 默认超时时间  当前设置为24小时 */
    int CACHE_TIME_DEFAULT = 24 * 60 * 60;

    /** 默认锁失效时间 */
    int LOCK_LOSE_TIME     = 300;

}
