package cn.luckydeer.manager.helper.weixin;

import cn.luckydeer.dao.users.daoInterface.IWxUserDao;
import cn.luckydeer.dao.users.dataobject.WxUserDo;

/**
 * 微信工具
 * 
 * @author yuanxx
 * @version $Id: WXHelper.java, v 0.1 2018年6月12日 上午9:19:14 yuanxx Exp $
 */
public class WXManager {

    private IWxUserDao wxUserDao;

    /**
     * 
     * 注解：根据用户openId获取用户信息
     * @author yuanxx @date 2018年6月13日
     * @return 
     */
    public WxUserDo getWxUserByOpenId(String openId) {
        return wxUserDao.getWxUserByOpenId(openId);
    }

    public void setWxUserDao(IWxUserDao wxUserDao) {
        this.wxUserDao = wxUserDao;
    }

}
