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

import Framework.*;

import java.util.*;

public class Beetle extends Jeu {

	//Variables de classe
	private final int NBDES = 1;
	private final int maxBodyParts = 13;
	private ScoreBeetle scoreBeetle = new ScoreBeetle();
	Scanner scanner = new Scanner(System.in);
	private int tracker = 0;
	private boolean filled = false;
	int remainder = 0;

	/*
	Constructeur vide
	 */
	public Beetle() {

	}

	/**
	 * Methode qui initialize les parametres de base du jeu
	 */
	@Override
	public void initialize() {

		super.resetNbTour();

		System.out.println("------- Bienvenue a Beetle -------");
		System.out.print("Combien de joueurs etes vous ? ");
		int nbJoueurs = scanner.nextInt();
		initilizeJoueurs(nbJoueurs);
	}

	/**
	 * Methode qui roule le jeu
	 */
	protected void run() {
		Iterateur iterJ = super.getCollectionJoueurs().getIterator();
		Boolean finPartie = false;
		ScoreBeetle instance[] = new ScoreBeetle[super.getCollectionJoueurs().ListJoueurs.size()];
		Jeu jeux[] = new Jeu[super.getCollectionJoueurs().ListJoueurs.size()];

		while (iterJ.hasNext() && !finPartie) {
			Joueurs j = (Joueurs) iterJ.next();

			System.out.println("------ JOUEUR ----- [" + j.getNumeroJoueurs() + "] : Appuyer sur une touche "
					+ "pour jouer votre tour");
			System.out.println();
			scanner.nextLine();
			super.getCollectionDes().brasser();

			while (filled == false) {
				instance[remainder] = new ScoreBeetle();
				jeux[remainder] = new Beetle();
				initilizeDes(jeux[remainder]);
				tracker++;
				remainder = tracker % (super.getCollectionJoueurs().ListJoueurs.size());
				if (remainder == 0) {
					filled = true;
					tracker = 0;
				}
			}
			remainder = tracker % (super.getCollectionJoueurs().ListJoueurs.size());

			j.addScoreJoueur(instance[remainder].calculerScoreTour(jeux[remainder]));
			System.out.println("Player " + j.getNumeroJoueurs() + " has " + j.getScoreJoueur() + "\n");
			tracker++;

			finPartie = checkFinPartie(j);

			iterJ = addTour(iterJ);
		}
	}

	/**
	 * Methode qui instancie le nb de joueurs du jeu
	 * @param nbJoueurs le nombre de joueurs a instancie
	 */
	private void initilizeJoueurs(int nbJoueurs) {
		for (int i = 0; i < nbJoueurs; i++) {
			Joueurs joueur = new Joueurs(i + 1);
			super.addJoueurs(joueur);
		}
	}

	/**
	 * Methode qui instancie le nb de des du jeu
	 * @param jeu le jeu dans lequel on veut ajouer le nb de Des du jeu
	 */
	private void initilizeDes(Jeu jeu) {
		for (int i = 0; i < NBDES; i++) {
			Des de = new Des();
			jeu.addDes(de);
		}
	}

	/**
	 * Methode qui ajoute une tour si nous avons parcourue tout la liste de joueur
	 * @param i l'iterateur de la liste de joueur
	 * @return l'iterateur en parametre ou un nouvel iterateur si nous avons atteint la fin
	 */
	private Iterateur addTour(Iterateur i) {
		if (!i.hasNext()) {
			super.addTour();
			System.out.println("NB TOUR ------ ++++++ " + super.getNbTour());
			return super.getCollectionJoueurs().getIterator();
		}
		return i;
	}

	/**
	 * Methode qui verifie si nous avons terminer la partie
	 * @param joueur Le joueur dont on veut verifier le score
	 * @return true or false
	 */
	private boolean checkFinPartie(Joueurs joueur) {

		if (joueur.getScoreJoueur() >= maxBodyParts) {
			return true;
		}

		return false;
	}

	/**
	 * retourne l'instance de scoreBeetle utiliser
	 * @return
	 */
	public ScoreBeetle getScoreBeetle() {
		return scoreBeetle;
	}

	/**
	 * Methode qui calcule appel la methode qui calcule la vainqueur
	 */
	@Override
	protected void calculerLeVainqueur() {
		calculerLeVainqueur(this);
	}

	/**
	 * Methode qui calcule le vainqueur du jeu passer en parametre
	 * @param jeu le jeu dont on veut calculer le vainqueur
	 */
	public void calculerLeVainqueur(Jeu jeu) {
		scoreBeetle.calculerLeVainqueur(jeu);

	}

	/**
	 * Methode qui calcul le score d'un tour pour un joueur
	 * @param jeu Le jeu dont on veut calculer le score du tour
	 * @return le score du joueur
	 */
	public int calculerScoreTour(Jeu jeu) {
		return scoreBeetle.calculerScoreTour(jeu);
	}
}
