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
}