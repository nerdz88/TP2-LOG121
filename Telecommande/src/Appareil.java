import java.util.ArrayList;
import java.util.List;

public abstract class Appareil {

    public abstract void on();
    public abstract void off();
    public abstract void increase();
    public abstract void decrease();

    private String NUM_SERIE;
    private List<String> listBoutons;

    public Appareil(String NUM_SERIE) {
        this.NUM_SERIE = NUM_SERIE;
    }

    public String getNUM_SERIE() {
        return NUM_SERIE;
    }

    public void attachBouton(String s) {
        listBoutons.add(s);
    }

    public void afficher(){
        System.out.println(NUM_SERIE);
    }

}
