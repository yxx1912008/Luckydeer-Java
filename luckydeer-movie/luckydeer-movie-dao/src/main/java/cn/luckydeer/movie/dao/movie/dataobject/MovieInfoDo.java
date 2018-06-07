package cn.luckydeer.movie.dao.movie.dataobject;

/**
 * 
 * 电影详情 POJO
 * @author yuanxx
 * @version $Id: MovieInfoDo.java, v 0.1 2018年6月4日 下午5:15:59 yuanxx Exp $
 */
public class MovieInfoDo {

    private Integer id;

    private String  name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
