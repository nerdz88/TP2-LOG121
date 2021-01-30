public class visiteurDisplay implements Visiteur {

    private StringBuffer sb = new StringBuffer();

    @Override
    public void visit(Operation o) {
        sb.append(o.getSymbole() + " ");
    }

    @Override
    public void visit(Nombre n) {
        sb.append(n.getInt() + " ");
    }

    public String toString() { return sb.toString(); }
}
