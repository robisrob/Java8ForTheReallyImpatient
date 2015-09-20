import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class Ch1Test {

    @Test
    public void lambdaThrowingAnException() throws Exception {
        Ch1 ch1 = new Ch1();
        ch1.cocktail("bar");

        assertThat(ch1.lambdaThrowingAnException()).isEqualTo("bar");
    }

    @Test
    public void methodRefs() throws Exception {
        Ch1 ch1 = new Ch1();
        BarName[] actual = ch1.methodRefs("tom", "collins");
        BarName tomBarName = new BarName("tom");
        BarName collinsBarName = new BarName("collins");

        assertThat(actual).contains(tomBarName, collinsBarName);
    }
}