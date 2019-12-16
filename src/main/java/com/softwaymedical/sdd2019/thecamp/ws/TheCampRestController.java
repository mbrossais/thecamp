package com.softwaymedical.sdd2019.thecamp.ws;

import java.util.Collections;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softwaymedical.sdd2019.thecamp.Groupeur;
import com.softwaymedical.sdd2019.thecamp.entity.Equipes;
import com.softwaymedical.sdd2019.thecamp.entity.Participants;

@RestController
@RequestMapping("/thecamp")
public class TheCampRestController {

	@PostMapping("/equipes")
	public Equipes equipes(@RequestBody Participants participants) {
		Collections.shuffle(participants.getListeParticipant());
		return new Groupeur().faitDesGroupes(participants);
	}

}