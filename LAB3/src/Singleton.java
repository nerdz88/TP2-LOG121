public class Singleton {

    private static Singleton singleton;

    private Singleton() {}

    public static Singleton getSingleton() {
        if(singleton == null) return new Singleton();
        return singleton;
    }

}
