package demo.web.socket;

import java.util.List;

import demo.domain.Participant;
import demo.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ParticipantSocketController {

    @Autowired
    private ParticipantRepository participantRepository;

    @MessageMapping("/participant")
    @SendTo("/topic/participants")
    public Participant pushParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

	@SubscribeMapping("/participants")
	public List<Participant> participants() {
		return participantRepository.findAll();
	}
}
