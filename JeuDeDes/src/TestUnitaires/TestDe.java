/******************************************************
Cours:   LOG121
Session: A2020
Groupe:  1
Projet: Laboratoire #2
Étudiant(e)s: Pierre A Abdelli et Michael Couet
Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
Nom du fichier: TestJeu.java
Date créé: 2020-10-23
Date dern. modif. 2020-10-26
*******************************************************
Historique des modifications
*******************************************************
2020-10-23
2020-10-25
2020-10-26
*******************************************************/

package TestUnitaires;

import Framework.CollectionDes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Framework.Des;

public class TestDe {

	private Des de1 = new Des();
	private Des de2 = new Des();
	private Des de3 = new Des();
	private CollectionDes collectionDes = new CollectionDes();

	@Before
	public void faireAvant() {
		de1.setValeur(4);
		de2.setValeur(6);
		de3.setValeur(1);
		collectionDes.addDes(de1);
		collectionDes.addDes(de2);
		collectionDes.addDes(de3);

	}

	/**
	 * M�thode qui test si le d� est superieur
	 */
	@Test
	public void deSuperieurTest() {

		Assert.assertTrue(de1.compareTo(de2) == 1);
	}

	/**
	 * M�thode qui test si le d� est inf�rieur
	 */
	@Test
	public void deInferieurTest() {

		Assert.assertTrue(de2.compareTo(de1) == -1);
	}

	/**
	 * M�thode qui test si les d�s sont pareil
	 */
	@Test
	public void memeDeTest() {
		de1.setValeur(6);
		Assert.assertTrue(de2.compareTo(de1) == 0);
	}

	/**
	 * M�thode qui test quand c'est null
	 */
	@Test(expected = IllegalArgumentException.class)
	public void deNullTest() {
		de1.setValeur(4);
		de1.compareTo(null);
	}

	/**
	 * M�thode qui test quand les d�s son tout pareil
	 */
	@Test
	public void tousPareil() {
		de1.setValeur(5);
		de2.setValeur(5);
		de3.setValeur(5);

		Assert.assertTrue(collectionDes.tousPareil());

	}

	/**
	 * M�thode qui test si les d�s son tout diff�rent
	 */
	@Test
	public void pasTousPareil() {
		de1.setValeur(2);
		de2.setValeur(6);
		de3.setValeur(4);

		Assert.assertTrue(!collectionDes.tousPareil());

	}

}
