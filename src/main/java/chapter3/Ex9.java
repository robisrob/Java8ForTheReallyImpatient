package chapter3;

import java.util.Arrays;
import java.util.Comparator;

public class Ex9 {

    public static Comparator<Object> lexicographicComparator(String... fieldNames) {
        return Arrays.stream(fieldNames).map(fieldName -> (Comparator<Object>) (o1, o2) -> {
            try {
                return getObjectComparable(fieldName, o1).compareTo(o2.getClass().getDeclaredField(fieldName).get(o2));
            } catch (IllegalAccessException | NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }).reduce(Comparator::thenComparing).get();

    }

    @SuppressWarnings("unchecked")
    private static Comparable<Object> getObjectComparable(String fieldName, Object o1) throws IllegalAccessException, NoSuchFieldException {
        return (Comparable<Object>) o1.getClass().getDeclaredField(fieldName).get(o1);
    }


}
