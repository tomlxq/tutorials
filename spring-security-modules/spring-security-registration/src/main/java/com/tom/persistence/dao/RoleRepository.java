package com.tom.persistence.dao;

import com.tom.persistence.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/4/21
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

    @Override
    void delete(Role role);


}
