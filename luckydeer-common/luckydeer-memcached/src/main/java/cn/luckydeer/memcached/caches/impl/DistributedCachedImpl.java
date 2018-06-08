package cn.luckydeer.memcached.caches.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.spy.memcached.MemcachedClient;

import org.apache.log4j.Logger;

import com.alibaba.dubbo.cache.Cache;

import cn.luckydeer.memcached.caches.DistributedCached;
import cn.luckydeer.memcached.caches.parent.AbstractTairCached;
import cn.luckydeer.memcached.enums.CachedType;

/**
 * 分布式缓存 
 * 32位系统一个端口最大内存支持 2G
 * key的字节数小于250字节
 * key不能有空格和控制字符如回车等
 * 过期时间最大是30天且不能小于零
 * 最大只能存储1mb的数据单元
 * 超过1mb建议拆分或者压缩
 * 
 * @author yuanxx
 * @version $Id: DistributedCachedImpl.java, v 0.1 2018年6月8日 下午4:09:56 yuanxx Exp $
 */
public class DistributedCachedImpl extends AbstractTairCached implements DistributedCached {

    /** 系统日志 */
    private Logger                       logger    = Logger.getLogger("SOA-JAR-LOG");

    /** 互斥常量 （业务数据与锁数据分离）  */
    private static final String          mutex     = "_MUTEX";

    /** 缓存器链  */
    private Map<String, MemcachedClient> cachedMap = new ConcurrentHashMap<String, MemcachedClient>();

    /**
     * 默认将数据缓存一天
     * @see cn.luckydeer.memcached.caches.DistributedCached#put(com.alibaba.dubbo.cache.Cache, java.lang.String, java.lang.Object)
     */
    @Override
    public boolean put(Cache cachedType, String key, Object value) {
        //指定超时时间默认为 24小时
        return put(cachedType, key, 24 * 60 * 60, value);
    }

    /**
     * 指定超时时间的缓存
     * @see cn.luckydeer.memcached.caches.DistributedCached#put(cn.luckydeer.memcached.enums.CachedType, java.lang.String, int, java.lang.Object)
     */
    @Override
    public boolean put(CachedType cachedType, String key, int exp, Object value) {
        return false;
    }

    @Override
    public Object get(CachedType cachedType, String key) {
        return null;
    }

    @Override
    public boolean remove(CachedType cachedType, String key) {
        return false;
    }

    @Override
    public boolean nonblock(CachedType cachedType, String keyMutex) {
        return false;
    }

    @Override
    public boolean block(CachedType cachedType, String keyMutex) {
        return false;
    }

    @Override
    public boolean unlock(CachedType cachedType, String keyMutex) {
        return false;
    }

    @Override
    public boolean cleanAll() {
        return false;
    }

}
