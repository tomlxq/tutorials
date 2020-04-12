package com.tom.boot.repository;

import com.tom.boot.domain.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericEntityRepository extends JpaRepository<GenericEntity, Long> {
}
