package com.yan.springsecuritydemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.yan.springsecuritydemo.entity.LoginUser;
import com.yan.springsecuritydemo.entity.User;
import com.yan.springsecuritydemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Objects;

public class LoginUserdetailService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<User> wrapper=new LambdaQueryWrapper<User>();
        wrapper.eq(User::getUserName,username);
        User user=userMapper.selectOne(wrapper);
        if(Objects.isNull(user)){
            throw new RuntimeException("用户名或者密码错误");
        }
        //TODO 根据用户查询权限信息，添加到LoginUser
        return new LoginUser(user);
    }
}
