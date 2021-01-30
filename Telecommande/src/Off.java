public class Off implements Commande {

    Appareil a;

    public Off(Appareil a) {
        this.a = a;
    }

    @Override
    public void execute() {
        a.off();
    }
}
