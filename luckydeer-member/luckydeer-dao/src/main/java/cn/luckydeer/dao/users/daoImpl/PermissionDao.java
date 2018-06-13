package cn.luckydeer.dao.users.daoImpl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.luckydeer.dao.users.daoInterface.IPermissionDao;
import cn.luckydeer.dao.users.dataobject.PermissionDo;

public class PermissionDao extends SqlSessionDaoSupport implements IPermissionDao {

    private String namespace;

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(PermissionDo record) {
        return 0;
    }

    @Override
    public int insertSelective(PermissionDo record) {
        return 0;
    }

    @Override
    public PermissionDo selectByPrimaryKey(Integer id) {
        if (null == id) {
            return null;
        }
        return getSqlSession().selectOne(namespace + "selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(PermissionDo record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(PermissionDo record) {
        return 0;
    }

}
