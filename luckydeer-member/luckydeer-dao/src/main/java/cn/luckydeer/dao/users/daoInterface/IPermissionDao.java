package cn.luckydeer.dao.users.daoInterface;

import cn.luckydeer.dao.users.dataobject.PermissionDo;

/**
 * 用户权限表操作
 * 
 * @author yuanxx
 * @version $Id: IPermissionDao.java, v 0.1 2018年6月13日 上午10:42:42 yuanxx Exp $
 */
public interface IPermissionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(PermissionDo record);

    int insertSelective(PermissionDo record);

    PermissionDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PermissionDo record);

    int updateByPrimaryKey(PermissionDo record);
}