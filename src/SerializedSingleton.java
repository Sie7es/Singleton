import org.omg.PortableInterceptor.INACTIVE;

import java.io.*;

/**
 * Created by Victor on 29/5/16.
 */
public class SerializedSingleton implements Serializable {
    private static final long serialVersionUID = -423234234234234234L;
    private static final String FILE_ANME = "serialized.bin";
    private static SerializedSingleton instance;

    private SerializedSingleton() {

    }

    public static SerializedSingleton getInstance() {
        if (instance == null) {
            instance = new SerializedSingleton();
        }
        return instance;
    }


    public static void serializeMe() throws IOException {
        if (instance != null) {
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream(FILE_ANME));

            out.writeObject(instance);

            out.flush();
            out.close();
        } else {
            new Exception("SINGLETON IS NULL");
        }
    }

    public static SerializedSingleton desSerializeMe() throws IOException, ClassNotFoundException {
        ObjectInput in = new ObjectInputStream(new FileInputStream(FILE_ANME));

        instance = (SerializedSingleton) in.readObject();
        in.close();

        return getInstance();
    }


    /*
        Necesario para que una vez lea un obj serializado lo reemplazo por nuestra instancia. Si no lo hicieramos el singleton se perdería
        y se crearía un nuevo obj.
     */
    protected Object readResolve() {
        return getInstance();
    }
}
