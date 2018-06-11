package cn.luckydeer.baseaction.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 
 * Shiro 的 Myrealm
 * @author yuanxx
 * @version $Id: MemberRealm.java, v 0.1 2018年6月11日 下午5:18:09 yuanxx Exp $
 */
public class MemberRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0)
                                                                                  throws AuthenticationException {
        return null;
    }

    public void setCredentialMatcher() {

    }

}
