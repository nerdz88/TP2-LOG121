import java.util.ArrayList;

public class Addition extends Operation {

    private String add = "+";


    public Addition (Equation e1, Equation e2) {
        super(e1,e2);
    }

    public String getSymbole() { return this.add; }


    @Override
    void accept(Visiteur v) {

        v.visit(this);
        for(Equation e : super.listEquation) {
            e.accept(v);
        }

    }
}
