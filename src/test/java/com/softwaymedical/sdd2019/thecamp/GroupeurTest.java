package com.softwaymedical.sdd2019.thecamp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.softwaymedical.sdd2019.thecamp.entity.Participants;
import com.softwaymedical.sdd2019.thecamp.entity.Personne;

public class GroupeurTest {

	private static final String PRENOM = "Jean";
	private static final String NOM = "Bide";
	private static final String PC_PORTABLE = "OUI";
	private static final String LEADTECH = "TECHLEAD";
	private static final String DEVELOPPEUR = "DEVELOPPEUR";
	private static final String SQUAD_RIS = "RIS";
	private static final String SQUAD_GAP = "GAP";
	private static final String SQUAD_IMG = "IMG";
	private static final String SQUAD_ITO = "ITO";
	private static final String SEXE_M = "M";
	private static final String SEXE_F = "F";
	private static final String VILLE_LYON = "Lyon";
	private static final String VILLE_MEY = "Meyreuil";
	private static final String VILLE_PAR = "Paris";
	private static final Personne TECHLEAD_H_LYON_RIS = new Personne(NOM, PC_PORTABLE, PRENOM, LEADTECH, SQUAD_RIS, SEXE_M, VILLE_LYON);
	private static final Personne TECHLEAD_F_LYON_RIS = new Personne(NOM, PC_PORTABLE, PRENOM, LEADTECH, SQUAD_RIS, SEXE_F, VILLE_LYON);
	private static final Personne TECHLEAD_F_LYON_GAP = new Personne(NOM, PC_PORTABLE, PRENOM, LEADTECH, SQUAD_GAP, SEXE_F, VILLE_LYON);
	private static final Personne TECHLEAD_F_LYON_ITO = new Personne(NOM, PC_PORTABLE, PRENOM, LEADTECH, SQUAD_ITO, SEXE_F, VILLE_LYON);
	private static final Personne DEV_H_LYON_RIS = new Personne(NOM, PC_PORTABLE, PRENOM, DEVELOPPEUR, SQUAD_RIS, SEXE_M, VILLE_LYON);
	private static final Personne DEV_F_LYON_RIS = new Personne(NOM, PC_PORTABLE, PRENOM, DEVELOPPEUR, SQUAD_RIS, SEXE_F, VILLE_LYON);
	private static final Personne DEV_F_LYON_ITO = new Personne(NOM, PC_PORTABLE, PRENOM, DEVELOPPEUR, SQUAD_ITO, SEXE_F, VILLE_LYON);
	private static final Personne TECHLEAD_H_MEY_RIS = new Personne(NOM, PC_PORTABLE, PRENOM, LEADTECH, SQUAD_RIS, SEXE_M, VILLE_MEY);
	private static final Personne TECHLEAD_F_MEY_RIS = new Personne(NOM, PC_PORTABLE, PRENOM, LEADTECH, SQUAD_RIS, SEXE_F, VILLE_MEY);
	private static final Personne DEV_H_MEY_RIS = new Personne(NOM, PC_PORTABLE, PRENOM, DEVELOPPEUR, SQUAD_RIS, SEXE_M, VILLE_MEY);
	private static final Personne DEV_H_MEY_ITO = new Personne(NOM, PC_PORTABLE, PRENOM, DEVELOPPEUR, SQUAD_ITO, SEXE_M, VILLE_MEY);
	private static final Personne DEV_H_MEY_GAP = new Personne(NOM, PC_PORTABLE, PRENOM, DEVELOPPEUR, SQUAD_GAP, SEXE_M, VILLE_MEY);
	private static final Personne DEV_H_MEY_IMG = new Personne(NOM, PC_PORTABLE, PRENOM, DEVELOPPEUR, SQUAD_IMG, SEXE_M, VILLE_MEY);
	private static final Personne DEV_F_MEY_RIS = new Personne(NOM, PC_PORTABLE, PRENOM, DEVELOPPEUR, SQUAD_RIS, SEXE_F, VILLE_MEY);
	private static final Personne DEV_F_PAR_RIS = new Personne(NOM, PC_PORTABLE, PRENOM, DEVELOPPEUR, SQUAD_RIS, SEXE_F, VILLE_PAR);
	private static final Groupeur groupeur = new Groupeur();

