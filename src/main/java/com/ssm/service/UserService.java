package com.ssm.service;

import com.ssm.pojo.po.LayuiReplay;
import com.ssm.pojo.po.User;

public interface UserService {
    User queryUserById(Long uid);
    LayuiReplay queryAllUserPages(String username, Integer page, Integer limit);

    boolean updateUser(User user);

    boolean userDelete(Long uid);

    boolean addUser(User user);
}
