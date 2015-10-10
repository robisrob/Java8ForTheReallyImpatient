package chapter2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;
import static org.assertj.core.api.Assertions.*;

public class Ch2Test {

    @Test
    public void ex5_randomInfiniteStream() throws Exception {
        Stream<Long> randomInfiniteStream = Ch2.randomInfiniteStream(25214903917l, 11, Math.pow(2, 48));
        assertThat(randomInfiniteStream).isNotNull();
        randomInfiniteStream.limit(25).forEach((System.out::println));
    }

    @Test
    public void ex8_zip_2StreamsOfSameLength_BothStreamsAreZippedTotally() throws Exception {
        Stream<String> stream1 = Stream.of("Zip1", "Zip2", "Zip3");
        Stream<String> stream2 = Stream.of("Zop1", "Zop2", "Zop3");

        assertThat(Ch2.zip(stream1, stream2).collect(Collectors.toList())).containsExactly("Zip1", "Zop1", "Zip2", "Zop2", "Zip3", "Zop3");
    }
    
    @Test
    public void ex8_zip_SecondStreamIs2LargerThanFirst_ReturnsAZippedStreamWithoutLast2ItemsOfSecondStream() throws Exception {
        Stream<String> stream1 = Stream.of("Zip1", "Zip2", "Zip3");
        Stream<String> stream2 = Stream.of("Zop1", "Zop2", "Zop3", "Zop4", "Zop5");

        assertThat(Ch2.zip(stream1, stream2).collect(Collectors.toList())).containsExactly("Zip1", "Zop1", "Zip2", "Zop2", "Zip3", "Zop3");
    }
    
    @Test
    public void ex8_zip_SecondStreamIs2LessThanFirst_ReturnsAZippedStreamWithoutLast2ItemsOfFirstStream() throws Exception {
        Stream<String> stream1 = Stream.of("Zip1", "Zip2", "Zip3", "Zop4", "Zop5");
        Stream<String> stream2 = Stream.of("Zop1", "Zop2", "Zop3");

        assertThat(Ch2.zip(stream1, stream2).collect(Collectors.toList())).containsExactly("Zip1", "Zop1", "Zip2", "Zop2", "Zip3", "Zop3");
    }

    @Test
    public void ex8_zip_FirstStreamRunsOut_ReturnsAZippedStreamWithLastItemOfFirstStream() throws Exception {
        Stream<Integer> stream1 = Stream.iterate(1, zip -> ++zip);
        Stream<Integer> stream2 = Stream.iterate(1, zop -> ++zop);
        Stream<Integer> actual = Ch2.zip(stream1.limit(3), stream2.limit(5));
        assertThat(actual.collect(Collectors.toList())).containsExactly(1,1,2,2,3,3);
    }

    @Test
    public void ex8_zip_SecondStreamRunsOut_ReturnsAZippedStreamWithLastItemOfSecondStream() throws Exception {
        Stream<Integer> stream1 = Stream.iterate(1, zip -> ++zip);
        Stream<Integer> stream2 = Stream.iterate(1, zop -> ++zop);
        Stream<Integer> actual = Ch2.zip(stream1.limit(7), stream2.limit(5));
        assertThat(actual.collect(Collectors.toList())).containsExactly(1,1,2,2,3,3,4,4,5,5);
    }
    
    @Test
    public void ex8_testZip_infiniteStreams() throws Exception {
        Stream<String> s1 = Stream.generate(() -> "A");
        Stream<String> s2 = Stream.generate(() -> "Z");

        Stream<String> zipped = Ch2.zip(s1, s2);

        Assertions.assertThat(zipped.limit(6).toArray()).containsExactly("A", "Z", "A", "Z", "A", "Z");
    }

    @Test
    public void ex9_reduce_1() throws Exception {
        ArrayList<String> arrayList1 = Stream.of("String1", "String2").collect(toCollection(ArrayList::new));
        ArrayList<String> arrayList2 = Stream.of("Strong3", "Strong4").collect(toCollection(ArrayList::new));
        Stream<ArrayList<String>> stream = Stream.of(arrayList1, arrayList2);

        ArrayList<String> actual1 = Ch2.reduceList_1(stream);
        assertThat(actual1).containsExactly("String1", "String2", "Strong3", "Strong4");
    }

    @Test
    public void ex9_reduce_2() throws Exception {
        ArrayList<String> arrayList1 = Stream.of("String1", "String2").collect(toCollection(ArrayList::new));
        ArrayList<String> arrayList2 = Stream.of("Strong3", "Strong4").collect(toCollection(ArrayList::new));
        Stream<ArrayList<String>> stream = Stream.of(arrayList1, arrayList2);

        ArrayList<String> actual1 = Ch2.reduceList_2(stream);
        assertThat(actual1).containsExactly("String1", "String2", "Strong3", "Strong4");
    }

    @Test
    public void ex9_reduce_3() throws Exception {
        ArrayList<String> arrayList1 = Stream.of("String1", "String2").collect(toCollection(ArrayList::new));
        ArrayList<String> arrayList2 = Stream.of("Strong3", "Strong4").collect(toCollection(ArrayList::new));
        Stream<ArrayList<String>> stream = Stream.of(arrayList1, arrayList2);

        ArrayList<String> actual1 = Ch2.reduceList_3(stream);
        assertThat(actual1).containsExactly("String1", "String2", "Strong3", "Strong4");
    }

}
