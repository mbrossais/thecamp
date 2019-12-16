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
		
		
		for (int i = 0; i < nbEquipes; i++) {
			equipes.getEquipes().add(new Equipe());
		}
		
		List<Personne> reliquats = new ArrayList<Personne>();
		for (Personne participant : participants.getListeParticipant()) {
			if (participant.isTechLead()) {
				Optional<Equipe> equipeIncomplete = equipes.getEquipeSansTechLead();
				if (equipeIncomplete.isPresent()) {
					equipeIncomplete.get().getPersonnes().add(participant);
				} else {
					reliquats.add(participant);
				}
			} else {
				reliquats.add(participant);
			}
		}
		
		List<Personne> reliquats2 = new ArrayList<Personne>();
		for (Personne participant : reliquats) {
			int nbSexeMin = Math.round(participants.getNombreSexe(participant.getSexe()) / nbEquipes);
			int nbVilleMin = Math.round(participants.getNombreVille(participant.getVille()) / nbEquipes);
			
			Optional<Equipe> equipeIncomplete = equipes.getEquipeSexeVilleSquad(participant.getSexe(), nbSexeMin, participant.getVille(), nbVilleMin, participant.getSquad());
			if (equipeIncomplete.isPresent()) {
				equipeIncomplete.get().getPersonnes().add(participant);
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
	
}