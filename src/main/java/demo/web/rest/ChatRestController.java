package demo.web.rest;

import demo.domain.Message;
import demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/message")
public class ChatRestController {

    @Autowired
    private MessageRepository messageRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Message> pushLastMessages() {
        return messageRepository.findAll(new PageRequest(0, 10)).getContent();
    }
}
