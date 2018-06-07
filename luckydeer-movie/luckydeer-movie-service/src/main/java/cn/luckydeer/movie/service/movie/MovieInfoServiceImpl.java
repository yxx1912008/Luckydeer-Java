package cn.luckydeer.movie.service.movie;

import java.util.List;

import cn.luckydeer.movie.facade.movie.MovieService;
import cn.luckydeer.movie.manager.movie.MovieInfoManager;
import cn.luckydeer.movie.model.model.MovieInfoModel;

public class MovieInfoServiceImpl implements MovieService {

    private MovieInfoManager movieInfoManager;

    @Override
    public List<MovieInfoModel> selectAll() {
        return movieInfoManager.getAllMovieInfoModel();
    }

    public void setMovieInfoManager(MovieInfoManager movieInfoManager) {
        this.movieInfoManager = movieInfoManager;
    }

}
