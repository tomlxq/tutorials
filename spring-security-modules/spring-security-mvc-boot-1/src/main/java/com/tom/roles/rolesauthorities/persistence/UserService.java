package com.tom.roles.rolesauthorities.persistence;

import com.tom.roles.rolesauthorities.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private UserRepository repository;

    public User findUserByEmail(String email) {
        return repository.findByEmail(email);
    }
}