package com.thoth.my.shop.web.admin.service.impl;

import com.thoth.my.shop.common.dto.BaseResult;
import com.thoth.my.shop.common.util.RegexpUtils;
import com.thoth.my.shop.domain.TbUser;
import com.thoth.my.shop.web.admin.dao.TbUserDao;
import com.thoth.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @program: my-shop
 * @description: 实现
 * @author: yyj
 * @create: 2019-12-05 09:59
 **/
@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserDao userDao;

    @Override
    public BaseResult save(TbUser tbUser) {

        BaseResult baseResult = checkTbUser(tbUser);

        if (baseResult.getCode() == BaseResult.SUCCESS_CODE) {


            tbUser.setUpdate(new Date());

            tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));

            if (tbUser.getId() == null) {

                tbUser.setCreated(new Date());
                this.insert(tbUser);
                baseResult.setMessage("新增用户成功");

            } else {

                this.update(tbUser);
                baseResult.setMessage("修改用户成功");

            }

        }

        return baseResult;

    }

    @Override
    public TbUser selectByEmailAndPassword(String email, String password) {

        String s = DigestUtils.md5DigestAsHex(password.getBytes());

        TbUser tbUser = userDao.selectByEmail(email);

        if (tbUser == null) {
            return null;
        }

        if (!s.equals(tbUser.getPassword())) {
            return null;
        }

        return tbUser;
    }

    /**
     * 用户数据验证
     *
     * @param tbUser
     */
    private BaseResult checkTbUser(TbUser tbUser) {

        BaseResult baseResult = BaseResult.success();
        if (StringUtils.isEmpty(tbUser.getEmail())) {
            baseResult = BaseResult.fail("邮箱不可为空，请重新输入...");
        } else if(!RegexpUtils.checkEmail(tbUser.getEmail())){
            baseResult = BaseResult.fail("邮箱格式不正确，请重新输入...");
        }else if (StringUtils.isEmpty(tbUser.getUsername())) {
            baseResult = BaseResult.fail("姓名不可为空，请重新输入...");
        } else if (StringUtils.isEmpty(tbUser.getPassword())) {
            baseResult = BaseResult.fail("密码不可为空，请重新输入...");
        } else if (StringUtils.isEmpty(tbUser.getPhone())) {
            baseResult = BaseResult.fail("手机号不可为空，请重新输入...");
        }else if (RegexpUtils.checkPhone(tbUser.getPhone())) {
            baseResult = BaseResult.fail("手机号格式不正确，请重新输入...");
        }

        return baseResult;


    }


    @Override
    public List<TbUser> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public void insert(TbUser tbUser) {
        userDao.insert(tbUser);
    }

    @Override
    public void update(TbUser tbUser) {
        userDao.update(tbUser);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    public TbUser getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public TbUser selectByName(String username) {
        return userDao.selectByName(username);
    }

    @Override
    public List<TbUser> search(TbUser tbUser) {

        return userDao.search(tbUser);
    }
}
