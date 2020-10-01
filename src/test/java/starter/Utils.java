package starter;

import java.util.Random;

public class Utils {
    public static <T extends Enum<?>> T getRandomValueFromEnum(Class<T> clazz) {
        int x = new Random().nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
