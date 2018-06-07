package cn.luckydeer.note.dao.note.dataInterface;

import java.util.List;

import cn.luckydeer.note.dao.note.dataobject.NoteInfoDo;

public interface INoteInfoDao {

    /**
     * 
     * 注解：查询所有
     * @return
     * @author yuanxx @date 2018年6月6日
     */
    List<NoteInfoDo> selectAll();

}
