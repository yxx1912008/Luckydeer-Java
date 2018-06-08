package cn.luckydeer.memcached.caches.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.OperationFuture;

import org.apache.log4j.Logger;

import cn.luckydeer.memcached.caches.DistributedCached;
import cn.luckydeer.memcached.caches.parent.AbstractTairCached;
import cn.luckydeer.memcached.constants.CachedConstants;
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
     * 存储缓存数据  默认缓存 默认时间
     * @see cn.luckydeer.memcached.caches.DistributedCached#put(com.alibaba.dubbo.cache.Cache, java.lang.String, java.lang.Object)
     */
    @Override
    public boolean put(CachedType cachedType, String key, Object value) {
        //指定超时时间默认为 24小时
        return put(cachedType, key, CachedConstants.MAX_CACHE_TIME, value);
    }

    /**
     * 指定超时时间的缓存
     * @see cn.luckydeer.memcached.caches.DistributedCached#put(cn.luckydeer.memcached.enums.CachedType, java.lang.String, int, java.lang.Object)
     */
    @Override
    public boolean put(CachedType cachedType, String key, int exp, Object value) {
        //校验 Key、Value、超时时间，只有当三者都为 True 才能储存
        if (validateKey(key) && validateValue(value) && validateExp(exp)) {
            try {
                /** ConcurrentHashMap 里面存储 MemcachedClient对象 通过缓存类型进行区分  */
                cachedMap.get(cachedType.getCode()).set(key, exp, value);
            } catch (Exception e) {
                logger.error("内部缓存系统异常，保存失败:key=" + key, e);
            }
        }
        return false;
    }

    /**
     * 读取存储在Memcached缓存里的数据
     * @see cn.luckydeer.memcached.caches.DistributedCached#get(cn.luckydeer.memcached.enums.CachedType, java.lang.String)
     */
    @Override
    public Object get(CachedType cachedType, String key) {
        //读取之前进行key校验
        if (validateKey(key)) {
            try {
                return cachedMap.get(cachedType.getCode()).get(key);
            } catch (Exception e) {
                logger.error("Memcached缓存内部存在问题", e);
            }
        }
        return null;
    }

    /**
     * 从Memcached缓存中删除一条数据
     * @see cn.luckydeer.memcached.caches.DistributedCached#remove(cn.luckydeer.memcached.enums.CachedType, java.lang.String)
     */
    @Override
    public boolean remove(CachedType cachedType, String key) {
        if (validateKey(key)) {
            try {
                cachedMap.get(cachedType.getCode()).delete(key);
                return true;
            } catch (Exception e) {
                logger.error("从Memcached缓存中删除数据失败:key=" + key, e);
                return false;
            }
        }
        return false;
    }

    /**
     * 非阻塞式的分布锁
     * @see cn.luckydeer.memcached.caches.DistributedCached#nonblock(cn.luckydeer.memcached.enums.CachedType, java.lang.String)
     */
    @Override
    public boolean nonblock(CachedType cachedType, String key) {
        final String lockKey = key + mutex;
        if (validateKey(lockKey)) {
            try {
                //避免宕机死锁，给予  锁失效时间
                OperationFuture<Boolean> flag = cachedMap.get(cachedType.getCode()).add(lockKey,
                    CachedConstants.LOCK_LOSE_TIME, Boolean.TRUE);
                return flag.get().booleanValue();
            } catch (InterruptedException e) {
                logger.error("缓存系统内部异常，锁失败:key=" + key, e);
            } catch (ExecutionException e) {
                logger.error("缓存系统内部异常，锁失败:key=" + key, e);
            }
        }
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

    public void setCachedMap(Map<String, MemcachedClient> cachedMap) {
        this.cachedMap = cachedMap;
    }

}
