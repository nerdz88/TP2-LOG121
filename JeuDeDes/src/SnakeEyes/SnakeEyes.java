/******************************************************
 Cours:   LOG121
 Session: A2020
 Groupe:  1
 Projet: Laboratoire #2
 Ã‰tudiant(e)s: Dave Vouma-Gagnon
 Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
 Nom du fichier: SnakeEyes.java
 Date crÃ©Ã©: 2020-11-02
 Date dern. modif. 2020-11-11
 *******************************************************
 Historique des modifications
 *******************************************************
 2020-11-02
 2020-11-05
 2020-11-10
 2020-11-11
 *******************************************************/
package SnakeEyes;

import Framework.*;

import java.util.Scanner;

public class SnakeEyes extends Jeu {

    private final int NBDES = 2;
    private final int SNAKEEYES = 2;

    private ScoreSnakeEyes scoreSnakeEyes = new ScoreSnakeEyes();
    private Joueurs meneurTour = null;
    private boolean finPartie = false;

    Scanner scanner = new Scanner(System.in);

    /**
     * Initialise les paramètres du jeu Snake Eyes
     */
    @Override
    protected void initialize() {
        super.resetNbTour();
        initializeDes();
        System.out.println(Constantes.MOTBIENVENUESNAKEEYES);
        System.out.print(Constantes.COMBIENJOUEURS);
        int nbJoueurs = scanner.nextInt();
        initializeJoueurs(nbJoueurs);
    }

    /**
     * Démarre une partie du jeu Snake Eyes
     */
    @Override
    protected void run() {
        Iterateur iterJ = super.getCollectionJoueurs().getIterator();

        while(iterJ.hasNext() && !finPartie) {
            Joueurs j = (Joueurs) iterJ.next();

            // verifier si le joueur gagnant est le joueur qui va jouer.
            if (j == this.meneurTour) {
                System.out.println("Le joueur #" + j.getNumeroJoueurs() + " : Personne ne vous a annulé, bravo vous avez gagné!!");
                this.finPartie = true;
            } else {
                System.out.println("------ JOUEUR ----- [" + j.getNumeroJoueurs() + "] : Appuyer sur une touche " +
                        "pour jouer votre tour");
                System.out.println();
                scanner.nextLine();
                getCollectionDes().brasser();
                j.setScoreJoueur(scoreSnakeEyes.calculerScoreTour(this));
                setMeneurTour(j);
            }

            if(!iterJ.hasNext() && !finPartie) {
                iterJ = addTour(iterJ);
            }
        }
    }

    /**
     * Méthode qui initialise les joueurs
     *
     * @param nbJoueurs le nombre de joueur
     */
    private void initializeJoueurs(int nbJoueurs) {
        for (int i = 0; i < nbJoueurs; i++) {
            Joueurs joueur = new Joueurs(i + 1);
            super.addJoueurs(joueur);
        }
    }

    /**
     * Méthode qui initialise les dés
     */
    private void initializeDes() {
        for (int i = 0; i < NBDES; i++) {
            Des de = new Des();
            super.addDes(de);
        }
    }

    /**
     * Affiche le vainqueur de la partie
     */
    @Override
    public void calculerLeVainqueur() {
        calculerLeVainqueur(this);
    }

    private Iterateur addTour(Iterateur i) {

        if (!i.hasNext()) {
            super.addTour();
            return super.getCollectionJoueurs().getIterator();
        }
        return i;
    }

    /**
     * Retourne le meneur de la partie
     * @return le meneur de la partie
     */
    public Joueurs getMeneurTour() {
        return this.meneurTour;
    }

    /**
     * Définie le joueur comme étant le meneur du tour si son pointage lui permet
     * ou enlève le titre de meneur de tour à l'ancien meneur.
     * @param j le joueur ayant brassé les dés du présent tour.
     */
    private void setMeneurTour(Joueurs j) {
        if (j.getScoreJoueur() == SNAKEEYES) {
            System.out.println("Le joueur #" + j.getNumeroJoueurs() + " : SNAKE EYES!!, bravo vous avez gagné!!");
            finPartie = true;
            this.meneurTour = j;
        }

        if (j.getScoreJoueur() == 7 || j.getScoreJoueur() == 11) {
            if (this.meneurTour != null) {
                System.out.println("Le joueur #" + j.getNumeroJoueurs() + " : Vous avez annulé le meneur du tour!!");
                this.meneurTour = null;
            } else {
                System.out.println("Le joueur #" + j.getNumeroJoueurs() + " : Vous êtes présentement le meneur du tour!");
                this.meneurTour = j;
            }
        }
    }

    /**
     * Affiche le vainqueur de la partie
     * @param jeu l'instance du jeu SnakeEyes
     */
    public void calculerLeVainqueur(Jeu jeu) {
        this.scoreSnakeEyes.calculerLeVainqueur(jeu);
    }

    /**
     * Brasse les dés et calcul le pointage du tour
     * @param jeu l'instance du jeu SnakeEyes
     * @return la somme de la valeur des dés brassés
     */
    public int calculerScoreTour(Jeu jeu) {
        return this.scoreSnakeEyes.calculerScoreTour(jeu);
    }
}
