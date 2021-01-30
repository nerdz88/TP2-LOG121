public class Main {

    public static void main(String[] args) {

        Equation equation = new Nombre(5);
        Equation equation1 = new Nombre(10);
        Equation equation2 = new Nombre(4);
        Equation equation3 = new Nombre(2);

        Addition addition = new Addition(equation,equation1);
        Multiplication multiplication = new Multiplication(equation2,equation3);

        Addition addition1 = new Addition(addition,multiplication);

        Visiteur v = new visiteurDisplay();
        Visiteur vSymbole = new visiteurCompteurSymbole();
        Visiteur vCompteur = new visiteurAdditionTotal();
        addition1.accept(v);
        addition1.accept(vSymbole);
        addition1.accept(vCompteur);
        System.out.println(v.toString());
        System.out.println(((visiteurCompteurSymbole)vSymbole).getCompteur());
        System.out.println(((visiteurAdditionTotal)vCompteur).getCompteurSomme());

    }



}
