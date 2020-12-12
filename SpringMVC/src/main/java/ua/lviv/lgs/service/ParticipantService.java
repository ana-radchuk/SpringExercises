package ua.lviv.lgs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.ParticipantRepo;
import ua.lviv.lgs.domain.Participant;

@Service
public class ParticipantService {
	
	@Autowired
	private ParticipantRepo pRepo;
	
	public List<Participant> findAllParticipants() {
		return pRepo.findAllParticipants();
	}
	
	public Participant findOne(Integer id) {
		return pRepo.findOne(id);
	}
	
	public void save(Participant participant) {
		pRepo.save(participant);
	}

	public void delete(Integer id) {
		pRepo.delete(id);
	}

}
