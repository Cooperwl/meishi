package com.meishi.metadata.ws.meta.service;

import com.meishi.common.result.Result;

/**
 * Created by Administrator on 2016/7/25 0025.
 */
public interface UserService {

    Result checkUser(String username, String password);
}
