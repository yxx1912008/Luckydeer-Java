package cn.luckydeer.movie.integration.note;

import java.util.List;

import cn.luckydeer.note.facade.note.NoteInfoService;
import cn.luckydeer.note.model.note.NoteInfoModel;

/**
 * 
 * 远程服务的客户端
 * @author yuanxx
 * @version $Id: NoteInfoServiceClient.java, v 0.1 2018年6月7日 上午11:44:46 yuanxx Exp $
 */
public class NoteInfoServiceClient {

    private NoteInfoService noteInfoService;

    /**
     * 
     * 注解：查询所有笔记信息
     * @return
     * @author yuanxx @date 2018年6月7日
     */
    public List<NoteInfoModel> selectAllNoteInfoModel() {
        return noteInfoService.selectAll();
    }

    public void setNoteInfoService(NoteInfoService noteInfoService) {
        this.noteInfoService = noteInfoService;
    }

}
