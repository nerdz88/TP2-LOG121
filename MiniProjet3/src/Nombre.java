public class Nombre extends Equation{

    private int i;

    public Nombre(int i) {
        this.i = i;
    }

    public int getInt() { return this.i;}

    @Override
    void accept(Visiteur v) {
        v.visit(this);
    }
}
