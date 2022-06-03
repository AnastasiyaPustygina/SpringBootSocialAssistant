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
    public Organization update(Organization organization) {

        return organizationRepository.save(organization);
    }

    @Override
    public void deleteById(int id) {
        organizationRepository.deleteById(id);
    }
}
