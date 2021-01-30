import java.util.ArrayList;

public class Multiplication extends Operation {

    private String multi = "x";
    private ArrayList<Equation> list = new ArrayList<>();

    public Multiplication(Equation e1, Equation e2) {
        super(e1, e2);
    }
    public String getSymbole() { return this.multi; }

    @Override
    void accept(Visiteur v) {

        v.visit(this);
        for(Equation e : super.listEquation) {
            e.accept(v);
        }
    }
}
