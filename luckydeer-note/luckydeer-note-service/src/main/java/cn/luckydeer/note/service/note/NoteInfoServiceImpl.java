package cn.luckydeer.note.service.note;

import java.util.List;

import cn.luckydeer.note.facade.note.NoteInfoService;
import cn.luckydeer.note.manager.note.NoteInfoManager;
import cn.luckydeer.note.model.note.NoteInfoModel;

/**
 * 
 * 开放接口功能的实现层
 * @author yuanxx
 * @version $Id: NoteInfoServiceImpl.java, v 0.1 2018年6月7日 上午11:08:57 yuanxx Exp $
 */
public class NoteInfoServiceImpl implements NoteInfoService {

    private NoteInfoManager noteInfoManager;

    /**
     * @see cn.luckydeer.note.facade.note.NoteInfoService#selectAll()
     */
    @Override
    public List<NoteInfoModel> selectAll() {
        return noteInfoManager.selectNoteInfoForService();
    }

    public void setNoteInfoManager(NoteInfoManager noteInfoManager) {
        this.noteInfoManager = noteInfoManager;
    }

}
