package movie;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import Base.BaseTest;
import cn.luckydeer.movie.dao.movie.daoInterface.IMovieInfoDao;
import cn.luckydeer.movie.dao.movie.dataobject.MovieInfoDo;

public class MovieTest extends BaseTest {

    @Autowired
    private IMovieInfoDao dao;

    @Test
    public void name() {

        List<MovieInfoDo> list = dao.selectAll();

        for (MovieInfoDo movieInfoDo : list) {
            System.out.println(movieInfoDo.getName());
        }

    }

}
