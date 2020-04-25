package com.tom.persistence.dao;

import com.tom.persistence.model.User;
import com.tom.persistence.model.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {
    UserLocation findByCountryAndUser(String country, User user);

}
