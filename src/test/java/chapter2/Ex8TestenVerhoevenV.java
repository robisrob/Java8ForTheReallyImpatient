package chapter2;

import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;

import java.util.stream.Stream;

public class Ex8TestenVerhoevenV {

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

    //Added extra scenario myself
    //For solution see: https://github.com/verhoevenv/Java8ForTheReallyImpatient/blob/master/src/main/java/chapter2/Ex8.java
    @Ignore
    @Test
    public void testZip_OneinfiniteStreams() throws Exception {
        Stream<String> s1 = Stream.generate(() -> "A");
        Stream<String> s2 = Stream.of("Z", "X");

        Stream<String> zipped = Ex8.zipAlsoCompatibleWithInfiniteStreams(s1, s2);

        Assertions.assertThat(zipped.toArray()).containsExactly("A", "Z", "A", "X");
    }
}
