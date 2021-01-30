/******************************************************
 Cours:   LOG121
 Session: A2020
 Groupe:  1
 Projet: Laboratoire #2
 √âtudiant(e)s: Pierre A Abdelli et Michael Couet
 Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
 Nom du fichier: Des.java
 Date cr√©√©: 2020-10-23
 Date dern. modif. 2020-10-23
 *******************************************************
 Historique des modifications
 *******************************************************
 2020-10-23
 *******************************************************/
package Framework;

import java.util.Random;

public class Des implements Comparable<Object> {

    private int valeur = 1;

    /**
     * Constructeur
     */
    public Des() {
        brasser();
    }

    /**
     * MÈthode qui donne un valeur de dÈ au hasard
     */
    public void brasser() {
        Random chiffre = new Random();
        valeur = chiffre.nextInt(6) + 1;
    }

    //Accesseur
    public int getValeur() {
        return this.valeur;
    }

    //Mutateur
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    /**
     * MÈthode qui compare 2 valeur de dÈ.
     */
    @Override
    public int compareTo(Object o) {

        Des de = (Des) o;
        if(de == null) {
            throw new IllegalArgumentException();
        }
        else if (valeur > de.getValeur()) {
            return -1;
        }
        if (valeur == de.getValeur()) {
            return 0;
        } else {
            return 1;
        }

    }
}
