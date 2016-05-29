import java.io.Serializable;

/**
 * Created by Victor on 29/5/16.
 */
public class SerializedSingleton implements Serializable {
    private static final long serialVersionUID = -423234234234234234L;
    private static SerializedSingleton instance;

    private SerializedSingleton() {

    }

    public static SerializedSingleton getInstance() {
        if (instance == null) {
            instance = new SerializedSingleton();
        }
        return instance;
    }
}
