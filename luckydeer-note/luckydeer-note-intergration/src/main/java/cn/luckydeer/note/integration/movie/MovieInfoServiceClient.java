package cn.luckydeer.note.integration.movie;

import java.util.List;

import cn.luckydeer.movie.facade.movie.MovieService;
import cn.luckydeer.movie.model.model.MovieInfoModel;

public class MovieInfoServiceClient {

    private MovieService movieService;

    /**
     * 
     * 注解：调用远程服务
     * @return
     * @author yuanxx @date 2018年6月6日
     */
    public List<MovieInfoModel> selectAll() {
        try {

            List<MovieInfoModel> list = movieService.selectAll();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }
}
