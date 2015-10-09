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
}