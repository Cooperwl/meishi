package com.meishi.metadata.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.meishi.common.result.Result;
import com.meishi.common.security.MD5;
import com.meishi.metadata.system.dao.UserMapper;
import com.meishi.metadata.system.entity.User;
import com.meishi.metadata.system.entity.UserExample;
import com.meishi.metadata.ws.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2016/7/25 0025.
 */
@Component
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public Result checkUser(String username, String password){
        Result result = Result.successResult();
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserAccountEqualTo(username);
        criteria.andUserPasswordEqualTo(MD5.sign(password));
        List<User> users = userMapper.selectByExample(example);
        if (users != null && !users.isEmpty()){
            result.setReturnValue(users.get(0));
            return result;
        }
        result.setSuccess(false);
        return result;
    }
}
