import java.io.File;
import java.util.Arrays;
import java.util.concurrent.Callable;

/**
 * Created by sch3lp on 20/09/15.
 */
public class Ch1 {

    private String barString;

    public Ch1() {
    }

    public void cocktail(String bar){
        this.barString = bar;
    }

    public String lambdaThrowingAnException() throws InterruptedException {
//        Runnable sleeper = () -> Thread.sleep(1000); // Runnable interface does not throw an exception
        RunnableExceptionThrower sleeper = () -> Thread.sleep(1000);
        Callable sleeper2 = () -> { Thread.sleep(1000); return null; };
        return barString;
    }

    public BarName[] methodRefs(String... strings){
        return Arrays.asList(strings)
                .stream()
                .map(BarName::new)
                .toArray(BarName[]::new);
    }

    public static File[] subdirs(File dir){
//        return dir.listFiles((path) -> path.isDirectory());
        return dir.listFiles(File::isDirectory);
    }

    public static File[] filteredFiles(File dir, String extension) {
        return dir.listFiles((file) -> file.getAbsolutePath().endsWith(extension));
    }

    public static Runnable andThen(Runnable... runnables){
        return () -> Arrays.asList(runnables).forEach(Runnable::run);
    }
}
