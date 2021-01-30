import java.util.ArrayList;

public abstract class Operation extends Equation{

    protected ArrayList<Equation> listEquation = new ArrayList<Equation>();

    public Operation (Equation e1, Equation e2) {
        listEquation.add(e1);
        listEquation.add(e2);
    }

    abstract String getSymbole();

}
