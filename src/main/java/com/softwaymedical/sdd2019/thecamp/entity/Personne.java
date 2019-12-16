package com.softwaymedical.sdd2019.thecamp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Personne {
	
	@JsonProperty("Nom")
	private final String nom;
	
	@JsonProperty("PC PORTABLE")
	private final String pcPortable;
	
	@JsonProperty("Prénom")
	private final String prenom;
	
	@JsonProperty("ROLE")
	private final String role;
	
	@JsonProperty("SQUAD")
	private final String squad;
	
	@JsonProperty("Sexe")
	private final String sexe;
	
	@JsonProperty("Ville")
	private final String ville;
	
	public Personne(String nom, String pcPortable, String prenom, String role, String squad, String sexe,
			String ville) {
		this.nom = nom;
		this.pcPortable = pcPortable;
		this.prenom = prenom;
		this.role = role;
		this.squad = squad;
		this.sexe = sexe;
		this.ville = ville;
	}

	public String getNom() {
		return nom;
	}

	public String getPcPortable() {
		return pcPortable;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getRole() {
		return role;
	}

	public String getSquad() {
		return squad;
	}

	public String getSexe() {
		return sexe;
	}

	public String getVille() {
		return ville;
	}
	
}
