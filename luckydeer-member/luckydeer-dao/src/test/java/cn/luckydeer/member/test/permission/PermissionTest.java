package cn.luckydeer.member.test.permission;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.luckydeer.dao.users.daoInterface.IPermissionDao;
import cn.luckydeer.dao.users.dataobject.PermissionDo;
import cn.luckydeer.member.test.BaseTest;

/**
 * 测试权限
 * 
 * @author yuanxx
 * @version $Id: PermissionTest.java, v 0.1 2018年6月13日 上午10:55:46 yuanxx Exp $
 */
public class PermissionTest extends BaseTest {

    @Autowired
    private IPermissionDao permissionDao;

    @Test
    public void selectByPrimaryKey() throws Exception {
        Integer id = 1;
        PermissionDo obj = permissionDao.selectByPrimaryKey(id);
        System.out.println(obj.getDescription());
    }

}
