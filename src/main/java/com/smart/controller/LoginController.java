package com.smart.controller;

import com.smart.domain.User;
import com.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;


    @RequestMapping("/")
    public String LoginPage() {
        return "login";
    }

    @RequestMapping("/loginCheck")
    public ModelAndView loginCheck(HttpServletRequest request, String name, String password) throws Exception{
        boolean isValidUser = this.userService.checkHasMatchUser(name, password);
        if (!isValidUser) {
            return new ModelAndView("login", "error", "用户名或密码错误.");
        } else {
            User user = this.userService.queryUserByName(name);
            user.setLastIp(request.getLocalAddr());
            user.setLastVisit(new Date());
            this.userService.loginSuccess(user);

            request.getSession().setAttribute("user", user);
            return new ModelAndView("main");
        }
    }
}
