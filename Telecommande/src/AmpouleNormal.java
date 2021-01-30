public class AmpouleNormal extends Appareil{

    public AmpouleNormal(String NUM_SERIE) {
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
        System.out.println(super.getNUM_SERIE() + "doing nothing");
    }

    @Override
    public void decrease() {
        System.out.println(super.getNUM_SERIE() + "doing nothing");
    }

}
