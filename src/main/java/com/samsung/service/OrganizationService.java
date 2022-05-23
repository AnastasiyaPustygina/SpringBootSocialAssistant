package com.samsung.service;


import com.samsung.domain.Organization;

import java.util.List;

public interface OrganizationService {
    Organization insert(Organization organization);
    List<Organization> getAll();
    Organization getById(int id);
    Organization update(int id, String name, String type, String organizationPhoto, String description,
                  String address, String needs, String linkToWebsite);
    void deleteById(int id);

}
