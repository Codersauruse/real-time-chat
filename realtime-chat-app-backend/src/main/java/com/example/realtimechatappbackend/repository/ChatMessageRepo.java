package com.example.realtimechatappbackend.repository;

import com.example.realtimechatappbackend.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface ChatMessageRepo extends JpaRepository<ChatMessage,Long> {
}
