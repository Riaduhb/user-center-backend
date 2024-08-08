package com.xiushi.usercenter.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 * @author DHB
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 8535593000682221320L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;

    private String planetCode;
}
