package cn.luckydeer.note.dao.note.dataobject;

/**
 * 笔记信息
 * 
 * @author yuanxx
 * @version $Id: NoteInfoDo.java, v 0.1 2018年6月6日 上午9:36:46 yuanxx Exp $
 */
public class NoteInfoDo {

    private Integer id;

    private String  name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
