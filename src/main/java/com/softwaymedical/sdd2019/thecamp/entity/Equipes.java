package com.softwaymedical.sdd2019.thecamp.entity;

import java.util.List;

public class Equipes {
	
	private final List<Equipe> equipes;

	public Equipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}

	public List<Equipe> getEquipes() {
		return equipes;
	}	

}
