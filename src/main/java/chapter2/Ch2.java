package chapter2;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import sun.reflect.Reflection;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by sch3lp on 20/09/15.
 */
public class Ch2 {

    private Logger logger = null;

    public Ch2(Logger logger) {
        this.logger = logger;
    }

    public void logIf(Level level, Supplier<Boolean> extraCondition, Supplier<String> log) {
        if (extraCondition.get()) {
            logger.log(level, log);
        }
    }

    public static void withLock(ReentrantLock reentrantLock, Supplier<String> action) {
        reentrantLock.lock();
        try {
            action.get();
        } finally {
            reentrantLock.unlock();
        }
    }

    public static Comparator lexicographicComparator(String... fieldNames) throws NoSuchFieldException {
        // for every fieldName, create a comparator that compares value by reflection and combine them into one by reducing with Comparator.thenComparing()
        return Arrays.asList(fieldNames)
                .stream()
                .map((fieldName) -> Comparator.comparing(new Function() {
                    @Override
                    public Object apply(Object o) {
                        try {
                            return o.getClass().getField(fieldName).get(o);
                        } catch (NoSuchFieldException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
                }))
                .reduce((o1,o2)->0, Comparator::thenComparing);
//                    why doesn't this compile?!
//                    return Comparator.comparing((o) -> {
//                        try {
//                            return o.getClass().getField(fieldName).get(o);
//                        } catch (NoSuchFieldException | IllegalAccessException e) {
//                            e.printStackTrace();
//                        }
//                        return null;
//                    });


    }
}
