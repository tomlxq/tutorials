package com.tom.roles.rolesauthorities.persistence;

import com.tom.roles.rolesauthorities.model.User;

public interface IUserService {

    User findUserByEmail(String email);

}
