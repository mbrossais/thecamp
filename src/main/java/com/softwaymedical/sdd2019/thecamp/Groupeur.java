package com.softwaymedical.sdd2019.thecamp;

import java.util.ArrayList;
import java.util.List;

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
		List<Personne> reliquats = new ArrayList();
		for (Personne participant : participants.getListeParticipant()) {
			if (isParticipantEligibile(participants, participant, equipes.getEquipes().get(currentEquipeIndex))) {
				equipes.getEquipes().get(currentEquipeIndex).getPersonnes().add(participant);
				currentEquipeIndex = (currentEquipeIndex < nbEquipes - 1) ? currentEquipeIndex + 1 : 0;	
			} else {
				reliquats.add(participant);	
			}
		}
		
		
		currentEquipeIndex = 0;
		for (Personne participant : reliquats) {
			equipes.getEquipes().get(currentEquipeIndex).getPersonnes().add(participant);
			currentEquipeIndex = (currentEquipeIndex < nbEquipes - 1) ? currentEquipeIndex + 1 : 0;
		}
		
		return equipes;
	}
	
	public boolean isParticipantEligibile(Participants participants, Personne participant, Equipe equipe) {
		int nbEquipes = Math.round(participants.getListeParticipant().size() / participants.getNbPersGroup());
		int nbFemmesMin = Math.round(participants.getNombreFemmes() / nbEquipes);
		int nbHommesMin = Math.round(participants.getNombreHommes() / nbEquipes);
		
		if (participant.isTechLead()) {
			int nbTechLeads = equipe.getNombreTechleads();
			if (nbTechLeads == 0) {
				return true;
			}
		}
		
		if (participant.isFemme()) {
			if (equipe.getNombreFemmes() < nbFemmesMin) {
				return true;
			}
		}
		
		
		if (participant.isHomme()) {
			if (equipe.getNombreHommes() < nbHommesMin) {
				return true;
			}
		}
		return false;
	}
	
}