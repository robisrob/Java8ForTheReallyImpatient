package chapter2;

import org.junit.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class Ch2Test {

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
        Stream<Integer> actual = Ch2.zip(stream1.limit(6), stream2.limit(5));
        assertThat(actual.collect(Collectors.toList())).containsExactly(1,1,2,2,3,3,4,4,5,5);
    }
}