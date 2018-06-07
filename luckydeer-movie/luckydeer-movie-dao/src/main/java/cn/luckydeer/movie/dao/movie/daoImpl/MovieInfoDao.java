package cn.luckydeer.movie.dao.movie.daoImpl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.luckydeer.movie.dao.movie.daoInterface.IMovieInfoDao;
import cn.luckydeer.movie.dao.movie.dataobject.MovieInfoDo;

public class MovieInfoDao extends SqlSessionDaoSupport implements IMovieInfoDao {

    private String namespace;

    @Override
    public List<MovieInfoDo> selectAll() {
        return getSqlSession().selectList(namespace + "selectAll");
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

}
