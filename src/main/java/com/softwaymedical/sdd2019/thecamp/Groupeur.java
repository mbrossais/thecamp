package com.softwaymedical.sdd2019.thecamp;

import com.softwaymedical.sdd2019.thecamp.entity.Equipe;
import com.softwaymedical.sdd2019.thecamp.entity.Equipes;
import com.softwaymedical.sdd2019.thecamp.entity.Participants;
import com.softwaymedical.sdd2019.thecamp.entity.Personne;

public class Groupeur {
	
	public Equipes faitDesGroupes(Participants participants) {
		Equipes equipes = new Equipes();
		int nbEquipes = Math.round(participants.getListeParticipant().size() / participants.getNbPersGroup());
		for (int i = 0; i < nbEquipes; i++) {
			equipes.getEquipes().add(new Equipe());
		}
		int currentEquipeIndex = 0;
		for (Personne participant : participants.getListeParticipant()) {
			equipes.getEquipes().get(currentEquipeIndex).getPersonnes().add(participant);
			currentEquipeIndex = (currentEquipeIndex < nbEquipes - 1) ? currentEquipeIndex + 1 : 0;
		}
		return equipes;
	}
	

}