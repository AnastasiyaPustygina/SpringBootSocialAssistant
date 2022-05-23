package com.samsung.service;

import com.samsung.domain.Organization;
import com.samsung.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService{

    private final OrganizationRepository organizationRepository;
    @Override
    public Organization insert(Organization organization) {
        return organizationRepository.save(organization);
    }

    @Override
    public List<Organization> getAll() {
        return organizationRepository.findAll();
    }

    @Override
    public Organization getById(int id) {
        return organizationRepository.findById(id);
    }

    @Override
    public Organization update(int id, String name, String type, String organizationPhoto, String
            description, String address, String needs, String linkToWebsite) {
        Organization organization = Organization.builder().id(id).name(name).type(type).
                organizationPhoto(organizationPhoto).description(description).address(address).
                needs(needs).linkToWebsite(linkToWebsite).build();

        return organizationRepository.save(organization);
    }

    @Override
    public void deleteById(int id) {
        organizationRepository.deleteById(id);
    }
}
