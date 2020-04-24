package com.tom.service;

import com.tom.persistence.model.User;
import com.tom.web.dto.UserDto;
import com.tom.web.error.UserAlreadyExistException;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/4/21
 */

public interface IUserService {

    User registerNewUserAccount(UserDto accountDto) throws UserAlreadyExistException;
}
