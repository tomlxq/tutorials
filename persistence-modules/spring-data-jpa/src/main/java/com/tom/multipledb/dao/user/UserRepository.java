package com.tom.multipledb.dao.user;

import com.tom.multipledb.model.user.UserMultipleDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserMultipleDB, Integer> {
}