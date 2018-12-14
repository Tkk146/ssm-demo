package com.ssm.service.impl;

import com.ssm.mapper.UserMapper;
import com.ssm.pojo.po.LayuiReplay;
import com.ssm.pojo.po.User;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User queryUserById(Long uid) {
        return userMapper.getUser(uid);
    }

    @Override
    public LayuiReplay queryAllUserPages(String username, Integer page, Integer limit) {
        LayuiReplay layuiReplay =new LayuiReplay();
        page=(page-1)*limit;
        try{
            List<User> userList=userMapper.userListPage(username,page,limit );
            layuiReplay.setData(userList);
            layuiReplay.setCode(0);
            Long count=  userMapper.queryCount(username);
            layuiReplay.setCount(count);
            layuiReplay.setMsg("请求成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return layuiReplay;
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public boolean userDelete(Long uid) {
        return userMapper.deleteUser(uid);
    }

    @Override
    public boolean addUser(User user) {
        return userMapper.saveUser(user);
    }
}
