package com.example.hiberate.openSessionInView.service;

import com.example.hiberate.openSessionInView.dao.UserDao;
import com.example.hiberate.openSessionInView.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserDao userDao;

    public User getUser(String jid){
        return userDao.getUser(jid);
    }
}
