public class On implements Commande {

    Appareil a;

    public On(Appareil a) {
        this.a = a;
    }

    @Override
    public void execute() {
        a.on();
    }
}
