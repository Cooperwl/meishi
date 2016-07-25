package com.melody.meishi.authority.controller;

import com.meishi.common.result.*;
import com.meishi.metadata.ws.meta.dto.UserDTO;
import com.meishi.metadata.ws.meta.service.UserService;
import com.melody.meishi.authority.vo.LoginUserVo;
import com.melody.meishi.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangliang on 2016/7/22.
 */
@Controller
@RequestMapping("/authority")
public class LoginController extends BaseController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
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
            requestResult.setStatus(StatusPool.getPool().getStatus(StatusConstant.LOGIN_FAILED));
            return requestResult;
        }

        Result result = userService.checkUser(username, password);
        if (result.isSuccess()){
            UserDTO userDTO = (UserDTO) result.getReturnValue();
            LoginUserVo userVo = new LoginUserVo(userDTO);
            super.setLoginUser(userVo);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("forwardUrl", request.getContextPath()+"/login/checkIn");
            requestResult.setData(map);
            requestResult.setStatus(StatusUtils.getSuccessStatus());
            return requestResult;
        }else {
            requestResult.setStatus(StatusPool.getPool().getStatus(StatusConstant.LOGIN_FAILED));
            return requestResult;
        }
    }

    @RequestMapping(value="/login/checkIn")
    public String checkIn(HttpServletRequest request){
        return "index";
    }

}
