/******************************************************
 Cours:   LOG121
 Session: A2020
 Groupe:  1
 Projet: Laboratoire #2
 Étudiant(e)s: Pierre A Abdelli et Michael Couet
 Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
 Nom du fichier: Joueurs.java
 Date créé: 2020-10-23
 Date dern. modif. 2020-10-23
 *******************************************************
 Historique des modifications
 *******************************************************
 2020-10-23
 *******************************************************/
package Framework;

public class Joueurs implements Comparable<Object> {

	private int numeroJoueurs = 1;
	private int scoreJoueur = 0;

	/**
	 * Constructeur par valeur
	 * @param numeroJoueurs le numero du joueur
	 */
	public Joueurs(int numeroJoueurs) {
		this.numeroJoueurs = numeroJoueurs;
	}

	// Accesseurs
	public int getNumeroJoueurs() {
		return this.numeroJoueurs;
	}

	public int getScoreJoueur() {
		return this.scoreJoueur;
	}

	/**
	 * M�thode qui permet de mettre le score du joueur a 0
	 */
	public void resetScoreJoueur() {
		scoreJoueur = 0;
	}

	// Mutateur
	public void addScoreJoueur(int scoreJoueur) {
		this.scoreJoueur += scoreJoueur;
	}

	public void setScoreJoueur(int scoreJoueur) { this.scoreJoueur = scoreJoueur;}
	/**
	 * Methode qui compare deux Joueurs
	 * @param o objet de type joueur
	 * @return int selon si le joueur est plus petit, plus grand ou egal
	 */
	@Override
	public int compareTo(Object o) {

		Joueurs j = (Joueurs) o;
		if (j == null) {
			throw new IllegalArgumentException();
		} else if (scoreJoueur > j.getScoreJoueur()) {
			return -1;
		} else if (scoreJoueur == j.getScoreJoueur()) {
			return 0;
		} else {
			return 1;
		}
	}
}
