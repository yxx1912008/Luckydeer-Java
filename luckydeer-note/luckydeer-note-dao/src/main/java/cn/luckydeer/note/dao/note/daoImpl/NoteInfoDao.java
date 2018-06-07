package cn.luckydeer.note.dao.note.daoImpl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.luckydeer.note.dao.note.dataInterface.INoteInfoDao;
import cn.luckydeer.note.dao.note.dataobject.NoteInfoDo;

public class NoteInfoDao extends SqlSessionDaoSupport implements INoteInfoDao {

    private String namespace;

    /**
     * 
     * @see cn.luckydeer.note.dao.note.dataInterface.INoteInfoDao#selectAll()
     */
    @Override
    public List<NoteInfoDo> selectAll() {
        return getSqlSession().selectList(namespace + "selectAll");
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

}
