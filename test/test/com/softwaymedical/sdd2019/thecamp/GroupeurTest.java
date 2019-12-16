package test.com.softwaymedical.sdd2019.thecamp;

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

	@Test
	public void groupeurCreeUneEquipeDeUnePersonne() {
		Groupeur groupeur = new Groupeur();
		Personne personne = new Personne(NOM, PC_PORTABLE, PRENOM, LEADTECH, SQUAD_RIS, SEXE_M, VILLE_LYON);
		List<Personne> listeDesParticipants = new ArrayList<Personne>(1);
		listeDesParticipants.add(personne);
		Participants participants = new Participants(1, listeDesParticipants);
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().size(), is(1)); // une seule equipe
		assertThat(groupeur.faitDesGroupes(participants).getEquipes().get(0).getPersonnes().size(), is(1)); // une seule personne dans l'equipe
	}

}
