package com.tom.persistence.dao;

import com.tom.persistence.model.User;
import com.tom.web.util.SearchCriteria;

import java.util.List;

public interface IUserDAO {
    List<User> searchUser(List<SearchCriteria> params);

    void save(User entity);
}
