public class Main {

    public static void main(String[] args) {

        Telecommande t = new Telecommande();
        Ventilateur v = new Ventilateur("VENT1");
        AmpouleGradeable ag = new AmpouleGradeable("AG1");
        AmpouleNormal an = new AmpouleNormal("AN1");

        try {
            t.attachAppareil(v);
            t.attachAppareil(ag);
            t.attachAppareil(an);
        } catch (Exception e) {
            e.printStackTrace();
        }

        t.afficher();

        Commande[][] commandes = t.getCommandes();

        commandes[0][0].execute();
        commandes[1][0].execute();
        commandes[2][0].execute();

    }

}
