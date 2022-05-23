package com.samsung.repository;

import com.samsung.domain.Message;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    @EntityGraph(attributePaths = {"chat"})
    List<Message> findAll();
    void deleteByChatId(int chat_id);
    List<Message> findByChatId(int id);
}
