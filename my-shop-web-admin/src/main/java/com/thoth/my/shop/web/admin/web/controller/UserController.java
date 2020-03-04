package com.thoth.my.shop.web.admin.web.controller;

import com.thoth.my.shop.common.dto.BaseResult;
import com.thoth.my.shop.domain.TbUser;
import com.thoth.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @program: my-shop
 * @description: 用户管理
 * @author: yyj
 * @create: 2019-12-07 09:43
 **/
@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private TbUserService userService;


    @ModelAttribute
    public TbUser getTbUser(Long id){

        TbUser tbUser = null;

        if (id != null) {

            tbUser = userService.getById(id);
        } else {

            tbUser = new TbUser();

        }

        return tbUser;

    }



    /**
     * 跳转用户列表页面
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model) {
        List<TbUser> tbUsers = userService.selectAll();
        model.addAttribute("users", tbUsers);
        return "user_list";
    }

    /**
     * 跳转用户表单页
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String userForm() {
        return "user_form";
    }


    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbUser tbUser, Model model ,RedirectAttributes redirectAttributes) {

        BaseResult baseResult = userService.save(tbUser);

        if (baseResult.getCode()==BaseResult.SUCCESS_CODE) {

            redirectAttributes.addFlashAttribute("baseResult",baseResult);

            return "redirect:/user/list";

        }else{

            model.addAttribute("baseResult", baseResult);

            return "user_form";

        }

    }

    /**
     * 搜索
     * @param tbUser
     * @param model
     * @return
     */
    @RequestMapping(value = "search",method = RequestMethod.POST)
    public String search(TbUser tbUser,Model model){

        List<TbUser> search = userService.search(tbUser);

        model.addAttribute("users", search);

        return "user_list";
    }

    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public BaseResult deleteAll(String ids){
        BaseResult baseResult =  BaseResult.success();
        return baseResult;
    }

}
