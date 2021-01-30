public class Decrease implements Commande{
    Appareil a;

    public Decrease(Appareil a) {
        this.a = a;
    }

    @Override
    public void execute() {
        a.decrease();
    }
}
