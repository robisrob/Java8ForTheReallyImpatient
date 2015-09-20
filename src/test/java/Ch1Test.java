import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class Ch1Test {

    @Test
    public void cocktail_ShouldSetBar() throws Exception {
        Ch1 ch1 = new Ch1();
        ch1.cocktail("bar");

        assertThat(ch1.lambdaThrowingAnException()).isEqualTo("bar");
    }
}