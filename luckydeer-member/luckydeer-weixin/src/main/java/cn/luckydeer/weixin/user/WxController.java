package cn.luckydeer.weixin.user;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.luckydeer.common.enums.ViewShowEnums;
import cn.luckydeer.common.model.ResponseObj;
import cn.luckydeer.dao.users.daoInterface.IWxUserDao;
import cn.luckydeer.dao.users.dataobject.WxUserDo;

/**
 * 
 * 微信控制器
 * 
 * @author yuanxx
 * @version $Id: WxController.java, v 0.1 2018年6月12日 下午2:09:08 yuanxx Exp $
 */
@Controller
@RequestMapping(value = "/wx", method = RequestMethod.POST)
public class WxController extends BaseController {

    @Autowired
    private IWxUserDao wxUserDao;

    @RequiresRoles(value = "xxx")
    @RequestMapping(value = "/getAllUser.wx", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getAllUser() {
        List<WxUserDo> list = wxUserDao.selectAll();
        if (CollectionUtils.isEmpty(list)) {
            return new ResponseObj(ViewShowEnums.ERROR_FAILED.getCode(),
                ViewShowEnums.ERROR_FAILED.getDetail()).toJson();
        }
        return new ResponseObj(list).toJson();
    }

    @RequestMapping(value = "/getAllUser.do", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getAllUserType() {
        List<WxUserDo> list = wxUserDao.selectAll();
        if (CollectionUtils.isEmpty(list)) {
            return new ResponseObj(ViewShowEnums.ERROR_FAILED.getCode(),
                ViewShowEnums.ERROR_FAILED.getDetail()).toJson();
        }
        return new ResponseObj(list).toJson();
    }

}
