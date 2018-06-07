package cn.luckydeer.note.manager.note;

import java.util.List;

import cn.luckydeer.movie.model.model.MovieInfoModel;
import cn.luckydeer.note.dao.note.dataInterface.INoteInfoDao;
import cn.luckydeer.note.dao.note.dataobject.NoteInfoDo;
import cn.luckydeer.note.integration.movie.MovieInfoServiceClient;

/**
 * 
 * 管理层
 * @author yuanxx
 * @version $Id: NoteInfoManager.java, v 0.1 2018年6月6日 上午9:57:23 yuanxx Exp $
 */
public class NoteInfoManager {

    private INoteInfoDao           noteInfoDao;

    private MovieInfoServiceClient movieInfoServiceClient;

    /**
     * 
     * 注解：查询所有笔记信息
     * @return
     * @author yuanxx @date 2018年6月6日
     */
    public List<NoteInfoDo> selectAll() {
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

    public void setNoteInfoDao(INoteInfoDao noteInfoDao) {
        this.noteInfoDao = noteInfoDao;
    }

    public void setMovieInfoServiceClient(MovieInfoServiceClient movieInfoServiceClient) {
        this.movieInfoServiceClient = movieInfoServiceClient;
    }

}
