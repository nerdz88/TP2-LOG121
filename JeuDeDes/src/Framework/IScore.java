/******************************************************
 Cours:   LOG121
 Session: A2020
 Groupe:  1
 Projet: Laboratoire #2
 Étudiant(e)s: Pierre A Abdelli
 Professeur : Vincent Lacasse et Eduardo Furtado-Sa-Correa
 Nom du fichier: IScore.java
 Date créé: 2020-10-23
 Date dern. modif. 2020-10-23
 *******************************************************
 Historique des modifications
 *******************************************************
 2020-10-23
 *******************************************************/
package Framework;

public interface IScore {

    int calculerScoreTour(Jeu jeu);

    void calculerLeVainqueur(Jeu jeu);

}
