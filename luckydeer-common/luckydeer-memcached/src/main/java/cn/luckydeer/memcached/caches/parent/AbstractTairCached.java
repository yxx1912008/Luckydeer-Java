package cn.luckydeer.memcached.caches.parent;

import net.spy.memcached.KeyUtil;
import net.spy.memcached.MemcachedClientIF;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import cn.luckydeer.memcached.caches.DistributedCached;
import cn.luckydeer.memcached.constants.CachedConstants;

/**
 * 
 * Memcached 工厂校验器
 * @author yuanxx
 * @version $Id: AbstractTairCached.java, v 0.1 2018年6月8日 下午3:32:04 yuanxx Exp $
 */
public abstract class AbstractTairCached implements DistributedCached {

    private Logger logger = Logger.getLogger("SOA-JAR-LOG");

    /**
     * 
     * 注解：校验传过来的参数是否为空
     * @param value
     * @return
     * @author yuanxx @date 2018年6月8日
     */
    protected boolean validateValue(Object value) {
        if (null == value) {
            logger.error("value 不能为空");
            return false;
        }
        return true;
    }

    /**
     * 
     * 注解：校验 超时时间 以秒为单位
     * @param exp
     * @return
     * @author yuanxx @date 2018年6月8日
     */
    protected boolean validateExp(int exp) {

        if (exp < 0) {
            logger.error("超时时间不合法：exp=" + exp);
            return false;
        }
        //为了缓解Memcached缓存压力,设置最大超时时间不能超过三十天
        if (exp > CachedConstants.MAX_CACHE_TIME) {
            logger.error("超时时间不能大于三十天：exp=" + exp);
            return false;
        }
        return true;
    }

    /**
     * 
     * 注解：校验 key的格式
     * @param key
     * @return
     * @author yuanxx @date 2018年6月8日
     */
    protected boolean validateKey(String key) {

        if (StringUtils.isBlank(key)) {
            logger.error("Memcached Key不能为空");
            return false;
        }
        //读取key的字节数组
        byte[] keyBytes = KeyUtil.getKeyBytes(key);
        //支持的最大字节长度是250
        if (keyBytes.length >= MemcachedClientIF.MAX_KEY_LENGTH) {
            logger.error("Memcached 支持的最大字节长度是 250,key=" + key);
            return false;
        }
        //Key最少要一个字节
        if (keyBytes.length == 0) {
            logger.error("Memcached 支持的Key最少需要一个字节");
            return false;
        }
        // Validate the key
        //此处代码原型来自于  net.spy.memcached.util.StringUtils.validateKey(key, binary);
        for (byte b : keyBytes) {
            if (b == ' ' || b == '\n' || b == '\r') {
                logger.error("key不能包含空格、换行符:  ``" + key);
                return false;
            }
        }
        return true;
    }

}
