package com.thoth.my.shop.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: my-shop
 * @description: zhu
 * @author: yyj
 * @create: 2019-12-05 10:02
 **/
@Controller
public class MainController {

    @RequestMapping(value = "main" ,method = RequestMethod.GET)
    public String main() {

        return "main";

    }


}
