import java.util.ArrayList;

public class Telecommande {

    public static final int MAX = 6;
    public static final int MAXBOUTONS = 4;
    private int nextFreeRow = 0;
    private Commande[][] commandes = new Commande[MAX][MAXBOUTONS];
    private ArrayList<Appareil> listAppareils = new ArrayList<>();

    public void attachAppareil(Appareil a) {
        commandes[nextFreeRow][0] = new On(a);
        commandes[nextFreeRow][1] = new Off(a);
        commandes[nextFreeRow][2] = new Increase(a);
        commandes[nextFreeRow][3] = new Decrease(a);
        listAppareils.add(a);
        nextFreeRow ++;
    }

    public ArrayList getListAppareils() { return this.listAppareils; }

    public Commande[][] getCommandes() { return this.commandes; }

    public void afficher() {
        for(Appareil a : listAppareils) {
            a.afficher();
        }
    }

}
