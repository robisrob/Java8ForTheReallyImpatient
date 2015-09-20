package chapter2;

import java.util.concurrent.locks.ReentrantLock;
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

    public void logIf(Level level, Supplier<Boolean> extraCondition, Supplier<String> log){
        if (extraCondition.get()) {
            logger.log(level, log);
        }
    }

    public static void withLock(ReentrantLock reentrantLock, Supplier<String> action){
        reentrantLock.lock();
        try {
            action.get();
        } finally {
            reentrantLock.unlock();
        }
    }
}
