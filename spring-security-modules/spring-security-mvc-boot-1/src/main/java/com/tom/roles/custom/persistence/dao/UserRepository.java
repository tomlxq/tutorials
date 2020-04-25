package com.tom.roles.custom.persistence.dao;

import com.tom.roles.custom.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(final String username);

    @Transactional
    void removeUserByUsername(String username);

}
