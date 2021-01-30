/******************************************************
 Cours:   LOG121
 Session: A2020
 Groupe:  1
 Projet: Laboratoire #2
 Ã‰tudiant(e)s: Pierre A Abdelli
 Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
 Nom du fichier: JeuFactory.java
 Date crÃ©Ã©: 2020-10-30
 Date dern. modif. 2020-10-30
 *******************************************************
 Historique des modifications
 *******************************************************
 2020-10-30
 *******************************************************/
package Framework;

import Beetle.Beetle;
import BuncoPlus.BuncoPlus;
import SnakeEyes.SnakeEyes;

public class JeuFactory {

	private final int BUNCO = 1;
	private final int SNAKEEYES = 2;
	private final int BEETLE = 3;

	/**
	 * Methode qui retourne l'instance du jeu choisie par l'utilisateur
	 * @param jeu integer du choix de jeu
	 * @return instance du jeu choisie
	 */
	public Jeu getJeu(int jeu) {

		switch(jeu) {
			case BUNCO:
				return new BuncoPlus();
			case SNAKEEYES:
				snakeEyesInfo();
				return new SnakeEyes();
			case BEETLE:
				beetlePrintInfo();
				return new Beetle();
		}
		return null;
	}

	/*
	Methode qui affiche les details du jeu Beetle
	 */
	private void beetlePrintInfo() {
		System.out.println("\nHow to Play Beetle\r\n"
				+ "First player picks up the die and rolls it. They then draw a body part "
				+ "of a bug on their paper depending on the number rolled.\r\n"
				+ "\r\n" + "1 - Body\r\n" + "2 - Head\r\n" + "3 - A leg\r\n" + "4 - "
				+ "An eye\r\n" + "5 - An antenna\r\n"
				+ "6 - The tail\r\n" + "\r\n"
				+ "There are some restrictions on when each body part can be drawn: "
				+ "You must draw a body first, then a head, so the legs, tail and head cannot "
				+ "be drawn until the player has rolled a 1 and drawn the body, \n"
				+ "and the eyes and antennae cannot be drawn until the player has rolled a 2 "
				+ "and drawn the head.\r\n"
				+ "\r\n"
				+ "If a number is rolled that matches a body part that cannot be drawn or "
				+ "that the player has already drawn (e.g., the player rolls a 1 but they "
				+ "have already drawn the body) then the player’s turn ends.\r\n"
				+ "\r\n"
				+ "Once a player has rolled the die and has drawn any beetle parts, "
				+ "they pass the die to the next player who then takes a turn.\r\n"
				+ "\r\n" + "Play continues in this manner until somebody wins the game.\r\n" + "\r\n"
				+ "Winning\r\n"
				+ "A completed beetle will have a body, a head, two antennae, two eyes, "
				+ "six legs, and a tail. The first player to draw all parts of their beetle "
				+ "is the winner.\n\n");
	}

	/*
	Methode qui affiche les informations du jeu SnakeEyes
	 */
	private void snakeEyesInfo() {
		System.out.println("\nComment jouer à SnakeEyes\r\n"
				+ "À tour de rôle, chaque joueur lance 2 dés."
				+ "Le premier à obtenir la valeur de 7 ou 11, en additionnant la face des 2 dés,\n"
				+ "est le meneur du tour.\r\n"
				+ "Si un autre joueur parvient à obtenir la valeur de 7 ou 11 avant que les dés\n"
				+ "reviennent au main du meneur du tour, alors le meneur perd ton titre\n"
				+ "et le jeu recommence.\r\n"
				+ "À l'inverse, si aucun joueur n'arrive à obtenir la valeur de 7 ou 11 avant\n"
				+ "que les dés reviennent au main du meneur du tour, alors le meneur gagne la partie.\r\n"
				+ "Règles particulières\r\n"
				+ "- Si, en additionnant la face des 2 dés, la valeur est de 2, le joueur gagne immédiatement.\n"
				+ "(Snake Eyes [·] [·])\r\n"
				+ "- Si un double est brassé, le joueur peut rebrasser. (3 brassages de dés au maximum)\r\n"
		);
	}

}
