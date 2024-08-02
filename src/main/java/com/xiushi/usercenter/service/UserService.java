package com.xiushi.usercenter.service;

import com.xiushi.usercenter.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.client.HttpServerErrorException;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户登录
 *
 * @author DHB
*/
public interface UserService extends IService<User> {


    /**
     * 用户注册
     *
     * @param userAccount 用户账户
     * @param userPassword 用户密码
     * @param checkPassword 校验密码
     * @return
     */
    long userRegister(String userAccount,String userPassword,String checkPassword);

    /**
     * 用户登录
     *
     * @param userAccount  用户账户
     * @param userPassword 用户密码
     * @param request
     * @return 脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     * @param originUser
     * @return
     */
    User getSafetyUser(User originUser);
}
