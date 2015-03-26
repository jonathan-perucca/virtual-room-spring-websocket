package demo.web.socket;

import java.util.List;

import demo.domain.Message;
import demo.repository.MessageRepository;
import demo.web.dto.MessageDTO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ChatSocketController {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private Mapper mapper;

	@Value("${vroom.messages.lasts}")
	private int MAX_NUMBER_PAGE;

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public MessageDTO pushMessage(MessageDTO messageDTO) {
        Message message = mapper.map(messageDTO, Message.class);
        messageRepository.save(message);
        return mapper.map(message, MessageDTO.class);
    }

	@SubscribeMapping("/messages")
	public List<Message> pushLastMessages() {
		return messageRepository.findAll(new PageRequest(0, MAX_NUMBER_PAGE)).getContent();
	}

}
