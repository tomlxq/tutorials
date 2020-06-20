package com.tom.inmemory.persistence.dao;

import com.tom.inmemory.persistence.model.ManyTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManyTagRepository extends JpaRepository<ManyTag, Long> {
}
