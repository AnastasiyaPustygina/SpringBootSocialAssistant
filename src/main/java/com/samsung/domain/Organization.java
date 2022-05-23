package com.samsung.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "organization_photo")
    private String organizationPhoto;
    @Column(name = "description")
    private String description;
    @Column(name = "address")
    private String address;
    @Column(name = "needs")
    private String needs;
    @Column(name = "link_to_website")
    private String linkToWebsite;
}
