package cn.luckydeer.movie.web.movie;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.luckydeer.movie.dao.movie.dataobject.MovieInfoDo;
import cn.luckydeer.movie.manager.movie.MovieInfoManager;

import com.alibaba.fastjson.JSON;

/**
 * 控制层
 * @author yuanxx
 * @version $Id: MovieInfoController.java, v 0.1 2018年6月5日 上午11:15:21 yuanxx Exp $
 */
@Controller
public class MovieInfoController {

    @Autowired
    private MovieInfoManager movieInfoManager;

    /**
     * 
     * 注解：获取电影信息
     * @param request
     * @param response
     * @return
     * @author yuanxx @date 2018年6月5日
     */
    @RequestMapping(value = "/getMovieInfo",produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public String getMovieInfo(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("进来了");
        List<MovieInfoDo> list = movieInfoManager.getAllMovieInfo();
        return JSON.toJSON(list).toString();
    }

}
