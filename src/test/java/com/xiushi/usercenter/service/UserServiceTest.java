package com.xiushi.usercenter.service;

import java.util.Date;


import com.xiushi.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("text");
        user.setUserAccount("123");
        user.setAvatarUrl("https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png");
        user.setGender(0);
        user.setUserPassword("xxx");
        user.setEmail("123");
        user.setPhone("123");

        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);
    }

    @Test
    void userRegister() {
        //测试非空
        String userAccount = "xiushi";
        String userPassword = "";
        String checkPassword = "123456";
        String planerCode = "1";
        long result = userService.userRegister(userAccount, userPassword, checkPassword,planerCode);
        Assertions.assertEquals(-1, result);

        userAccount = "xi";
        userPassword = "12345";
        result = userService.userRegister(userAccount, userPassword, checkPassword,planerCode);
        Assertions.assertEquals(-1, result);

        userAccount = "xiushi";
        result = userService.userRegister(userAccount, userPassword, checkPassword,planerCode);
        Assertions.assertEquals(-1, result);

        userAccount = "xi si";
        userPassword = "12345678";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword,planerCode);
        Assertions.assertEquals(-1, result);

        userAccount = "xiushi";
        checkPassword = "123456789";
        result = userService.userRegister(userAccount, userPassword, checkPassword,planerCode);
        Assertions.assertEquals(-1, result);

        userAccount = "text";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword,planerCode);
        Assertions.assertEquals(-1, result);

        userAccount = "xiushi1";
        planerCode = "2";
        result = userService.userRegister(userAccount, userPassword, checkPassword,planerCode);
        Assertions.assertTrue(result > 0);
    }
}