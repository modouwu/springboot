package com.example.hiberate.querydsl;
import com.example.hiberate.openSessionInView.entity.User;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(tags = "用户API")
public class HiberateController {
    @Autowired
    private UserDao2 userDao;

    @RequestMapping(value = "/queryDSL/get",method = RequestMethod.GET)//这里swagger会根据这个method来判断rest的类型,不写会应用到所有rest接口,对应RequestMethod里的方法
    @ResponseBody
    @ApiOperation(value="用户获取")
    @ApiImplicitParam(name="id",value="查询ID",required=true)
    public User get(){
        return userDao.getUser();
    }
}
