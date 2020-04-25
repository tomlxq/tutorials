package com.tom.persistence.dao;

import com.tom.persistence.model.NewLocationToken;
import com.tom.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewLocationTokenRepository extends JpaRepository<NewLocationToken, Long> {

    NewLocationToken findByToken(String token);

    NewLocationToken findByUserLocation(User userLocation);

}
