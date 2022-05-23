package com.samsung.rest.controller;

import com.samsung.domain.Organization;
import com.samsung.rest.dto.OrganizationDto;
import com.samsung.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor

public class OrganizationController {

    private final OrganizationService organizationService;

    @GetMapping("/organization") public List<OrganizationDto> getAllOrganization(){
        return organizationService.getAll().stream().map(OrganizationDto::toDto)
                .collect(Collectors.toList());
    }
    @PostMapping("/organization")
    public OrganizationDto insertOrganization(@RequestBody OrganizationDto organizationDto){
        Organization organization = organizationService.insert(OrganizationDto.toDomainObject(organizationDto));
        return OrganizationDto.toDto(organization);
    }
    @PutMapping("/organization/{id}")
    public OrganizationDto updateOrganization(@PathVariable int id,
                                              @RequestParam String name,
                                              @RequestParam String type,
                                              @RequestParam String organizationPhoto,
                                              @RequestParam String description,
                                              @RequestParam String address,
                                              @RequestParam String needs,
                                              @RequestParam String linkToWebsite){
        Organization organization = organizationService.update(id, name, type,
                organizationPhoto, description, address, needs, linkToWebsite);
        return OrganizationDto.toDto(organization);
    }
    @DeleteMapping("/organization/{id}")
    public void deleteOrganization(@PathVariable int id){
        organizationService.deleteById(id);
    }
    @GetMapping("/organization/{id}")
    public OrganizationDto getOrganizationById(@PathVariable int id){
        Organization organization = organizationService.getById(id);
        return OrganizationDto.toDto(organization);
    }
}
