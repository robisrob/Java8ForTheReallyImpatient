package chapter2;

import org.junit.Test;

import java.util.logging.Level;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class Ch2Test {

    @Test
    public void logIf_OnlyLogsIfLevelIsAppropriate() throws Exception {
        final boolean[] fineWasLogged = {false};
        final boolean[] infoWasLogged = {false};
        Ch2.logger.setLevel(Level.INFO);
        Ch2.logIf(Level.INFO, () -> false, () -> {
            fineWasLogged[0] = true;
            return "fine should not be logged";
        });
        Ch2.logIf(Level.INFO, () -> true, () -> {
            infoWasLogged[0] = true;
            return "info should be logged";
        });
        assertThat(fineWasLogged[0]).isFalse();
        assertThat(infoWasLogged[0]).isTrue();
    }
}