package ua.lviv.lgs.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import ua.lviv.lgs.domain.Participant;
import ua.lviv.lgs.domain.ParticipantLevel;

@Repository
public class ParticipantRepo {	
	private List<Participant> participants = new ArrayList<>();
	
	public void init() {
		Participant p1 = new Participant();
		p1.setId(1);
		p1.setName("Ivan");
		p1.setEmail("ivan@email.com");
		p1.setLevel(ParticipantLevel.L1);
		p1.setPrimarySkill("designer");
		
		Participant p2 = new Participant();
		p2.setId(2);
		p2.setName("Anna");
		p2.setEmail("anna@email.com");
		p2.setLevel(ParticipantLevel.L5);
		p2.setPrimarySkill("manager");
		
		Participant p3 = new Participant();
		p3.setId(3);
		p3.setName("Roman");
		p3.setEmail("roman@email.com");
		p3.setLevel(ParticipantLevel.L2);
		p3.setPrimarySkill("programmer");
		
		Participant p4 = new Participant();
		p4.setId(4);
		p4.setName("Iryna");
		p4.setEmail("iryna@email.com");
		p4.setLevel(ParticipantLevel.L2);
		p4.setPrimarySkill("artist");
		
		Participant p5 = new Participant();
		p5.setId(5);
		p5.setName("Taras");
		p5.setEmail("taras@email.com");
		p5.setLevel(ParticipantLevel.L3);
		p5.setPrimarySkill("sound engineer");
		
		Participant p6 = new Participant();
		p6.setId(6);
		p6.setName("Halyna");
		p6.setEmail("halyna@email.com");
		p6.setLevel(ParticipantLevel.L4);
		p6.setPrimarySkill("QA");
		
		participants.add(p1);
		participants.add(p2);
		participants.add(p3);
		participants.add(p4);
		participants.add(p5);
		participants.add(p6);
	}
	
	public List<Participant> findAllParticipants() {
		return participants;
	}
	
	public Participant findOne(Integer id) {
		return participants.stream()
				.filter(participant -> participant.getId() == id)
				.findFirst().orElse(null);
	}
	
	public void save(Participant participant) {
		Participant pToUpdate = null;
		
		if(participant.getId() != null) {
			pToUpdate = findOne(participant.getId());
			int participantIndex = participants.indexOf(pToUpdate);
			pToUpdate.setName(participant.getName());
			pToUpdate.setEmail(participant.getEmail());
			pToUpdate.setLevel(participant.getLevel());
			pToUpdate.setPrimarySkill(participant.getPrimarySkill());
			participants.set(participantIndex, pToUpdate);
		} else {
			// save
			participant.setId(participants.size()+1);
			participants.add(participant);
		}
	}
	
	public void delete(Integer id) {
		Iterator<Participant> iter = participants.iterator();
		while(iter.hasNext()) {
			if(iter.next().getId() == id) {
				iter.remove();
			}
		}
	}

}
