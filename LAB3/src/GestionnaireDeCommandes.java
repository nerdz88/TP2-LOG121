import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class GestionnaireDeCommandes {

    Deque<Commande> stackHistorique =  new ArrayDeque<>();
    Deque<Commande> stackARefaire = new ArrayDeque<>();

    public boolean peutDefaire() { return !stackHistorique.isEmpty(); }
    public boolean peutRefaire() { return !stackARefaire.isEmpty(); }



}
