package cn.luckydeer.movie.model.model;

import java.io.Serializable;

/**
 * model 序列化 用于网络传输
 * 
 * @author yuanxx
 * @version $Id: MovieInfoModel.java, v 0.1 2018年6月5日 下午2:40:25 yuanxx Exp $
 */
public class MovieInfoModel implements Serializable {

    /** serialVersionUID  */
    private static final long serialVersionUID = -7269569859338357046L;

    private Integer           id;

    private String            name;

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
