package com.samsung.service;


import com.samsung.domain.Organization;

import java.util.List;

public interface OrganizationService {
    Organization insert(Organization organization);
    List<Organization> getAll();
    Organization getById(int id);
    Organization update(Organization organization);
    void deleteById(int id);

}
