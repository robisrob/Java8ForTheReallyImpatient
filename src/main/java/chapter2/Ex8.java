package chapter2;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Integer.min;
import static java.util.Arrays.asList;

public class Ex8 {

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> firstList = first.collect(Collectors.toList());
        List<T> secondList = second.collect(Collectors.toList());
        return IntStream.range(0, min(firstList.size(), secondList.size())).mapToObj(v -> asList(firstList.get(v), secondList.get(v))).flatMap(Collection::stream);
    }
}

