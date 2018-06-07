package note;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import base.BaseTest;
import cn.luckydeer.note.dao.note.dataInterface.INoteInfoDao;
import cn.luckydeer.note.dao.note.dataobject.NoteInfoDo;

/**
 *数据库测试 
 * @author yuanxx
 * @version $Id: NoteInfoTest.java, v 0.1 2018年6月6日 上午9:49:13 yuanxx Exp $
 */
public class NoteInfoTest extends BaseTest {

    @Autowired
    private INoteInfoDao noteInfoDao;

    /**
     * 
     * 注解：数据库测试
     * @author yuanxx @date 2018年6月6日
     */
    @Test
    public void selectAll_test() {

        List<NoteInfoDo> list = noteInfoDao.selectAll();
        for (NoteInfoDo noteInfoDo : list) {
            System.out.println(noteInfoDo.getName());
        }
    }

}
