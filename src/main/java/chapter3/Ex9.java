package chapter3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.StreamSupport;

public class Ex9 {

    public static Comparator<Object> lexicographicComparator(String... fieldNames) {
        Comparator<Object> comparatorFieldnames = null;
        for (String fieldName : fieldNames) {
            Comparator<Object> comparatorFieldName = (Object o1, Object o2) -> {
                try {
                    return ((String) (o1.getClass().getDeclaredField(fieldName).get(o1))).compareTo((String)o2.getClass().getDeclaredField(fieldName).get(o2));
                } catch (IllegalAccessException | NoSuchFieldException e) {
                    throw new RuntimeException(e);
                }
            };
            comparatorFieldnames = comparatorFieldnames == null ? comparatorFieldName : comparatorFieldnames.thenComparing(comparatorFieldName);

        }
        return comparatorFieldnames;
    }
}
