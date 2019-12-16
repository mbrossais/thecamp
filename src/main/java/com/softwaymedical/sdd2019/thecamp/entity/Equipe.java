package com.softwaymedical.sdd2019.thecamp.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Equipe {
	
	private final List<Personne> personnes;

	public Equipe() {
		this.personnes = new ArrayList<Personne>();
	}

	public List<Personne> getPersonnes() {
		return personnes;
	}

	public Equipe(List<Personne> personnes) {
		this.personnes = personnes;
	}

	public int getNombreRole(String role) {
		return personnes.stream().filter(p -> p.getRole().equals(role)).collect(Collectors.toList()).size();
	}
	
	public int getNombreDeveloppeurs() {
		return getNombreRole("DEVELOPPEUR");
	}
	
	public int getNombreTechleads() {
		return getNombreRole("TECHLEAD");
	}

	public int getNombreSexe(String sexe) {
		return personnes.stream().filter(p -> p.getSexe().equals(sexe)).collect(Collectors.toList()).size();
	}
	
	public int getNombreFemmes() {
		return getNombreSexe("F");
	}
	
	public int getNombreHommes() {
		return getNombreSexe("M");
	}

	public int getNombreVille(String ville) {
		return personnes.stream().filter(p -> p.getVille().equals(ville)).collect(Collectors.toList()).size();
	}
	
	public int getNombreLyon() {
		return getNombreVille("Lyon");
	}
	
	public int getNombreParis() {
		return getNombreVille("Paris");
	}

	public int getNombreSquad(String squad) {
		return personnes.stream().filter(p -> p.getSquad().equals(squad)).collect(Collectors.toList()).size();
	}

}
