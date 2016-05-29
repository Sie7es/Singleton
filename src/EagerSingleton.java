/**
 * Created by Victor on 29/5/16.
 */
public class EagerSingleton {
    //El inconveniente es que siempre se crea la instancia aunque nadie haga use de ella.
    private static final EagerSingleton instance = new EagerSingleton();

    //Creamos el constructor como privado para impedir que que se instancie con él
    private EagerSingleton() {

    }

    //Método estático para obtener la instancia en común (el singleton).
    public static EagerSingleton getInstance() {
        return instance;
    }
}
