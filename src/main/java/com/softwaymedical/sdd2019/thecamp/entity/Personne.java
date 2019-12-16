package com.softwaymedical.sdd2019.thecamp.entity;

public class Personne {
	
	private final String nom;
	private final String pcPortable;
	private final String prenom;
	private final String role;
	private final String squad;
	private final String sexe;
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
