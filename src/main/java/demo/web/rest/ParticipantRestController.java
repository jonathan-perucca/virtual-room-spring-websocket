package demo.web.rest;

import demo.domain.Participant;
import demo.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/participant")
public class ParticipantRestController {

    @Autowired
    private ParticipantRepository participantRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Participant> participants() {
        return participantRepository.findAll();
    }
}
