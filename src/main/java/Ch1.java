import java.util.concurrent.Callable;

/**
 * Created by sch3lp on 20/09/15.
 */
public class Ch1 {

    private String bar;

    public Ch1() {
    }

    public void cocktail(String bar){
        this.bar = bar;
    }

    public String getBar() throws InterruptedException {
//        Runnable sleeper = () -> Thread.sleep(1000); // Runnable interface does not throw an exception
        RunnableExceptionThrower sleeper = () -> Thread.sleep(1000);
        sleeper.run();
        Callable sleeper2 = () -> { Thread.sleep(1000); return null; };
        return bar;
    }

}
