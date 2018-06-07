package cn.luckydeer.movie.dao.movie.daoInterface;

import java.util.List;

import cn.luckydeer.movie.dao.movie.dataobject.MovieInfoDo;

/**
 * 
 * 电影信息数据库操作
 * @author yuanxx
 * @version $Id: IMovieInfoDao.java, v 0.1 2018年6月4日 下午5:19:22 yuanxx Exp $
 */
public interface IMovieInfoDao {

    /**
     * 
     * 注解：查询所有
     * @return
     * @author yuanxx @date 2018年6月4日
     */
    List<MovieInfoDo> selectAll();

}
