import java.util.ArrayList;

public class AmpouleGradeable extends Appareil{

    public AmpouleGradeable(String NUM_SERIE) {
        super(NUM_SERIE);
    }

    @Override
    public void on() {
        System.out.println(super.getNUM_SERIE() + " : is On");
    }

    @Override
    public void off() {
        System.out.println(super.getNUM_SERIE() + " : is Off");
    }

    @Override
    public void increase() {
        System.out.println(super.getNUM_SERIE() + " : is going up");
    }

    @Override
    public void decrease() {
        System.out.println(super.getNUM_SERIE() + " : is doing down");
    }

}
