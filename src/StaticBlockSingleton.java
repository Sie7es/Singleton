/**
 * Created by Victor on 29/5/16.
 */
public class StaticBlockSingleton {

    private static StaticBlockSingleton instance;

    /*
        Es igual a un EagerSingleton, con sus mismo inconveniente (siempre se crea la instancia del singleton aunque nadie la demande
        La única diferencia es que la instancia se crea en un bloque stático que nos permite manejar una excepción por si algo sale mal.
     */
    private StaticBlockSingleton() {

    }

        static {
            try{
                instance = new StaticBlockSingleton();
            } catch (Exception e) {
                throw new RuntimeException("Exception ocurred in creating singleton instance");
            }
        }

    public static StaticBlockSingleton getInstante() {
        return instance;
    }
}
