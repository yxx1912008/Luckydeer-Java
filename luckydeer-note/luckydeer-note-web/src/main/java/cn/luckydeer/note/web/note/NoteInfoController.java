package cn.luckydeer.note.web.note;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.luckydeer.movie.model.model.MovieInfoModel;
import cn.luckydeer.note.dao.note.dataobject.NoteInfoDo;
import cn.luckydeer.note.manager.note.NoteInfoManager;

/**
 * 
 * 控制层
 * @author yuanxx
 * @version $Id: NoteInfoController.java, v 0.1 2018年6月6日 上午10:00:38 yuanxx Exp $
 */
@Controller
@RequestMapping(value = "/web")
public class NoteInfoController {

    @Autowired
    private NoteInfoManager noteInfoManager;

    @RequestMapping(value = "/selectAll", produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String selectAll() {
        String jsonString = "查询失败";
        List<NoteInfoDo> list = noteInfoManager.selectAll();

        if (!CollectionUtils.isEmpty(list)) {
            jsonString = JSON.toJSON(list).toString();
        }
        return jsonString;
    }
    
    @RequestMapping(value = "/selectAllFromRemote", produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String selectAllFromRemote() {
        String jsonString = "查询失败";
        List<MovieInfoModel> list = noteInfoManager.selectFromService();

        if (!CollectionUtils.isEmpty(list)) {
            jsonString = JSON.toJSON(list).toString();
        }
        return jsonString;
    }
    

}
