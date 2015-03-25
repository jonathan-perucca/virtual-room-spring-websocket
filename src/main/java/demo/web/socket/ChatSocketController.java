package demo.web.socket;

import demo.domain.Message;
import demo.repository.MessageRepository;
import demo.web.dto.MessageDTO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatSocketController {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private Mapper mapper;

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public MessageDTO pushMessage(MessageDTO messageDTO) {
        Message message = mapper.map(messageDTO, Message.class);
        messageRepository.save(message);
        return mapper.map(message, MessageDTO.class);
    }

}
