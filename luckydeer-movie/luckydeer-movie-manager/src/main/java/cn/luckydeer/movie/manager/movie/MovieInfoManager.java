package cn.luckydeer.movie.manager.movie;

import java.util.ArrayList;
import java.util.List;

import cn.luckydeer.movie.dao.movie.daoInterface.IMovieInfoDao;
import cn.luckydeer.movie.dao.movie.dataobject.MovieInfoDo;
import cn.luckydeer.movie.model.model.MovieInfoModel;

public class MovieInfoManager {

    private IMovieInfoDao movieInfoDao;

    /**
     * 
     * 注解：查询所有电影信息
     * @return
     * @author yuanxx @date 2018年6月5日
     */
    public List<MovieInfoDo> getAllMovieInfo() {
        return movieInfoDao.selectAll();
    }

    /**
     * 
     * 注解：查询所有电影信息(model)
     * @return
     * @author yuanxx @date 2018年6月5日
     */
    public List<MovieInfoModel> getAllMovieInfoModel() {

        List<MovieInfoDo> list = movieInfoDao.selectAll();
        List<MovieInfoModel> listResult = new ArrayList<>();
        for (MovieInfoDo movieInfoDo : list) {
            if (null != convert(movieInfoDo)) {
                listResult.add(convert(movieInfoDo));
            }
        }
        return listResult;
    }

    private MovieInfoModel convert(MovieInfoDo movieInfoDo) {
        MovieInfoModel movieInfoModel = null;
        if (null != movieInfoDo) {
            movieInfoModel = new MovieInfoModel();
            movieInfoModel.setId(movieInfoDo.getId());
            movieInfoModel.setName(movieInfoDo.getName());
        }

        return movieInfoModel;
    }

    public void setMovieInfoDao(IMovieInfoDao movieInfoDao) {
        this.movieInfoDao = movieInfoDao;
    }

}
