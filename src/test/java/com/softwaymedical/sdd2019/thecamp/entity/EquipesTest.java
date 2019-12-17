package com.softwaymedical.sdd2019.thecamp.entity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;

import org.junit.Test;

public class EquipesTest {
	private static final Personne DEVELOPPEUR = new Personne("NOM", "PCPORTABLE", "PRENOM", "DEVELOPPEUR", "SQUAD", "SEXE", "VILLE");
	private static final Personne TECHLEAD = new Personne("NOM", "PCPORTABLE", "PRENOM", "TECHLEAD", "SQUAD", "SEXE", "VILLE");
	private static final Personne FEMME = new Personne("NOM", "PCPORTABLE", "PRENOM", "ROLE", "SQUAD", "F", "VILLE");
	private static final Personne HOMME = new Personne("NOM", "PCPORTABLE", "PRENOM", "ROLE", "SQUAD", "M", "VILLE");
	private static final Personne LYON = new Personne("NOM", "PCPORTABLE", "PRENOM", "ROLE", "SQUAD", "SEXE", "Lyon");
	private static final Personne MEYREUIL = new Personne("NOM", "PCPORTABLE", "PRENOM", "ROLE", "SQUAD", "SEXE", "Meyreuil");
	private static final Personne GAP = new Personne("NOM", "PCPORTABLE", "PRENOM", "ROLE", "GAP", "SEXE", "VILLE");
	private static final Personne RIS = new Personne("NOM", "PCPORTABLE", "PRENOM", "ROLE", "RIS", "SEXE", "VILLE");
	
	private static final Equipe EQUIPE_2TECHLEAD_4DEV = new Equipe(Arrays.asList(TECHLEAD, TECHLEAD, DEVELOPPEUR, DEVELOPPEUR, DEVELOPPEUR, DEVELOPPEUR));
	private static final Equipe EQUIPE_3TECHLEAD_3DEV = new Equipe(Arrays.asList(TECHLEAD, TECHLEAD, TECHLEAD, DEVELOPPEUR, DEVELOPPEUR, DEVELOPPEUR));
	private static final Equipe EQUIPE_2FEMMES_4HOMMES = new Equipe(Arrays.asList(FEMME, FEMME, HOMME, HOMME, HOMME, HOMME));
	private static final Equipe EQUIPE_4FEMMES_2HOMMES = new Equipe(Arrays.asList(FEMME, FEMME, FEMME, FEMME, HOMME, HOMME));
	private static final Equipe EQUIPE_2LYON_4MEYREUIL = new Equipe(Arrays.asList(LYON, LYON, MEYREUIL, MEYREUIL, MEYREUIL, MEYREUIL));
	private static final Equipe EQUIPE_4LYON_2MEYREUIL = new Equipe(Arrays.asList(LYON, LYON, LYON, LYON, MEYREUIL, MEYREUIL));
	private static final Equipe EQUIPE_4GAP_2RIS = new Equipe(Arrays.asList(GAP, GAP, GAP, GAP, RIS, RIS));
	private static final Equipe EQUIPE_2GAP_4RIS = new Equipe(Arrays.asList(GAP, GAP, RIS, RIS, RIS, RIS));

	@Test
	public void donneMoyenneTechleads() {
		Equipes equipes = new Equipes();
		equipes.getEquipes().addAll(Arrays.asList(EQUIPE_2TECHLEAD_4DEV, EQUIPE_3TECHLEAD_3DEV));
		assertThat(equipes.getMoyenneTechlead(), is(2.5F));
	}
	
	@Test
	public void donneMoyenneDeveloppeurs() {
		Equipes equipes = new Equipes();
		equipes.getEquipes().addAll(Arrays.asList(EQUIPE_2TECHLEAD_4DEV, EQUIPE_3TECHLEAD_3DEV));
		assertThat(equipes.getMoyenneDeveloppeurs(), is(3.5F));
	}
	
	@Test
	public void donneMoyenneFemmes() {
		Equipes equipes = new Equipes();
		equipes.getEquipes().addAll(Arrays.asList(EQUIPE_4FEMMES_2HOMMES, EQUIPE_2FEMMES_4HOMMES));
		assertThat(equipes.getMoyenneFemmes(), is(3.0F));
	}
	
	@Test
	public void donneMoyenneHommes() {
		Equipes equipes = new Equipes();
		equipes.getEquipes().addAll(Arrays.asList(EQUIPE_4FEMMES_2HOMMES, EQUIPE_2FEMMES_4HOMMES));
		assertThat(equipes.getMoyenneHommes(), is(3.0F));
	}
	
	@Test
	public void donneMoyenneLyon() {
		Equipes equipes = new Equipes();
		equipes.getEquipes().addAll(Arrays.asList(EQUIPE_4LYON_2MEYREUIL, EQUIPE_2LYON_4MEYREUIL));
		assertThat(equipes.getMoyenneLyon(), is(3.0F));
	}
	
	@Test
	public void donneMoyenneMeyreuil() {
		Equipes equipes = new Equipes();
		equipes.getEquipes().addAll(Arrays.asList(EQUIPE_4LYON_2MEYREUIL, EQUIPE_2LYON_4MEYREUIL));
		assertThat(equipes.getMoyenneMeyreuil(), is(3.0F));
	}
	
	@Test
	public void donneMoyenneSquad() {
		Equipes equipes = new Equipes();
		equipes.getEquipes().addAll(Arrays.asList(EQUIPE_4GAP_2RIS, EQUIPE_2GAP_4RIS));
		assertThat(equipes.getMoyenneSquad("GAP"), is(3.0F));
	}

}
