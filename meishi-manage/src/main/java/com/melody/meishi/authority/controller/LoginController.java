package com.melody.meishi.authority.controller;

import com.meishi.common.result.*;
import com.meishi.metadata.ws.system.dto.UserDTO;
import com.meishi.metadata.ws.system.service.UserService;
import com.melody.meishi.authority.vo.LoginUserVo;
import com.melody.meishi.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangliang on 2016/7/22.
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private UserService userService;

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/check")
    @ResponseBody
    public RequestResult<Object> check(HttpServletRequest request, String username, String password) {
        RequestResult<Object> requestResult = RequestResult.successResult();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            log.error("用户名或密码为空，登录失败");
            return RequestResult.buildErrorRequest("用户名或密码为空，登录失败");
        }

        Result result = userService.checkUser(username, password);
        if (result.isSuccess()){
            UserDTO userDTO = (UserDTO) result.getReturnValue();
            LoginUserVo userVo = new LoginUserVo(userDTO);
            super.setLoginUser(userVo);
            Map<String, Object> map = new HashMap<>();
            map.put("forwardUrl", request.getContextPath()+"/login/checkIn");
            requestResult.setData(map);
            return requestResult;
        }else {
            return RequestResult.buildRequestFromResult(result);
        }
    }

    @RequestMapping(value="/checkIn")
    public String checkIn(HttpServletRequest request){
        return "index";
    }

}
