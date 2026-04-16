package com.assignment.whatsappchatbot.Controller;

import com.assignment.whatsappchatbot.dto.ChatRequest;
import com.assignment.whatsappchatbot.dto.ChatResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook")
public class ChatController {

    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

    @PostMapping
    public ChatResponse receiveMessage(@RequestBody ChatRequest request) {

        String message = request.getMessage().toLowerCase();

        String reply = switch (message) {
            case "hi" -> "Hello";
            case "bye" -> "Goodbye";
            default -> "I don't understand";
        };
        logger.info("Incoming message: {}", message);
        return new ChatResponse(reply);
    }

}