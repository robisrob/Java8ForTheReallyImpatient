package chapter2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ch2 {

    /**
     * Exercise 4
     */
    public static IntStream intStream(int... intVals) {
        //return Stream.of(intVals);//Stream of ints boxed to Integers
        return IntStream.of(intVals); //Stream of ints
    }

    /**
     * Exercise 5
     */
    public static Stream<Long> randomInfiniteStream(long a, int c, double m) {
        return Stream.iterate(0L, (x) -> (a * x + c) % Double.doubleToLongBits(m));
    }

    /**
     * Exercise 8
     */
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIter = first.iterator();
        Iterator<T> secondIter = second.iterator();
        ArrayList<T> result = new ArrayList<>();
        while(firstIter.hasNext()){
            if (!secondIter.hasNext()){
                break;
            }
            result.add(firstIter.next());
            result.add(secondIter.next());
        }
        return result.stream();
    }

    /**
     * Exercise 9
     */
    public static ArrayList<String> reduceList_1(Stream<ArrayList<String>> input) {
        return input.reduce((prev, cur)-> {
            prev.addAll(cur);
            return prev;
        }).orElse(new ArrayList<>());
    }

    public static ArrayList<String> reduceList_2(Stream<ArrayList<String>> input) {
        return input.reduce(new ArrayList<>(),
                (prev, cur) -> {
                    prev.addAll(cur);
                    return prev;
                });
    }

    public static ArrayList<String> reduceList_3(Stream<ArrayList<String>> input) {
        return input.reduce(new ArrayList<>(),
                (initialArray, oneOfTheArrayLists) -> {
                    initialArray.addAll(oneOfTheArrayLists);
                    return initialArray;
                },
                (prev, cur) -> {
                    prev.addAll(cur);
                    return prev;
                });
    }
}
