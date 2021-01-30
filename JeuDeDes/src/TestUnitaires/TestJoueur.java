/******************************************************
Cours:   LOG121
Session: A2020
Groupe:  1
Projet: Laboratoire #2
Étudiant(e)s: Pierre A Abdelli et Michael Couet
Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
Nom du fichier: TestJeu.java
Date creation: 2020-10-23
Date dern. modif. 2020-10-26
*******************************************************
Historique des modifications
*******************************************************
2020-10-23
2020-10-25
2020-10-26
*******************************************************/

package TestUnitaires;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Framework.Joueurs;

public class TestJoueur {

	private Joueurs j1;
	private Joueurs j2;

	@Before
	public void faireAvant() {

		j1 = new Joueurs(1);
		j2 = new Joueurs(2);
		j1.addScoreJoueur(45);
		j2.addScoreJoueur(30);

	}

	/**
	 * M�thode qui test si le joueur est superieur
	 */
	@Test
	public void joueurSuperieurTest() {
		Assert.assertTrue(j2.compareTo(j1) == 1);
	}

	/**
	 * M�thode qui test si le joueur est inferieur
	 */
	@Test
	public void joueurInferieurTest() {
		Assert.assertTrue(j1.compareTo(j2) == -1);
	}

	/**
	 * M�thode qui verifie si les joueurs ont le m�me score
	 */
	@Test
	public void memeScoreTest() {
		j1.resetScoreJoueur();
		j2.resetScoreJoueur();
		j1.addScoreJoueur(10);
		j2.addScoreJoueur(10);
		Assert.assertTrue(j1.compareTo(j2) == 0);
	}

	/**
	 * M�thode qui test quand ses null
	 */
	@Test(expected = IllegalArgumentException.class)
	public void deNullTestJ() {
		j1.addScoreJoueur(-25);
		j1.compareTo(null);
	}

}
