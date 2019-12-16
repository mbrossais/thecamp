package com.softwaymedical.sdd2019.thecamp.entity;

import java.util.List;
import java.util.stream.Collectors;

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
	
	public int getNombreSexe(String sexe) {
		return listeParticipant.stream().filter(p -> p.getSexe().equals(sexe)).collect(Collectors.toList()).size();
	}
	

	public int getNombreVille(String ville) {
		return listeParticipant.stream().filter(p -> p.getVille().equals(ville)).collect(Collectors.toList()).size();
	}
	
	public int getNombreLyon() {
		return getNombreVille("Lyon");
	}
	
	public int getNombreParis() {
		return getNombreVille("Paris");
	}
	
	public int getNombreHommes() {
		return getNombreSexe("M");
	}
	
	public int getNombreFemmes() {
		return getNombreSexe("F");
	}
	
}
