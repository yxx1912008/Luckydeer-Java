package cn.luckydeer.dao.users.daoInterface;

import java.util.List;

import cn.luckydeer.dao.users.dataobject.WxUserDo;

/**
 * 
 * 微信用户接口
 * @author yuanxx
 * @version $Id: IWxUserDao.java, v 0.1 2018年6月12日 上午11:18:49 yuanxx Exp $
 */
public interface IWxUserDao {

    /**
     * 
     * 注解：查询所有微信用户
     * @return
     * @author yuanxx @date 2018年6月12日
     */
    List<WxUserDo> selectAll();

    /**
     * 
     * 注解：根据微信openId查询用户信息
     * @param openId
     * @return
     * @author yuanxx @date 2018年6月13日
     */
    WxUserDo getWxUserByOpenId(String openId);

    
    
}
