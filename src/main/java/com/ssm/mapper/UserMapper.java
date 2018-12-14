package com.ssm.mapper;

import com.ssm.pojo.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
 User getUser(Long uid);
 boolean saveUser(User user);
 boolean updateUser(User user);
 List<User> userListPage(@Param("username") String username, @Param("begin") Integer begin, @Param("limit") Integer limit);
 Long queryCount(@Param("username") String username);
 boolean deleteUser(Long uid);
}
