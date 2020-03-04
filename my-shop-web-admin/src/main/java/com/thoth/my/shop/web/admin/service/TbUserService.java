package com.thoth.my.shop.web.admin.service;

import com.thoth.my.shop.common.dto.BaseResult;
import com.thoth.my.shop.domain.TbUser;

import java.util.List;

/**
 * @program: my-shop
 * @description: dao
 * @author: yyj
 * @create: 2019-12-06 16:22
 **/
public interface TbUserService {
    /**
     * 全查
     * @return
     */
    List<TbUser> selectAll();
    /**
     * 新增
     * @param tbUser
     */
    void insert(TbUser tbUser);
    /**
     * 修改
     * @param tbUser
     */
    void update(TbUser tbUser);
    /**
     * 删除
     * @param id
     */
    void delete(Long id);
    /**
     * 通过id查询
     * @param id
     * @return
     */
    TbUser getById(Long id);
    /**
     * 通过用户名查询
     * @param username
     * @return
     */
    TbUser selectByName(String username);
    /**
     * 通过邮箱 密码查询
     * @param email
     * @return
     */
    TbUser selectByEmailAndPassword(String email,String password);

    /**
     * 保存
     * @param tbUser
     * @return
     */
    BaseResult save(TbUser tbUser);

    /**
     * 搜索
     * @param tbUser
     * @return
     */
    List<TbUser> search(TbUser tbUser);

}
