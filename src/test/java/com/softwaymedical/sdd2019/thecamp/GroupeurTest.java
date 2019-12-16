package com.softwaymedical.sdd2019.thecamp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

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
	private static final String SEXE_M = "M";
	private static final String VILLE_LYON = "Lyon";
<<<<<<< HEAD
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
=======
	private static final Personne TECHLEAD_H_LYON = new Personne(NOM, PC_PORTABLE, PRENOM, LEADTECH, SQUAD_RIS, SEXE_M, VILLE_LYON);
	private static final Personne DEV_H_LYON = new Personne(NOM, PC_PORTABLE, PRENOM, DEVELOPPEUR, SQUAD_RIS, SEXE_M, VILLE_LYON);
>>>>>>> e297e2ad8c454ed4972210fb0ac774af54fb48c2
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
	public void groupeurCreeEquipesAvecAuMoinsUnTechLead(){
		List<Personne> listeDesParticipants = new ArrayList<Personne>(12);
		Participants participants = new Participants(4, listeDesParticipants);
		listeDesParticipants.add(TECHLEAD_H_LYON);
		listeDesParticipants.add(TECHLEAD_H_LYON);
		listeDesParticipants.add(TECHLEAD_H_LYON);
		listeDesParticipants.add(TECHLEAD_H_LYON);
		listeDesParticipants.add(DEV_H_LYON);
		listeDesParticipants.add(DEV_H_LYON);
		listeDesParticipants.add(DEV_H_LYON);
		listeDesParticipants.add(DEV_H_LYON);
		listeDesParticipants.add(DEV_H_LYON);
		listeDesParticipants.add(DEV_H_LYON);
		listeDesParticipants.add(DEV_H_LYON);
		listeDesParticipants.add(DEV_H_LYON);
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(0).getNombreTechleads(), is(Matchers.greaterThanOrEqualTo(1)));
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(1).getNombreTechleads(), is(Matchers.greaterThanOrEqualTo(1)));
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(2).getNombreTechleads(), is(Matchers.greaterThanOrEqualTo(1)));
	}
	@Test
	public void groupeurCreeEquipesAvecAuMoinsUnTechLead2(){
		List<Personne> listeDesParticipants = new ArrayList<Personne>(12);
		Participants participants = new Participants(4, listeDesParticipants);
		listeDesParticipants.add(DEV_H_LYON);
		listeDesParticipants.add(DEV_H_LYON);
		listeDesParticipants.add(DEV_H_LYON);
		listeDesParticipants.add(DEV_H_LYON);
		listeDesParticipants.add(DEV_H_LYON);
		listeDesParticipants.add(DEV_H_LYON);
		listeDesParticipants.add(DEV_H_LYON);
		listeDesParticipants.add(TECHLEAD_H_LYON);
		listeDesParticipants.add(TECHLEAD_H_LYON);
		listeDesParticipants.add(TECHLEAD_H_LYON);
		listeDesParticipants.add(TECHLEAD_H_LYON);
		listeDesParticipants.add(DEV_H_LYON);
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(0).getNombreTechleads(), is(Matchers.greaterThanOrEqualTo(1)));
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(1).getNombreTechleads(), is(Matchers.greaterThanOrEqualTo(1)));
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(2).getNombreTechleads(), is(Matchers.greaterThanOrEqualTo(1)));
	}
	
	
	
	
	@Test
	public void groupeurCreeEquipesRepartiesAuxLimites(){
		List<Personne> listeDesParticipants = new ArrayList<Personne>(100);
		Participants participants = new Participants(10, listeDesParticipants);
		for (int i = 0; i < 5; i++) {listeDesParticipants.add(TECHLEAD_F_LYON_GAP);}
		for (int i = 0; i < 5; i++) {listeDesParticipants.add(DEV_H_MEY_GAP);}
		for (int i = 0; i < 5; i++) {listeDesParticipants.add(DEV_F_PAR_RIS);}
		for (int i = 0; i < 10; i++) {listeDesParticipants.add(TECHLEAD_F_LYON_ITO);}
		for (int i = 0; i < 6; i++) {listeDesParticipants.add(TECHLEAD_H_MEY_RIS);}
		for (int i = 0; i < 29; i++) {listeDesParticipants.add(DEV_F_MEY_RIS);}
		for (int i = 0; i < 20; i++) {listeDesParticipants.add(DEV_H_MEY_ITO);}
		for (int i = 0; i < 20; i++) {listeDesParticipants.add(DEV_F_LYON_ITO);}
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(5).getNombreTechleads(), lessThanOrEqualTo(3));
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(5).getNombreTechleads(), greaterThanOrEqualTo(2));
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(5).getNombreSquad(SQUAD_RIS), is(4));
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(5).getNombreVille(VILLE_LYON), greaterThanOrEqualTo(3));
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(5).getNombreVille(VILLE_LYON), lessThanOrEqualTo(4));
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(5).getNombreVille(VILLE_MEY), is(4));
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(5).getNombreVille(VILLE_PAR), lessThanOrEqualTo(1));
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(5).getNombreSquad(SQUAD_ITO), is(5));
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(5).getNombreSquad(SQUAD_GAP), is(1));
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(5).getNombreFemmes(), greaterThanOrEqualTo(6));
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(5).getNombreFemmes(), lessThanOrEqualTo(7));
	}
	

}
