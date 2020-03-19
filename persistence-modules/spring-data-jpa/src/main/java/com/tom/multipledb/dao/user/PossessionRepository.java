package com.tom.multipledb.dao.user;

import com.tom.multipledb.model.user.PossessionMultipleDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PossessionRepository extends JpaRepository<PossessionMultipleDB, Long> {

}