package com.tom.threadlocal;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/12
 */
public class UserRepository {
    public String getUserNameForUserId(Integer userId) {
        return "name"+userId;
    }
}
