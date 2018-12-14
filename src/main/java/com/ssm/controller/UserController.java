package com.ssm.controller;

import com.ssm.pojo.po.LayuiReplay;
import com.ssm.pojo.po.User;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
      @Autowired

    private UserService userService;
    @RequestMapping("/getUser.do" )
    @ResponseBody
    public User getUser(Long uid){
        User user = userService.queryUserById(uid);
        return user;
    }
    @RequestMapping("/userAll.do")
    @ResponseBody
    public LayuiReplay showAllUser(String username, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit){
        LayuiReplay layuiReplay =userService.queryAllUserPages(username,page,limit);
        return layuiReplay;
    }
    @RequestMapping(value = "/toUserUpdate.do",method = RequestMethod.POST)
    @ResponseBody
    public LayuiReplay updateUser(User user){
          LayuiReplay layuiReplay =new LayuiReplay();
          boolean b=userService.updateUser(user);
        if(!b){
            layuiReplay.setCode(-1);
        }
        return layuiReplay;
    }
    @RequestMapping("/userDel.do")
    @ResponseBody
    public LayuiReplay userDel(Long uid){
        LayuiReplay layuiReplay =new LayuiReplay();
        boolean b=userService.userDelete(uid);
        if(!b){
            layuiReplay.setCode(-1);
        }
        return layuiReplay;
    }
    @RequestMapping(value = "/addUser.do",method = RequestMethod.POST)
    @ResponseBody
    public LayuiReplay addUser(User user){
         user.setType("0");
        LayuiReplay layuiReplay =new LayuiReplay();
        boolean b=userService.addUser(user);
          if(!b){
              layuiReplay.setCode(-1);
          }
        return layuiReplay;
    }
}
