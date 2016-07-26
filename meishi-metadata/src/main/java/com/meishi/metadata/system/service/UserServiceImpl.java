package com.meishi.metadata.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.meishi.common.result.Result;
import com.meishi.metadata.system.dao.UserMapper;
import com.meishi.metadata.ws.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/7/25 0025.
 */
@Component
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public Result checkUser(String username, String password){
        return Result.successResult();
    }
}
