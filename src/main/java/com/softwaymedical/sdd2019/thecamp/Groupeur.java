package com.softwaymedical.sdd2019.thecamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.softwaymedical.sdd2019.thecamp.entity.Equipe;
import com.softwaymedical.sdd2019.thecamp.entity.Equipes;
import com.softwaymedical.sdd2019.thecamp.entity.Participants;
import com.softwaymedical.sdd2019.thecamp.entity.Personne;

public class Groupeur {
	
	public Equipes faitDesGroupes(Participants participants) {
		Equipes equipes = new Equipes();
		int nbEquipes = Math.round(participants.getListeParticipant().size() / participants.getNbPersGroup());
		
		// init des équipes
		for (int i = 0; i < nbEquipes; i++) {
			equipes.getEquipes().add(new Equipe());
		}
		
		// attribution 1 lead tech par équipe
		int currentEquipeIndex = 0;
		List<Personne> reliquats = new ArrayList<Personne>();
		for (Personne participant : participants.getListeParticipant()) {
			if (isParticipantEligibileRole(participant, equipes.getEquipes().get(currentEquipeIndex))) {
				equipes.getEquipes().get(currentEquipeIndex).getPersonnes().add(participant);
				currentEquipeIndex = (currentEquipeIndex < nbEquipes - 1) ? currentEquipeIndex + 1 : 0;	
			} else {
				reliquats.add(participant);	
			}
		}
		
		// attribution min hommes et femmes par équipe
		currentEquipeIndex = 0;
		List<Personne> reliquats2 = new ArrayList<Personne>();
		for (Personne participant : reliquats) {
			if (isParticipantEligibileSexe(participants, participant, equipes.getEquipes().get(currentEquipeIndex))) {
				equipes.getEquipes().get(currentEquipeIndex).getPersonnes().add(participant);
				currentEquipeIndex = (currentEquipeIndex < nbEquipes - 1) ? currentEquipeIndex + 1 : 0;	
			} else {
				reliquats2.add(participant);	
			}
		}
		
		// attribution des autres participants
		List<Personne> reliquats3 = new ArrayList<Personne>();
		for (Personne participant : reliquats2) {
			Optional<Equipe> equipeIncomplete = equipes.getEquipeIncomplete(participants.getNbPersGroup());
			if (equipeIncomplete.isPresent()) {
				equipeIncomplete.get().getPersonnes().add(participant);
			} else {
				reliquats3.add(participant);
			}
		}
		
		for (int i = 0; i < reliquats3.size(); i++) {
			equipes.getEquipes().get(i).getPersonnes().add(reliquats3.get(i));
		}
		
		return equipes;
	}
	
	public boolean isParticipantEligibileRole(Personne participant, Equipe equipe) {
		if (participant.isTechLead()) {
			int nbTechLeads = equipe.getNombreTechleads();
			if (nbTechLeads == 0) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isParticipantEligibileSexe(Participants participants, Personne participant, Equipe equipe) {
		int nbEquipes = Math.round(participants.getListeParticipant().size() / participants.getNbPersGroup());
		int nbFemmesMin = Math.round(participants.getNombreFemmes() / nbEquipes);
		//int nbHommesMin = Math.round(participants.getNombreHommes() / nbEquipes);
		
		int nbLyonMin = Math.round(participants.getNombreLyon() / nbEquipes);
		int nbParisMin = Math.round(participants.getNombreParis() / nbEquipes);
		
		if(equipe.getNombreSquad(participant.getSquad()) >= 2) {
			return false;
		}
		
		if (participant.isFemme()) {
			if (equipe.getNombreFemmes() < nbFemmesMin) {
				return true;
			}
		}
		
		
		if (participant.isParis()) {
			if (equipe.getNombreParis() < nbParisMin) {
				return true;
			}
		}
		
		if (participant.isLyon()) {
			if (equipe.getNombreLyon() < nbLyonMin) {
				return true;
			}
		}
		
//		if (participant.isHomme()) {
//			if (equipe.getNombreHommes() < nbHommesMin) {
//				return true;
//			}
//		}
		return false;
	}
	
}