package com.tom.springbootdatasourceconfig.application.repositories;

import com.tom.springbootdatasourceconfig.application.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
