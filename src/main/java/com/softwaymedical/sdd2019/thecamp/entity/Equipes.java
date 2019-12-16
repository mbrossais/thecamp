package com.softwaymedical.sdd2019.thecamp.entity;

import java.util.ArrayList;
import java.util.List;

public class Equipes {
	
	private final List<Equipe> equipes;

	public Equipes() {
		this.equipes = new ArrayList<Equipe>();
	}

	public List<Equipe> getEquipes() {
		return equipes;
	}
	
	public float getMoyenneRole(String role) {
		int result = 0;
		for(Equipe equipe : equipes) {
			result += equipe.getNombreRole(role);
		}
		return (float) result / equipes.size();
	}

}
