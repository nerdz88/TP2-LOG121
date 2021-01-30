/******************************************************
 Cours:   LOG121
 Session: A2020
 Groupe:  1
 Projet: Laboratoire #2
 Étudiant(e)s: Pierre A Abdelli
 Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
 Nom du fichier: Main.java
 Date créé: 2020-10-23
 Date dern. modif. 2020-10-30
 *******************************************************
 Historique des modifications
 *******************************************************
 2020-10-23
 2020-10-30
 *******************************************************/

import Framework.Jeu;
import Framework.JeuFactory;

import java.util.Scanner;

public class Main {


    //Main
    public static void main(String[] args) {

        JeuFactory jeuFactory = new JeuFactory();

        printMenu();

        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();

        Jeu jeu = jeuFactory.getJeu(choix);
        jeu.jouer();

    }

    /*
    Methode qui imprime le menu initiale
     */
    private static void printMenu() {

        System.out.println("Veuillez choisir le jeu auquel vous voulez jouer");
        System.out.println("------------------------------------------------");
        System.out.println("1 - BuncoPlus");
        System.out.println("2 - SnakeEyes");
        System.out.println("3 - Beetle");
        System.out.print("Appuyer sur la touche correspondant au jeu choisi : ");

    }

}
