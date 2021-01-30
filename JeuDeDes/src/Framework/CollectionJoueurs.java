/******************************************************
 Cours:   LOG121
 Session: A2020
 Groupe:  1
 Projet: Laboratoire #2
 √âtudiant(e)s: Pierre A Abdelli
 Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
 Nom du fichier: CollectionJoueurs.java
 Date cr√©√©: 2020-10-23
 Date dern. modif. 2020-10-23
 *******************************************************
 Historique des modifications
 *******************************************************
 2020-10-23
 *******************************************************/
package Framework;

import java.util.ArrayList;

public class CollectionJoueurs implements Container {

	public ArrayList<Joueurs> ListJoueurs = new ArrayList<>();

	//Accesseur
	@Override
	public Iterateur getIterator() {
		return new JoueurIterateur();
	}

	//Accesseur
	public ArrayList<Joueurs> getListJoueurs() {
		return this.ListJoueurs;
	}

	/**
	 * MÈthode qui ajoute un joueur a la liste de joueurs
	 * @param joueur le joueur ‡ ajouter dans la liste
	 */
	public void addJoueur(Joueurs joueur) {
		ListJoueurs.add(joueur);
	}

	/**
	 * Classe interne qui creer une iterateur pour la collection de Joueurs
	 */
	private class JoueurIterateur implements Iterateur {

		int index;

		/**
		 * Methode qui retourne vrai ou faux si l'iterateur a un
		 * prochain objet dans sa liste
		 * @return boolean
		 */
		@Override
		public boolean hasNext() {
			if (index < ListJoueurs.size()) {
				return true;
			}
			return false;
		}

		/**
		 * Methode qui retourne le prochain objet dans la collection
		 * @return prochain objet de la collection
		 */
		public Object next() {
			if (this.hasNext()) {
				return ListJoueurs.get(index++);
			}
			return null;
		}

	}

}
