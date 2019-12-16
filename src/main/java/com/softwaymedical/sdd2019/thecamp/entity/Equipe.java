package com.softwaymedical.sdd2019.thecamp.entity;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
	
	private final List<Personne> personnes;

	public Equipe() {
		this.personnes = new ArrayList<Personne>();
	}

	public List<Personne> getPersonnes() {
		return personnes;
	}

}
