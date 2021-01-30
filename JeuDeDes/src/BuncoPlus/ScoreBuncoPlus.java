/******************************************************
 Cours:   LOG121
 Session: A2020
 Groupe:  1
 Projet: Laboratoire #2
 Ã‰tudiant(e)s: Pierre A Abdelli et Michael Couet
 Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
 Nom du fichier: ScoreBuncoPlus.java
 Date crÃ©Ã©: 2020-10-23
 Date dern. modif. 2020-10-30
 *******************************************************
 Historique des modifications
 *******************************************************
 2020-10-23
 2020-10-24
 2020-10-25
 2020-10-26
 2020-10-30
 2020-11-02
 *******************************************************/

package BuncoPlus;

import Framework.*;

import java.util.ArrayList;
import java.util.Collections;

public class ScoreBuncoPlus implements IScore {

	private static final int Vainqueur = 0;
	private final int BUNCO = 21;
	private Boolean finBrasser = false;

	/**
	 * Méthode qui calcule le score du tour.
	 */
	public int calculerScoreTour(Jeu jeu) {

		return brasserDe(jeu);

	}

	/**
	 * Méthode qui calcule le vainqueur
	 * @param jeu 
	 */
	public void calculerLeVainqueur(Jeu jeu) {

		ArrayList<Joueurs> cj = jeu.getCollectionJoueurs().getListJoueurs();
		Collections.sort(cj);
		Joueurs gagnant = cj.get(Vainqueur);

		System.out.println("Le vainqueur est le joueur numero [" + gagnant.getNumeroJoueurs() + "] avec ===> "
				+ gagnant.getScoreJoueur() + " points");
	}

	/**
	 * Méthode qui verifie les conditions pour calculer le score.
	 * @param jeu
	 * @return le score du tour
	 */
	private int brasserDe(Jeu jeu) {

		Iterateur iterde = jeu.getCollectionDes().getIterator();
		int score = 0;
		int scoreTour = 0;
		finBrasser = false;

		while (iterde.hasNext() && !finBrasser) {

			Des de = (Des) iterde.next();
			System.out.println(de.getValeur());

			if (de.getValeur() == jeu.getNbTour()) {
				score++;
			}

			if (!iterde.hasNext()) {
				scoreTour += scoreTour(score,jeu);
				score = 0;
				iterde = jeu.getCollectionDes().getIterator();
				jeu.getCollectionDes().brasser();
			}
		}
		return scoreTour;
	}

	/**
	 * Méthode qui retourne le score du tour selon le scoreDes reçu.
	 * @param scoreDes le score du dé
	 * @param jeu
	 * @return le score 
	 */
	private int scoreTour(int scoreDes, Jeu jeu) {

		CollectionDes collDes = jeu.getCollectionDes();

		if(collDes.tousPareil() && scoreDes == 0) scoreDes = 5;

		switch (scoreDes) {
		case 3:
			finBrasser = true;
			System.out.println("WOW BUNCO BRAVO ! ");
			return BUNCO;
		case 0:
			finBrasser = true;
			System.out.println("Fin de tour pour joueur  vous avez brasser 0");
			return 0;
		default:
			System.out.println("Un autre lancer" + " Score ajouter : " + scoreDes);
			return scoreDes;
		}
	}

}
