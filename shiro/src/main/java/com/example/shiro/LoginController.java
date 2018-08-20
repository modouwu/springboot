package com.example.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "need login";
    }

    //登录
    @GetMapping("/doLogin")
    public String doLogin(String uid, String pwd,HttpSession session){
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(uid,pwd);
        try{
            //进行验证，这里可以捕获异常，然后返回对应信息
            /*login请求调用subject.login之后,shiro会将token传递给自定义realm,此时realm会先调用
            doGetAuthenticationInfo登录验证的方法，验证通过后会接着调用 doGetAuthorizationInfo
            获取角色和权限的方法（授权），最后返回视图。 */
            /*当其他请求进入shiro时，shiro会调用doGetAuthorizationInfo去获取授权信息，
            若是没有权限或角色，会跳转到未授权页面，若有权限或角色，shiro会放行，ok，此时进入真正的请求方法
            * */
            subject.login(token);
            Object user=subject.getPrincipal();
            session.setAttribute("user", user);
        }
        catch(Exception e){
            return "login failed";
        }

        return "login success";
    }

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    //登出
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        session.removeAttribute("user");
        return "logout";
    }

    //错误页面展示
    @GetMapping("/error")
    public String error(){
        return "error ok!";
    }

    @RequiresRoles("admin")
    @RequiresPermissions("create")
    @RequestMapping(value = "/create")
    public String create(){
        return "Create success!";
    }

    @RequiresPermissions("detail")
    @RequestMapping(value = "/detail")
    public String detail(){
        return "uid";
    }

    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")//权限管理;
    public String userInfoAdd(){
        return "userInfoAdd";
    }
}
