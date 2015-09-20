package chapter2;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by sch3lp on 20/09/15.
 */
public class Ch2 {

    static Logger logger = Logger.getAnonymousLogger();

    public static void logIf(Level level, Supplier<Boolean> extraCondition, Supplier<String> log){
        if (extraCondition.get()) {
            logger.log(level, log);
        }
    }
}
