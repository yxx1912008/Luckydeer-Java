package cn.luckydeer.note.facade.note;

import java.util.List;

import cn.luckydeer.note.model.note.NoteInfoModel;

/**
 * 
 * 开放的远程服务接口
 * @author yuanxx
 * @version $Id: NoteInfoService.java, v 0.1 2018年6月7日 上午11:01:47 yuanxx Exp $
 */
public interface NoteInfoService {

    /**
     * 
     * 注解：查询所有
     * @return
     * @author yuanxx @date 2018年6月7日
     */
    List<NoteInfoModel> selectAll();

}
