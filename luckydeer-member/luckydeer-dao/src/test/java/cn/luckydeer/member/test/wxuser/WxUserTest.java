package cn.luckydeer.member.test.wxuser;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.luckydeer.dao.users.daoInterface.IWxUserDao;
import cn.luckydeer.dao.users.dataobject.WxUserDo;
import cn.luckydeer.member.test.BaseTest;

/**
 * 
 * 测试微信用户
 * @author yuanxx
 * @version $Id: WxUserTest.java, v 0.1 2018年6月12日 上午11:36:14 yuanxx Exp $
 */
public class WxUserTest extends BaseTest {

    @Autowired
    private IWxUserDao wxUserDao;

    /**
     * 
     * 注解：查询所有
     * @author yuanxx @date 2018年6月12日
     */
    @Test
    public void selectAll() {

        List<WxUserDo> list = wxUserDao.selectAll();

        for (WxUserDo wxUser : list) {
            System.out.println(wxUser.getNickName());
        }

    }

}
