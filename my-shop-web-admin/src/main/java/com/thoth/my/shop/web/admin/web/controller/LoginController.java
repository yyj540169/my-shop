package com.thoth.my.shop.web.admin.web.controller;

import com.thoth.my.shop.common.constant.ConstantUtil;
import com.thoth.my.shop.domain.TbUser;
import com.thoth.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: my-shop
 * @description: 登录
 * @author: yyj
 * @create: 2019-12-05 10:01
 **/
@Controller
public class LoginController {

    @Autowired
    private TbUserService TbuserService;

    @RequestMapping(value = {"","login"},method = RequestMethod.GET)
    public String login() {


        return "login";
    }


    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(String email, String password, HttpServletRequest request, Model model) {

        TbUser login = TbuserService.selectByEmailAndPassword(email, password);

        if (login == null) {
            model.addAttribute("message", "登录失败，用户名或密码错误！");
            return login();
        } else {

            request.getSession().setAttribute(ConstantUtil.SESSION_USER,login);

            return "redirect:/main";
        }


    }





    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {

        request.getSession().invalidate();

        return "login";

    }




}
