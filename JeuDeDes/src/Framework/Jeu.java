/******************************************************
 Cours:   LOG121
 Session: A2020
 Groupe:  1
 Projet: Laboratoire #2
 Ã‰tudiant(e)s: Pierre A Abdelli
 Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
 Nom du fichier: Jeu.java
 Date crÃ©Ã©: 2020-10-23
 Date dern. modif. 2020-10-23
 *******************************************************
 Historique des modifications
 *******************************************************
 2020-10-23
 *******************************************************/
package Framework;

public abstract class Jeu implements IScore {

	private int nbTour = 1;
	private final CollectionDes listDes = new CollectionDes();
	private final CollectionJoueurs listJoueurs = new CollectionJoueurs();

	abstract protected void initialize();

	abstract protected void run();

	abstract protected void calculerLeVainqueur();

	/**
	 * Constructeur
	 */
	public void jouer() {

		initialize();
		run();
		calculerLeVainqueur();

	}

	// Accesseurs
	public int getNbTour() {
		return this.nbTour;
	}

	// Accesseurs
	public CollectionJoueurs getCollectionJoueurs() {
		return this.listJoueurs;
	}

	// Accesseurs
	public CollectionDes getCollectionDes() {
		return this.listDes;
	}

	/**
	 * Méthode qui ajoute un tour
	 */
	public void addTour() {
		nbTour++;
	}

	/**
	 * Méthode qui réinitialise le nombre de tour
	 */
	public void resetNbTour() {
		nbTour = 1;
	}

	/**
	 * Méthode qui ajoute un dé a la liste de dé
	 * 
	 * @param de le dé a ajouter
	 */
	public void addDes(Des de) {
		listDes.addDes(de);
	}

	/**
	 * Méthode qui ajoute un joueur a la liste de joueurs
	 * 
	 * @param j le joueur a ajouter
	 */
	public void addJoueurs(Joueurs j) {
		listJoueurs.addJoueur(j);
	}

}
