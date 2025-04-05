package com.example.realtimechatappbackend.controller;

import com.example.realtimechatappbackend.entity.ChatMessage;
import com.example.realtimechatappbackend.repository.ChatMessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class MessageController {

    @Autowired
    private ChatMessageRepo messageRepo;

    @MessageMapping("/send") // From frontend to /app/send
    @SendTo("/topic/messages") // Send to all users
    public ChatMessage send(ChatMessage message) {
        message.setTimestamp(LocalDateTime.now());
        messageRepo.save(message); // ✅ Save message in DB
        return message; // Broadcast
    }
}

