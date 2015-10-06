package chapter3;

import java.util.stream.Stream;

public class Peek {

    public static Object[] peek(){
        Object[] powers = Stream.iterate(1.0, p -> p * 2)
                .peek(e -> System.out.println("Fetching " + e))
                .limit(20)
                .toArray();
        return powers;
    }
}
