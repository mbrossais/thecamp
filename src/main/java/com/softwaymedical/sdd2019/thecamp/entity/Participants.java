package com.softwaymedical.sdd2019.thecamp.entity;

import java.util.List;

public class Participants {
	
	private final int nbPersGroup;
	private final List<Personne> listeParticipant;
	
	public Participants(int nbPersGroup, List<Personne> listeParticipant) {
		this.nbPersGroup = nbPersGroup;
		this.listeParticipant = listeParticipant;
	}

	public int getNbPersGroup() {
		return nbPersGroup;
	}

	public List<Personne> getListeParticipant() {
		return listeParticipant;
	}
	
}
