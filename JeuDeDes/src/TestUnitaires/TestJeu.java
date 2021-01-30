/******************************************************
 Cours:   LOG121
 Session: A2020
 Groupe:  1
 Projet: Laboratoire #2
 √âtudiant(e)s: Pierre A Abdelli et Michael Couet
 Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
 Nom du fichier: TestJeu.java
 Date cr√©√©: 2020-10-23
 Date dern. modif. 2020-10-26
 *******************************************************
 Historique des modifications
 *******************************************************
 2020-10-23
 2020-10-25
 2020-10-26
 *******************************************************/
package TestUnitaires;

import BuncoPlus.BuncoPlus;
import Framework.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class TestJeu {

	private Des de1 = new Des();
	private Des de2 = new Des();
	private Des de3 = new Des();
	private Joueurs j1 = new Joueurs(1);
	private Joueurs j2 = new Joueurs(2);
	private CollectionJoueurs collectionJoueurs = new CollectionJoueurs();
	private CollectionDes collectionDes = new CollectionDes();
	private BuncoPlus buncoPlus = new BuncoPlus();
	private int tour = 1;

	@Before
	public void faireAvant() {
		de1.setValeur(1);
		de2.setValeur(3);
		de3.setValeur(6);
		collectionJoueurs.addJoueur(j1);
		collectionJoueurs.addJoueur(j2);
		collectionDes.addDes(de1);
		collectionDes.addDes(de2);
		collectionDes.addDes(de3);
		buncoPlus.addJoueurs(j1);
		buncoPlus.addDes(de1);
		buncoPlus.addDes(de2);
		buncoPlus.addDes(de3);

	}

	/**
	 * MÈthode qui test le trie des joueurs
	 */
	@Test
	public void sortJoueur() {

		ArrayList<Joueurs> ListJoueurs = collectionJoueurs.getListJoueurs();
		Collections.sort(ListJoueurs);
		String listJoueur = "";
		Iterateur iterJoueur = collectionJoueurs.getIterator();

		while (iterJoueur.hasNext()) {
			Joueurs j = (Joueurs) iterJoueur.next();
			listJoueur += j.getNumeroJoueurs();
		}
		Assert.assertTrue(listJoueur.equals("12"));
	}

	/**
	 * MÈthode qui test le changement de tour
	 */
	@Test
	public void faireTour() {

		int scoreAjouter = 0;
		Iterateur iterDes = collectionDes.getIterator();

		while (iterDes.hasNext()) {
			Des de = (Des) iterDes.next();
			if (de.getValeur() == tour) {
				scoreAjouter += 1;
			}
		}

		Assert.assertTrue(scoreAjouter == 1);
	}

	/**
	 * MÈthode qui test si on a un bunco
	 */
	@Test
	public void buncoTest() {
		de1.setValeur(1);
		de2.setValeur(1);
		de3.setValeur(1);
		j1.resetScoreJoueur();
		Iterateur collIt = buncoPlus.getCollectionDes().getIterator();

		while (collIt.hasNext()) {
			Des d = (Des) collIt.next();
			d.setValeur(1);
		}

		int score = buncoPlus.getScoreBuncoPlus().calculerScoreTour(buncoPlus);

		Assert.assertEquals(21, score);

	}

	/**
	 * MÈthode qui test quand on a pas de point
	 */
	@Test
	public void noPointsTest() {

		j1.resetScoreJoueur();
		de1.setValeur(2);
		de2.setValeur(3);
		de3.setValeur(4);

		int score = buncoPlus.getScoreBuncoPlus().calculerScoreTour(buncoPlus);

		Assert.assertTrue(score == 0);

	}
}
