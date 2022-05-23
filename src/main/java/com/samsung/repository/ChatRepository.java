package com.samsung.repository;

import com.samsung.domain.Chat;
import com.samsung.domain.Organization;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Integer> {
    @EntityGraph(attributePaths = {"person", "organization"})
    List<Chat> findAll();
    Chat findByPersonIdAndOrganizationId(int perId, int orgId);
    Chat findById(int id);
}
