package com.softwaymedical.sdd2019.thecamp.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	private float getMoyenneVille(String ville) {
		int result = 0;
		for(Equipe equipe : equipes) {
			result += equipe.getNombreVille(ville);
		}
		return (float) result / equipes.size();
	}
	
	public float getMoyenneLyon() {
		return getMoyenneVille("Lyon");
	}
	
	public float getMoyenneMeyreuil() {
		return getMoyenneVille("Meyreuil");
	}

	public float getMoyenneSquad(String squad) {
		int result = 0;
		for(Equipe equipe : equipes) {
			result += equipe.getNombreSquad(squad);
		}
		return (float) result / equipes.size();
	}
	
	public Optional<Equipe> getEquipeIncomplete(int nbPersGroup) {
		return getEquipes().stream().filter(equipe -> equipe.getPersonnes().size() < nbPersGroup).findFirst();
	}

}
