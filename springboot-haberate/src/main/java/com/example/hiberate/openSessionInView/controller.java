package com.example.hiberate.openSessionInView;

import com.example.hiberate.openSessionInView.service.LinkNoInterestService;
import com.example.hiberate.openSessionInView.entity.LinkNoInterest;
import com.example.hiberate.openSessionInView.entity.User;
import com.example.hiberate.openSessionInView.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class controller {
    @Autowired
    LinkNoInterestService linkNoInterestService;
    @Autowired
    UserService userService;
    @RequestMapping(value = "/gg")
    @ResponseBody
    public String hello(){
        return "success";
    }
    @RequestMapping(value = "/get")
    @ResponseBody
    public LinkNoInterest get(){
        return linkNoInterestService.getModel(1l);
    }
    @RequestMapping(value = "/get/user")
    @ResponseBody
    public User getUser(){
        return userService.getUser("admin");
    }

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "this is from 8083";
    }
}
