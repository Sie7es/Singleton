/**
 * Created by Victor on 29/5/16.
 */
public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {

    }

    //Al incluir la directiva synchronized, nos aseguramos que la instanciación sea segura para entornos multihilo.
    //El inconveniente es que resulta más lento la instanciación porque tenemos el método sincronizado.
    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }


    public static ThreadSafeSingleton getInstanceDoubleLocking() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) { //La sincronización la hacemos dentro sólo si la instancia es null.
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
