package chapter2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

public class Ch2 {

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
}
