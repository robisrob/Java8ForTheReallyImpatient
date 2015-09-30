package chapter3;

import java.util.Arrays;
import java.util.Comparator;

public class Ex9 {

    public static Comparator<Object> lexicographicComparator(String... fieldNames) {
        return Arrays.asList(fieldNames).stream().map(fieldName -> (Comparator<Object>) (o1, o2) -> {
            try {
                return ((String) (o1.getClass().getDeclaredField(fieldName).get(o1))).compareTo((String) o2.getClass().getDeclaredField(fieldName).get(o2));
            } catch (IllegalAccessException | NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }).reduce(Comparator::thenComparing).get();

    }


}
