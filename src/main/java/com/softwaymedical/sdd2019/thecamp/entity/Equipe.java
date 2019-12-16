package com.softwaymedical.sdd2019.thecamp.entity;

import java.util.List;
import java.util.stream.Collectors;

public class Equipe {
	
	private List<Personne> personnes;

	public Equipe(List<Personne> personnes) {
		this.personnes = personnes;
	}

	public int getNombreRole(String role) {
		return personnes.stream().filter(p -> p.getRole().equals(role)).collect(Collectors.toList()).size();
	}

}
