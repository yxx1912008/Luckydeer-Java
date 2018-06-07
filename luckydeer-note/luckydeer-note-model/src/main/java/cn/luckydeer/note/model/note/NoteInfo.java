package cn.luckydeer.note.model.note;

import java.io.Serializable;

/**
 * 
 * 笔记信息 model
 * @author yuanxx
 * @version $Id: NoteInfo.java, v 0.1 2018年6月7日 上午10:59:36 yuanxx Exp $
 */
public class NoteInfo implements Serializable {

    /**  serialVersionUID */
    private static final long serialVersionUID = -900213777833394934L;

    private Integer           id;

    private String            name;

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
