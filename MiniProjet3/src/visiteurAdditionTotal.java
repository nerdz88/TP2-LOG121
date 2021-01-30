public class visiteurAdditionTotal implements Visiteur{

    private int compteurSomme = 0;

    public void visit(Operation o) {

    }

    public void visit(Nombre n) {
        compteurSomme += n.getInt();
    }

    public int getCompteurSomme() { return this.compteurSomme; }

}
