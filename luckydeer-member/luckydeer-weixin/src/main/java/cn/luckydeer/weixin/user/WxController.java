package cn.luckydeer.weixin.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * 微信控制器
 * 
 * @author yuanxx
 * @version $Id: WxController.java, v 0.1 2018年6月12日 下午2:09:08 yuanxx Exp $
 */
@Controller
@RequestMapping(value = "/wx", method = RequestMethod.POST)
public class WxController {

    @RequestMapping(value = "/getAllUser", produces = "application/json;charset=utf-8")
    @ResponseBody
    public void name() {

        
        
        
    }

}
