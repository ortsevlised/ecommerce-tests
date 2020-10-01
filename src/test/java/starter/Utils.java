package starter;

import java.util.Random;

public class Utils {
    /**
     * Returns a random value from an Enum
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T extends Enum<?>> T getRandomValueFromEnum(Class<T> clazz) {
        int x = new Random().nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
