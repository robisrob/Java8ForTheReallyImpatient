import org.junit.Test;

import java.io.File;

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

    @Test
    public void subdirs_ReturnsAllSubdirsOfAGivenDirectory() throws Exception {
        File[] subdirs = Ch1.subdirs(new File("/home/sch3lp/ws/personal/"));
        assertThat(subdirs).contains(new File("/home/sch3lp/ws/personal/blog"), new File("/home/sch3lp/ws/personal/derpingWithJava8"), new File("/home/sch3lp/ws/personal/fiantje"), new File("/home/sch3lp/ws/personal/forks"));
    }
}