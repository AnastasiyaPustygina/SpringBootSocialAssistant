package com.samsung.rest.dto;

import com.samsung.domain.Organization;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class OrganizationDto {


    private int id;
    private String name, type, login, organizationPhoto,
            description, address, needs, linkToWebsite, password;

    public static com.samsung.rest.dto.OrganizationDto toDto(Organization organization) {
        return new com.samsung.rest.dto.OrganizationDto(organization.getId(), organization.getName(),
                organization.getType(), organization.getLogin(), organization.getOrganizationPhoto(),
                organization.getDescription(), organization.getAddress(), organization.getNeeds(),
                organization.getLinkToWebsite(), organization.getPassword());
    }

    public static Organization toDomainObject(OrganizationDto organizationDto){

        return new Organization(organizationDto.getId(), organizationDto.getName(),
                organizationDto.getType(), organizationDto.getLogin(),
                organizationDto.getOrganizationPhoto(), organizationDto.getDescription(),
                organizationDto.getAddress(), organizationDto.getNeeds(),
                organizationDto.getLinkToWebsite(), organizationDto.getPassword());
    }

}
