package com.tom.roles.custom.persistence.dao;

import com.tom.roles.custom.persistence.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    public Organization findByName(String name);

}
