package com.softwaymedical.sdd2019.thecamp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.softwaymedical.sdd2019.thecamp.Groupeur;
import com.softwaymedical.sdd2019.thecamp.entity.Participants;
import com.softwaymedical.sdd2019.thecamp.entity.Personne;

public class GroupeurTest {

	private static final String PRENOM = "Jean";
	private static final String NOM = "Bide";
	private static final String PC_PORTABLE = "OUI";
	private static final String LEADTECH = "TECHLEAD";
	private static final String SQUAD_RIS = "RIS";
	private static final String SEXE_M = "M";
	private static final String VILLE_LYON = "Lyon";
	private static final Personne TECHLEAD_H_LYON = new Personne(NOM, PC_PORTABLE, PRENOM, LEADTECH, SQUAD_RIS, SEXE_M, VILLE_LYON);
	private static final Groupeur groupeur = new Groupeur();

	@Test
	public void groupeurCreeUneEquipeDeUnePersonne() {
		List<Personne> listeDesParticipants = new ArrayList<Personne>(1);
		listeDesParticipants.add(TECHLEAD_H_LYON);
		Participants participants = new Participants(1, listeDesParticipants);
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().size(), is(1)); // une seule equipe
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(0).getPersonnes().size(), is(1)); // une seule personne dans l'equipe
	}
	
	@Test
	public void groupeurCreeDeuxEquipesDeDeuxPersonnes(){
		List<Personne> listeDesParticipants = new ArrayList<Personne>(4);
		Participants participants = new Participants(2, listeDesParticipants);
		listeDesParticipants.add(TECHLEAD_H_LYON);
		listeDesParticipants.add(TECHLEAD_H_LYON);
		listeDesParticipants.add(TECHLEAD_H_LYON);
		listeDesParticipants.add(TECHLEAD_H_LYON);
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().size(), is(2)); // deux equipes
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(0).getPersonnes().size(), is(2)); // deux personnes dans l'equipe
	}
	
	@Test
	public void groupeurCreeUneEquipeDeDeuxPersonnesEtUneEquipeDeTroisPersonnes(){
		List<Personne> listeDesParticipants = new ArrayList<Personne>(4);
		Participants participants = new Participants(2, listeDesParticipants);
		listeDesParticipants.add(TECHLEAD_H_LYON);
		listeDesParticipants.add(TECHLEAD_H_LYON);
		listeDesParticipants.add(TECHLEAD_H_LYON);
		listeDesParticipants.add(TECHLEAD_H_LYON);
		listeDesParticipants.add(TECHLEAD_H_LYON);
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().size(), is(2)); // deux equipes
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(0).getPersonnes().size(), is(2)); // deux personnes dans l'equipe
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(1).getPersonnes().size(), is(3)); // trois personnes dans l'equipe
	}
	
	
	
	

}
