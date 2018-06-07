package cn.luckydeer.movie.facade.movie;

import java.util.List;

import cn.luckydeer.movie.model.model.MovieInfoModel;

/**
 * 
 * 电影服务
 * @author yuanxx
 * @version $Id: MovieService.java, v 0.1 2018年6月5日 下午2:38:25 yuanxx Exp $
 */
public interface MovieService {

    /**
     * 
     * 注解：查询所有电影信息
     * @return
     * @author yuanxx @date 2018年6月5日
     */
    public List<MovieInfoModel> selectAll();

}
