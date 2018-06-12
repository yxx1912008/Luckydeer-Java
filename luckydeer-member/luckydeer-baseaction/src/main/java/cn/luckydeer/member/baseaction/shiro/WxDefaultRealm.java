package cn.luckydeer.member.baseaction.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.luckydeer.dao.users.daoInterface.IWxUserDao;

/**
 * 用于验证微信用户登录
 * 
 * @author yuanxx
 * @version $Id: WxDefaultRealm.java, v 0.1 2018年6月12日 下午3:12:30 yuanxx Exp $
 */
public class WxDefaultRealm extends AuthorizingRealm {

    private IWxUserDao wxUserDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0)
                                                                                  throws AuthenticationException {
        return null;
    }

    public void setWxUserDao(IWxUserDao wxUserDao) {
        this.wxUserDao = wxUserDao;
    }

}
