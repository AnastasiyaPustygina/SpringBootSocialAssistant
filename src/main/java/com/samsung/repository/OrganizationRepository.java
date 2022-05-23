package com.samsung.repository;

import com.samsung.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

    List<Organization> findAll();
    Organization findById(int id);

}
