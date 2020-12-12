package ua.lviv.lgs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.lviv.lgs.domain.Participant;
import ua.lviv.lgs.service.ParticipantService;

@Controller
public class ParticipantController {

	@Autowired
	private ParticipantService pService;

	@GetMapping("/")
	public String init(HttpServletRequest req) {
		req.setAttribute("participants", pService.findAllParticipants());
		req.setAttribute("mode", "PARTICIPANT_VIEW");
		return "index";
	}

	@GetMapping("/new")
	public String newParticipant(HttpServletRequest req) {
		req.setAttribute("mode", "PARTICIPANT_CREATE");
		return "index";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Participant participant, HttpServletRequest req) {
		pService.save(participant);
		req.setAttribute("participants", pService.findAllParticipants());
		req.setAttribute("mode", "PARTICIPANT_VIEW");
		return "index";
	}

	@GetMapping("/update")
	public String update(@RequestParam int id, HttpServletRequest req) {
		req.setAttribute("participant", pService.findOne(id));
		req.setAttribute("mode", "PARTICIPANT_EDIT");
		return "index";
	}

	@GetMapping("/delete")
	public String deleteParticipant(@RequestParam int id, HttpServletRequest req) {
		pService.delete(id);
		req.setAttribute("participantss", pService.findAllParticipants());
		req.setAttribute("mode", "PARTICIPANT_VIEW");
		return "index";
	}
}