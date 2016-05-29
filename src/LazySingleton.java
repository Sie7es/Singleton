/**
 * Created by Victor on 29/5/16.
 */
public class LazySingleton {
    private static LazySingleton lazySingleton;


    //Constructor privado para obligar a usar el método global para crear la instancia.
    private LazySingleton() {

    }

    /*
        Metodo estático que nos devuelve el singleton. Primero miramos si el singleton ya ha sido creado, si no es así lo crea. Si ya
        estaba creado simplemente lo devuelve.
     */
    public static LazySingleton getLazySingleton() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }

        return lazySingleton;
    }
}
