/******************************************************
 Cours:   LOG121
 Session: A2020
 Groupe:  1
 Projet: Laboratoire #2
 √âtudiant(e)s: Pierre A Abdelli et Michael Couet
 Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
 Nom du fichier: BuncoPlus.java
 Date cr√©√©: 2020-10-23
 Date dern. modif. 2020-10-30
 *******************************************************
 Historique des modifications
 *******************************************************
 2020-10-23
 2020-10-24
 2020-10-25
 2020-10-26
 2020-10-30
 *******************************************************/
package BuncoPlus;

import Framework.*;

import java.util.Scanner;

public class BuncoPlus extends Jeu {

	private final int NBDES = 3;
	private final int NBTOURSMAX = 6;
	private int scoreTour = 0;
	private ScoreBuncoPlus scoreBuncoPlus = new ScoreBuncoPlus();
	Scanner scanner = new Scanner(System.in);

	/**
	 * MÈthode qui initialise le jeu
	 */
	@Override
	public void initialize() {

		super.resetNbTour();
		initilizeDes();
		System.out.println("------- Bienvenue a BuncoPlus -------");
		System.out.print("Combien de joueurs etes vous ? ");
		int nbJoueurs = scanner.nextInt();
		initilizeJoueurs(nbJoueurs);

	}

	/**
	 * MÈthode qui execute le jeu
	 */
	public void run() {

		Iterateur iterJ = super.getCollectionJoueurs().getIterator();
		Boolean finPartie = false;

		while (iterJ.hasNext() && !finPartie) {
			System.out.println("Tour : " + super.getNbTour());
			Joueurs j = (Joueurs) iterJ.next();

			System.out.println("------ JOUEUR ----- [" + j.getNumeroJoueurs() + "] : Appuyer sur une touche "
					+ "pour jouer votre tour");
			scanner.nextLine();
			super.getCollectionDes().brasser();
			scoreTour = calculerScoreTour(this);
			j.addScoreJoueur(scoreTour);

			System.out.println("Le score total du joueur " + j.getNumeroJoueurs() + " == " + j.getScoreJoueur());
			finPartie = checkFinPartie(iterJ);
			iterJ = addTour(iterJ);

		}

	}

	/**
	 * MÈthode qui initialise les joueurs
	 * 
	 * @param nbJoueurs le nombre de joueur
	 */
	private void initilizeJoueurs(int nbJoueurs) {
		for (int i = 0; i < nbJoueurs; i++) {
			Joueurs joueur = new Joueurs(i + 1);
			super.addJoueurs(joueur);
		}
	}

	/**
	 * MÈthode qui initialise les dÈs
	 */
	private void initilizeDes() {
		for (int i = 0; i < NBDES; i++) {
			Des de = new Des();
			super.addDes(de);
		}
	}

	/**
	 * MÈthode qui verifie si la partie est fini
	 * 
	 * @param i
	 * @return true si la partie est fini et false si la parti n'est pas fini
	 */
	private boolean checkFinPartie(Iterateur i) {

		if (!i.hasNext() && super.getNbTour() >= NBTOURSMAX) {
			return true;
		}
		return false;
	}

	/**
	 * MÈthode qui ajoute un tour
	 * 
	 * @param i
	 * @return
	 */
	private Iterateur addTour(Iterateur i) {

		if (!i.hasNext()) {
			super.addTour();
			return super.getCollectionJoueurs().getIterator();
		}
		return i;
	}

	// Accesseur
	public ScoreBuncoPlus getScoreBuncoPlus() {
		return scoreBuncoPlus;
	}

	/**
	 * MÈthode qui calcule le vainqueur
	 */
	@Override
	public void calculerLeVainqueur() {
		calculerLeVainqueur(this);
	}

	/**
	 * MÈthode pour calculer le vainqueur.
	 */
	public void calculerLeVainqueur(Jeu jeu) {
		scoreBuncoPlus.calculerLeVainqueur(jeu);
	}

	// Accesseur
	public int calculerScoreTour(Jeu jeu) {
		return scoreBuncoPlus.calculerScoreTour(jeu);
	}
}
