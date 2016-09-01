package com.meishi.metadata.system.service;

import com.meishi.common.result.Result;
import com.meishi.common.security.MD5;
import com.meishi.metadata.system.dao.UserMapper;
import com.meishi.metadata.system.entity.User;
import com.meishi.metadata.system.entity.UserExample;
import com.meishi.metadata.ws.system.dto.UserDTO;
import com.meishi.metadata.ws.system.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/7/25 0025.
 */
@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    public Result checkUser(String username, String password){
        Result result = Result.successResult();
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserAccountEqualTo(username);
        criteria.andUserPasswordEqualTo(MD5.sign(password));
        List<User> users = userMapper.selectByExample(example);
        if (users != null && !users.isEmpty()){
            result.setReturnValue(users.get(0).toDTO());
            return result;
        }
        result.setSuccess(false);
        return result;
    }
}
