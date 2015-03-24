package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private MessageRepository messageRepository;

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public ChatMessage pushMessage(ChatMessage chatMessage) {
        return messageRepository.save(chatMessage);
    }

}
