package chapter1;

import org.junit.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    public void filteredFiles_ReturnsAllFilesWithAGivenExtensionInAGivenDirectory() throws Exception {
        String blogPath = "/home/sch3lp/ws/personal/blog";
        File[] subdirs = Ch1.filteredFiles(new File(blogPath), ".md");
        assertThat(subdirs).contains(
                new File(blogPath + "/README.md"),
                new File(blogPath + "/about.md"),
                new File(blogPath + "/LICENSE.md")
        );
    }

    @Test
    public void andThen_RunsSecondAfterFirst() throws Exception {
        Ch1.andThen(()->System.out.println("first"), ()->System.out.println("second")).run();
    }

    @Test
    public void eight() throws Exception {
        StringBuilder actual = new StringBuilder("");
        Ch1.eight(actual).forEach(Runnable::run);
        assertThat(actual.toString()).isEqualTo("[Peter][Paul][Mary]");
    }
}