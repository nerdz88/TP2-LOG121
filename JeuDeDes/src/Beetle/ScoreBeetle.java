/******************************************************
 Cours:   LOG121
 Session: A2020
 Groupe:  1
 Projet: Laboratoire #2
 Étudiant(e)s: Mihai Armasaru
 Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
 Nom du fichier: CollectionDes.java
 Date créé: 2020-11-05
 Date dern. modif. 2020-11-09
 *******************************************************
 Historique des modifications
 *******************************************************
 2020-11-05
 2020-11-08
 2020-11-09
 *******************************************************/
package Beetle;

import java.util.ArrayList;
import java.util.Collections;

import Framework.*;

public class ScoreBeetle implements IScore {

	private static final int Vainqueur = 0;

	// body before everything else (head, leg, tail)
	// head before eyes and antennas
	private final int bodyDice = 1;
	private final int headDice = 2;
	private final int legDice = 3;
	private final int eyeDice = 4;
	private final int antennaDice = 5;
	private final int tailDice = 6;

	private int bodyCounter = 0;
	private int headCounter = 0;
	private int legCounter = 0;
	private int eyeCounter = 0;
	private int antennaCounter = 0;
	private int tailCounter = 0;

	private final int bodyMax = 1;
	private final int headMax = 1;
	private final int legMax = 6;
	private final int eyeMax = 2;
	private final int antennaMax = 2;
	private final int tailMax = 1;

	int partsCounter;

	private Boolean finBrasser = false;

	/**
	 * methode qui appel a brasser le Des et calculer le score
	 */
	public int calculerScoreTour(Jeu jeu) {
		return brasserDe(jeu);
	}

	/**
	 * Method qui calcul le vainqueur du jeu
	 */
	public void calculerLeVainqueur(Jeu jeu) {

		ArrayList<Joueurs> cj = jeu.getCollectionJoueurs().getListJoueurs();
		Collections.sort(cj);
		Joueurs gagnant = cj.get(Vainqueur);

		System.out.println("Le vainqueur est le joueur numero [" + gagnant.getNumeroJoueurs() + "] avec ===> "
				+ gagnant.getScoreJoueur() + " points");
	}

	/**
	 * Methode qui brasse les des et calcul le score du tour pour un joueur
	 * @param jeu l'instance du jeu dont on veut calculer le score
	 * @return le score du joueur pour ce tour
	 */
	private int brasserDe(Jeu jeu) {

		Iterateur iterde = jeu.getCollectionDes().getIterator();
		partsCounter = 0;
		finBrasser = false;

		while (iterde.hasNext() && !finBrasser) {
			Des de = (Des) iterde.next();
			System.out.println("Dice: " + "[" + de.getValeur() + "]");

			switch (de.getValeur()) {
			case bodyDice:
				if (bodyCounter != bodyMax) {
					bodyCounter++;
					partsCounter++;
					System.out.println("bodyCounter " + bodyCounter);

				} else {
					finBrasser = true;
				}
				break;
			case headDice:
				if (bodyCounter == bodyMax && headCounter != headMax) {
					headCounter++;
					partsCounter++;
					System.out.println("headCounter " + headCounter);

				} else {
					finBrasser = true;
				}
				break;
			case legDice:
				if (bodyCounter == bodyMax && legCounter != legMax) {
					legCounter++;
					partsCounter++;
					System.out.println("legCounter " + legCounter);

				} else {
					finBrasser = true;
				}
				break;
			case eyeDice:
				if (headCounter == headMax && eyeCounter != eyeMax) {
					eyeCounter++;
					partsCounter++;
					System.out.println("eyeCounter " + eyeCounter);

				} else {
					finBrasser = true;
				}
				break;
			case antennaDice:
				if (headCounter == headMax && antennaCounter != antennaMax) {
					antennaCounter++;
					partsCounter++;
					System.out.println("antennaCounter " + antennaCounter);

				} else {
					finBrasser = true;
				}
				break;
			case tailDice:
				if (bodyCounter == bodyMax && tailCounter != tailMax) {
					tailCounter++;
					partsCounter++;
					System.out.println("tailCounter " + tailCounter);

				} else {
					finBrasser = true;
				}
				break;
			}
			if (!iterde.hasNext()) {
				iterde = jeu.getCollectionDes().getIterator();
				jeu.getCollectionDes().brasser();
			}
		}
		return partsCounter;
	}
}
