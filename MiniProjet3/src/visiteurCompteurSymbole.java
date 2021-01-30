public class visiteurCompteurSymbole implements Visiteur{

    private int compteur = 0;

    public void visit(Operation o) {
        compteur ++;
    }

    public void visit (Nombre n) {

    }

    public int getCompteur() { return this.compteur; }

}
