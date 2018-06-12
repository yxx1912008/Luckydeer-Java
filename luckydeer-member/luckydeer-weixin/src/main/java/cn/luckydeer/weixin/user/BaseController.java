package cn.luckydeer.weixin.user;

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
