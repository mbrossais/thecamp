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
	
	private float getMoyenneRole(String role) {
		int result = 0;
		for(Equipe equipe : equipes) {
			result += equipe.getNombreRole(role);
		}
		return (float) result / equipes.size();
	}
	
	public float getMoyenneDeveloppeurs() {
		return getMoyenneRole("DEVELOPPEUR");
	}
	
	public float getMoyenneTechlead() {
		return getMoyenneRole("TECHLEAD");
	}
	
	private float getMoyenneSexe(String sexe) {
		int result = 0;
		for(Equipe equipe : equipes) {
			result += equipe.getNombreSexe(sexe);
		}
		return (float) result / equipes.size();
	}
	
	public float getMoyenneFemmes() {
		return getMoyenneSexe("F");
	}
	
	public float getMoyenneHommes() {
		return getMoyenneSexe("H");
	}

}
