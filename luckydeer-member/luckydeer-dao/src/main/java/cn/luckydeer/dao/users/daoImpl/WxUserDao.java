package cn.luckydeer.dao.users.daoImpl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.luckydeer.dao.users.daoInterface.IWxUserDao;
import cn.luckydeer.dao.users.dataobject.WxUserDo;

public class WxUserDao extends SqlSessionDaoSupport implements IWxUserDao {

    private String namespace;

    @Override
    public List<WxUserDo> selectAll() {
        return getSqlSession().selectList(namespace + "selectAll");
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

}
