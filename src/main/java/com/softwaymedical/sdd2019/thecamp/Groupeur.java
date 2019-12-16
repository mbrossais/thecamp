package com.softwaymedical.sdd2019.thecamp;

import com.softwaymedical.sdd2019.thecamp.entity.Equipe;
import com.softwaymedical.sdd2019.thecamp.entity.Equipes;
import com.softwaymedical.sdd2019.thecamp.entity.Participants;

public class Groupeur {
	
	public Equipes faitDesGroupes(Participants participants) {
		Equipes equipes = new Equipes();
		Equipe equipe = new Equipe();
		participants.getListeParticipant().stream().forEach(participant -> {
			equipe.getPersonnes().add(participant);
		});
		equipes.getEquipes().add(equipe);
		return equipes;
	}

}