	@Test
	public void groupeurCreeUneEquipeDeUnePersonne() {
		List<Personne> listeDesParticipants = new ArrayList<Personne>(1);
		listeDesParticipants.add(TECHLEAD_H_LYON_RIS);
		Participants participants = new Participants(1, listeDesParticipants);
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().size(), is(1)); // une seule equipe
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(0).getPersonnes().size(), is(1)); // une seule personne dans l'equipe
	}
	
	@Test
	public void groupeurCreeDeuxEquipesDeDeuxPersonnes(){
		List<Personne> listeDesParticipants = new ArrayList<Personne>(4);
		Participants participants = new Participants(2, listeDesParticipants);
		listeDesParticipants.add(TECHLEAD_H_LYON_RIS);
		listeDesParticipants.add(TECHLEAD_H_LYON_RIS);
		listeDesParticipants.add(TECHLEAD_H_LYON_RIS);
		listeDesParticipants.add(TECHLEAD_H_LYON_RIS);
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().size(), is(2)); // deux equipes
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(0).getPersonnes().size(), is(2)); // deux personnes dans l'equipe
	}
	
	@Test
	public void groupeurCreeEquipesAvecAuMoinsUnTechLead(){
		List<Personne> listeDesParticipants = new ArrayList<Personne>(12);
		Participants participants = new Participants(4, listeDesParticipants);
		listeDesParticipants.add(TECHLEAD_H_LYON_RIS);
		listeDesParticipants.add(TECHLEAD_H_LYON_RIS);
		listeDesParticipants.add(TECHLEAD_H_LYON_RIS);
		listeDesParticipants.add(TECHLEAD_H_LYON_RIS);
		listeDesParticipants.add(DEV_H_LYON_RIS);
		listeDesParticipants.add(DEV_H_LYON_RIS);
		listeDesParticipants.add(DEV_H_LYON_RIS);
		listeDesParticipants.add(DEV_H_LYON_RIS);
		listeDesParticipants.add(DEV_H_LYON_RIS);
		listeDesParticipants.add(DEV_H_LYON_RIS);
		listeDesParticipants.add(DEV_H_LYON_RIS);
		listeDesParticipants.add(DEV_H_LYON_RIS);
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(0).getNombreTechleads(), is(Matchers.greaterThanOrEqualTo(1)));
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(1).getNombreTechleads(), is(Matchers.greaterThanOrEqualTo(1)));
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(2).getNombreTechleads(), is(Matchers.greaterThanOrEqualTo(1)));
	}
	
	@Test
	public void groupeurCreeEquipesAvecAuMoinsUnTechLead2(){
		List<Personne> listeDesParticipants = new ArrayList<Personne>(12);
		Participants participants = new Participants(4, listeDesParticipants);
		listeDesParticipants.add(DEV_H_LYON_RIS);
		listeDesParticipants.add(DEV_H_LYON_RIS);
		listeDesParticipants.add(DEV_H_LYON_RIS);
		listeDesParticipants.add(DEV_H_LYON_RIS);
		listeDesParticipants.add(DEV_H_LYON_RIS);
		listeDesParticipants.add(DEV_H_LYON_RIS);
		listeDesParticipants.add(DEV_H_LYON_RIS);
		listeDesParticipants.add(DEV_H_LYON_RIS);
		listeDesParticipants.add(TECHLEAD_H_LYON_RIS);
		listeDesParticipants.add(TECHLEAD_H_LYON_RIS);
		listeDesParticipants.add(TECHLEAD_H_LYON_RIS);
		listeDesParticipants.add(TECHLEAD_H_LYON_RIS);
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(0).getNombreTechleads(), is(greaterThanOrEqualTo(1)));
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(1).getNombreTechleads(), is(greaterThanOrEqualTo(1)));
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(2).getNombreTechleads(), is(greaterThanOrEqualTo(1)));
	}
	
	@Test
	public void groupeurCreeEquipesAvecLeBonNombreDeFilles(){
		List<Personne> listeDesParticipants = new ArrayList<Personne>(40);
		for (int i = 0; i < 15; i++) {listeDesParticipants.add(TECHLEAD_F_LYON_RIS);}
		for (int i = 0; i < 25; i ++){listeDesParticipants.add(DEV_H_LYON_RIS);}
		Participants participants = new Participants(4, listeDesParticipants);
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(0).getNombreFemmes(), greaterThanOrEqualTo(1));
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(3).getNombreFemmes(), lessThanOrEqualTo(2));
	}
	
	@Test
	public void groupeurCreeEquipesAvecLeBonNombreDeFilles2(){
		List<Personne> listeDesParticipants = new ArrayList<Personne>(40);
		for (int i = 0; i < 5; i++) {listeDesParticipants.add(TECHLEAD_F_LYON_RIS);}
		for (int i = 0; i < 10; i++) {listeDesParticipants.add(DEV_F_LYON_RIS);}
		for (int i = 0; i < 25; i ++){listeDesParticipants.add(DEV_H_LYON_RIS);}
		Participants participants = new Participants(4, listeDesParticipants);
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(0).getNombreFemmes(), greaterThanOrEqualTo(1));
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(3).getNombreFemmes(), lessThanOrEqualTo(2));
	}
	
	@Test
	public void groupeurCreeEquipesRepartiesParAgences(){
		List<Personne> listeDesParticipants = new ArrayList<Personne>(40);
		for (int i = 0; i < 10; i++) {listeDesParticipants.add(TECHLEAD_F_MEY_RIS);}
		for (int i = 0; i < 10; i++) {listeDesParticipants.add(TECHLEAD_F_LYON_RIS);}
		for (int i = 0; i < 15; i ++){listeDesParticipants.add(DEV_H_MEY_RIS);}
		for (int i = 0; i < 5; i ++){listeDesParticipants.add(DEV_H_LYON_RIS);}
		Participants participants = new Participants(8, listeDesParticipants);
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(0).getNombreVille(VILLE_LYON), is(3)); //
	}
	
	@Test
	public void groupeurCreeEquipesRepartiesParSquad(){
		List<Personne> listeDesParticipants = new ArrayList<Personne>(10);
		for (int i = 0; i < 3; i++) {listeDesParticipants.add(TECHLEAD_F_MEY_RIS);}
		for (int i = 0; i < 1; i++) {listeDesParticipants.add(DEV_H_MEY_ITO);}
		for (int i = 0; i < 3; i ++){listeDesParticipants.add(DEV_H_MEY_GAP);}
		for (int i = 0; i < 3; i ++){listeDesParticipants.add(DEV_H_MEY_IMG);}
		Participants participants = new Participants(3, listeDesParticipants);
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(0).getNombreSquad(SQUAD_IMG), lessThanOrEqualTo(2));
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(0).getNombreSquad(SQUAD_ITO), lessThanOrEqualTo(2));
	}

}
