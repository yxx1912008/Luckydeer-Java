package cn.luckydeer.member.baseaction.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.luckydeer.dao.users.daoInterface.IWxUserDao;
import cn.luckydeer.dao.users.dataobject.WxUserDo;

/**
 * 用于验证微信用户登录
 * 
 * @author yuanxx
 * @version $Id: WxDefaultRealm.java, v 0.1 2018年6月12日 下午3:12:30 yuanxx Exp $
 */
public class WxDefaultRealm extends AuthorizingRealm {

    private IWxUserDao wxUserDao;

    /**
     * 授权
     * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("进来了");
        String userId = (String) principals.getPrimaryPrincipal();
        WxUserDo wxUserDo = new WxUserDo();
        wxUserDo.setId(userId);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> roles = new HashSet<>();
        roles.add("1");
        info.setRoles(roles);
        Set<String> stringPermissions = new HashSet<>();
        stringPermissions.add("0");
        info.setStringPermissions(stringPermissions);
        return info;
    }

    /**
     * 登录认证
     * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)

    throws AuthenticationException {
        System.out.println("进来了");
        return null;
    }

    public void setWxUserDao(IWxUserDao wxUserDao) {
        this.wxUserDao = wxUserDao;
    }

}
