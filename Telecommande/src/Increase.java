public class Increase implements  Commande{

    Appareil a;

    public Increase(Appareil a) {
        this.a = a;
    }

    @Override
    public void execute() {
        a.increase();
    }
}
