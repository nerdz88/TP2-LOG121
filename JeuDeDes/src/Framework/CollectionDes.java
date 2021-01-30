/******************************************************
 Cours:   LOG121
 Session: A2020
 Groupe:  1
 Projet: Laboratoire #2
 Ã‰tudiant(e)s: Pierre A Abdelli
 Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
 Nom du fichier: CollectionDes.java
 Date crÃ©Ã©: 2020-10-23
 Date dern. modif. 2020-10-23
 *******************************************************
 Historique des modifications
 *******************************************************
 2020-10-23
 *******************************************************/

package Framework;

import java.util.ArrayList;

public class CollectionDes implements Container {

	public ArrayList<Des> ListDes = new ArrayList<>();

	//Accesseur
	@Override
	public Iterateur getIterator() {
		return new DeIterateur();
	}

	//Accesseur
	public ArrayList<Des> getListDes() {
		return this.ListDes;
	}

	//Accesseur
	public Des getDe(int position) {
		if (position > ListDes.size()) return null;

		return ListDes.get(position - 1);
	}


	/**
	 * 	Méthode qui ajoute un dé a la liste de dé.
	 * @param de le dé a ajouter
	 */
	public void addDes(Des de) {
		ListDes.add(de);
	}

	/**
	 * Classe interne qui creer une iterateur pour la collection de Des
	 */
	private class DeIterateur implements Iterateur {

		int index;

		/**
		 * Methode qui retourne vrai ou faux si l'iterateur a un
		 * prochain objet dans sa liste
		 * @return boolean
		 */
		@Override
		public boolean hasNext() {
			if (index < ListDes.size()) {
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
				return ListDes.get(index++);
			}
			return null;
		}

	}

	/**
	 * Méthode qui brasse chaque dé de la liste de dé.
	 */
	public void brasser() {
		for (Des d : ListDes) {
			d.brasser();
		}
	}

	/**
	 * Méthode qui verifie si tout les valeur de dé son pareil
	 * @return true si ils sont tous pareil
	 */
	public boolean tousPareil() {
		Iterateur iterd = this.getIterator();
		Des d = ListDes.get(0);
		boolean pareil = true;

		while(iterd.hasNext() && pareil){
			Des de = (Des) iterd.next();
			pareil = d.compareTo(de) == 0;
		}
	return pareil;
	}

}
