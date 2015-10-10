package chapter2;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex8Test {

    private List<Integer> lijstOnevenNummers;
    private List<Integer> lijstEvenNummers;

    @Before
    public void setup() {
        lijstOnevenNummers = Arrays.asList(1, 3, 5, 7);
        lijstEvenNummers = Arrays.asList(2, 4);
    }

    @Test
    public void testZip_AlternatesElementsFromFirstStreamAndSecondStream_FirstStreamHasMoreElements() throws Exception {
        Stream<Integer> result = Ex8.zip(lijstOnevenNummers.stream(), lijstEvenNummers.stream());

        Assertions.assertThat(result.collect(Collectors.toList())).containsExactly(1, 2, 3, 4);
    }

    @Test
    public void testZip_AlternatesElementsFromFirstStreamAndSecondStream_SecondStreamHasMoreElements() throws Exception {
        Stream<Integer> result = Ex8.zip(lijstEvenNummers.stream(), lijstOnevenNummers.stream());

        Assertions.assertThat(result.collect(Collectors.toList())).containsExactly(2, 1, 4, 3);
    }

    //Testen Vincent
    @Test
    public void testZip() throws Exception {
        Stream<String> s1 = Stream.of("A", "B", "C");
        Stream<String> s2 = Stream.of("Z", "X");

        Stream<String> zipped = Ex8.zipAlsoCompatibleWithInfiniteStreams(s1, s2);

        Assertions.assertThat(zipped.toArray()).containsExactly("A", "Z", "B", "X");
    }

    @Test
    public void testZip_infiniteStreams() throws Exception {
        Stream<String> s1 = Stream.generate(() -> "A");
        Stream<String> s2 = Stream.generate(() -> "Z");

        Stream<String> zipped = Ex8.zipAlsoCompatibleWithInfiniteStreams(s1, s2);

        Assertions.assertThat(zipped.limit(6).toArray()).containsExactly("A", "Z", "A", "Z", "A", "Z");
    }
}