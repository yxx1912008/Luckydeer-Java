package cn.luckydeer.common.shiro.basecontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.luckydeer.common.enums.ViewShowEnums;
import cn.luckydeer.common.model.ResponseObj;

/**
 * 基础控制器
 * 
 * @author yuanxx
 * @version $Id: BaseController.java, v 0.1 2018年6月13日 上午9:22:48 yuanxx Exp $
 */
public abstract class BaseController {

    @ExceptionHandler({ UnauthenticatedException.class, AuthenticationException.class })
    @ResponseBody
    public String authenticationException(HttpServletRequest request, HttpServletResponse response) {
        return new ResponseObj(ViewShowEnums.ERROR_FAILED.getCode(),
            ViewShowEnums.ERROR_FAILED.getDetail()).toJson();
    }

    /**
     * 权限异常
     */
    @ExceptionHandler({ UnauthorizedException.class, AuthorizationException.class })
    @ResponseBody
    public String authorizationException(HttpServletRequest request, HttpServletResponse response) {
        return new ResponseObj(ViewShowEnums.ERROR_FAILED.getCode(),
            ViewShowEnums.ERROR_FAILED.getDetail()).toJson();
    }

}
