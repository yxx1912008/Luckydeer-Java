package cn.luckydeer.note.manager.note;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cn.luckydeer.movie.model.model.MovieInfoModel;
import cn.luckydeer.note.dao.note.dataInterface.INoteInfoDao;
import cn.luckydeer.note.dao.note.dataobject.NoteInfoDo;
import cn.luckydeer.note.integration.movie.MovieInfoServiceClient;
import cn.luckydeer.note.model.note.NoteInfoModel;

/**
 * 
 * 管理层
 * @author yuanxx
 * @version $Id: NoteInfoManager.java, v 0.1 2018年6月6日 上午9:57:23 yuanxx Exp $
 */
public class NoteInfoManager {

    private INoteInfoDao           noteInfoDao;

    private MovieInfoServiceClient movieInfoServiceClient;

    //打开日志记录
    private Logger                 logger = Logger.getLogger("LUCKYDEER-NOTE-MANAGER");

    /**
     * 
     * 注解：查询所有笔记信息
     * @return
     * @author yuanxx @date 2018年6月6日
     */
    public List<NoteInfoDo> selectAll() {
        logger.info("测试增加一条日志信息，此日志来自:" + NoteInfoManager.class);
        return noteInfoDao.selectAll();
    }

    /**
     * 
     * 注解：测试调用远程服务
     * @author yuanxx @date 2018年6月6日
     * @return 
     */
    public List<MovieInfoModel> selectFromService() {
        return movieInfoServiceClient.selectAll();
    }

    /**
     * 
     * 注解：获取远程服务所需要的 笔记信息列表
     * @return
     * @author yuanxx @date 2018年6月7日
     */
    public List<NoteInfoModel> selectNoteInfoForService() {
        List<NoteInfoDo> list = noteInfoDao.selectAll();
        List<NoteInfoModel> listResult = new ArrayList<>();
        for (NoteInfoDo noteInfoDo : list) {
            if (null != convert(noteInfoDo)) {
                listResult.add(convert(noteInfoDo));
            }
        }
        return listResult;
    }

    /**
     * 
     * 注解：将NoteInfoDo 转换为 NoteInfoModel
     * @param noteInfoDo
     * @return
     * @author yuanxx @date 2018年6月7日
     */
    private NoteInfoModel convert(NoteInfoDo noteInfoDo) {
        NoteInfoModel noteInfoModel = null;
        if (null != noteInfoDo) {
            noteInfoModel = new NoteInfoModel();
            noteInfoModel.setId(noteInfoDo.getId());
            noteInfoModel.setName(noteInfoDo.getName());
        }
        return noteInfoModel;
    }

    public void setNoteInfoDao(INoteInfoDao noteInfoDao) {
        this.noteInfoDao = noteInfoDao;
    }

    public void setMovieInfoServiceClient(MovieInfoServiceClient movieInfoServiceClient) {
        this.movieInfoServiceClient = movieInfoServiceClient;
    }

}
