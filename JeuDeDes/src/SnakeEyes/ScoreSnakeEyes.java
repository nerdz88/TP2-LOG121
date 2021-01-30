/******************************************************
 Cours:   LOG121
 Session: A2020
 Groupe:  1
 Projet: Laboratoire #2
 Ã‰tudiant(e)s: Dave Vouma-Gagnon
 Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
 Nom du fichier: ScoreSnakeEyes.java
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

public class ScoreSnakeEyes implements IScore {

    private Boolean finBrasser = false;
    private int nbBrassage = 0;

    /**
     * Brasse les dés et calcul le pointage du tour
     * @param jeu l'instance du jeu SnakeEyes
     * @return la somme de la valeur des dés brassés
     */
    @Override
    public int calculerScoreTour(Jeu jeu) {
        return brasserDes(jeu);
    }

    /**
     * Affiche le vainqueur de la partie
     * @param jeu l'instance du jeu SnakeEyes
     */
    @Override
    public void calculerLeVainqueur(Jeu jeu) {
        System.out.println("Le vainqueur est le joueur #" + ((SnakeEyes)jeu).getMeneurTour().getNumeroJoueurs() + ". Félicitation!");
    }

    /**
     * Vérifie si le joueur à brasser un double
     * @param jeu l'instance du jeu SnakeEyes
     * @return vrai, si les 2 dés ont la même valeur, sinon faux.
     */
    private boolean estDouble(Jeu jeu) {
        CollectionDes collectionDes = jeu.getCollectionDes();
        Des de1 = collectionDes.getDe(1);
        Des de2 = collectionDes.getDe(2);

        return  de1.compareTo(de2) == 0;
    }

    /**
     * Vérifie si le joueur  à brasser un SnakeEyes
     * @param jeu l'instance du jeu SnakeEyes
     * @return vrai, si, en additionnant la face des 2 dés, la valeur est de 2 sinon faux.
     */
    private boolean verifierSnakeEye(Jeu jeu) {
        CollectionDes collectionDes = jeu.getCollectionDes();
        Des de1 = collectionDes.getDe(1);
        Des de2 = collectionDes.getDe(2);

        if (de1.getValeur() + de2.getValeur() == 2) {
            return finBrasser = true;

        }
        return finBrasser;
    }

    /**
     * Vérifie que le joueur peut rebrasser
     * @return vrai, si le nombre de brassage est inférieur à 3, sinon faux.
     */
    private boolean peutRebrasser() {
        return this.nbBrassage < 3;
    }

    /**
     * Réinitialise le nombre de brassage
     */
    private void resetNbBrassage() {
        this.nbBrassage = 0;
    }

    /**
     * Brasse les dés et retourne la somme de la valeur des faces des dés.
     * @param jeu l'instance du jeu SnakeEyes
     * @return la somme de la valeur des faces des dés.
     */
    private int brasserDes(Jeu jeu) {
        Iterateur iterde = jeu.getCollectionDes().getIterator();
        int score = 0;

        finBrasser = false;

        while (iterde.hasNext() && !finBrasser && peutRebrasser()) {
            Des de = (Des) iterde.next();
            System.out.println(de.getValeur());

            score += de.getValeur();

            // Si les 2 dés ont été brassé...
            if (!iterde.hasNext()) {
                if (verifierSnakeEye(jeu)) {
                    this.finBrasser = true;
                }

                if(estDouble(jeu)) {
                    this.nbBrassage++;
                } else {
                    finBrasser = true;
                }

                if (finBrasser) {
                    resetNbBrassage();
                } else if (peutRebrasser()) {
                    score = 0;
                    jeu.getCollectionDes().brasser();
                    iterde = jeu.getCollectionDes().getIterator();
                } else {
                    this.finBrasser = true;
                }
            }
        }
        return score;
    }
}
