package chapter2;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;


public class Ch2Test {

    @Test
    public void logIf_OnlyLogsIfLevelIsAppropriate() throws Exception {
        final boolean[] fineWasLogged = {false};
        final boolean[] infoWasLogged = {false};
        Logger ch2Logger = Logger.getLogger("Ch2Logger");
        ch2Logger.setLevel(Level.INFO);
        Ch2 ch2 = new Ch2(ch2Logger);
        ch2.logIf(Level.INFO, () -> false, () -> {
            fineWasLogged[0] = true;
            return "fine should not be logged";
        });
        ch2.logIf(Level.INFO, () -> true, () -> {
            infoWasLogged[0] = true;
            return "info should be logged";
        });
        assertThat(fineWasLogged[0]).isFalse();
        assertThat(infoWasLogged[0]).isTrue();
    }

    @Test
    public void withLock_WrapsAnActionWithLockUnlock() throws Exception {
        List<String> verifyActions = new ArrayList<>();
        ReentrantLock myLock = new ReentrantLock() {
            @Override
            public void lock() {
                verifyActions.add("lockCalled");
            }

            @Override
            public void unlock() {
                verifyActions.add("unlockCalled");
            }
        };
        Ch2.withLock(myLock, () -> {
            verifyActions.add("doing some private business");
            return "doing some private business";
        });
        assertThat(verifyActions).containsExactly("lockCalled", "doing some private business", "unlockCalled");
    }

    @Test
    public void lexicographicComparator_ComparesGivenFieldnamesByReflectionInOrder() throws Exception {
        Person tims = new Person("tim", "schraepen");
        Person timdm = new Person("tim", "demeyer");
        Person elkes = new Person("elke", "schraepen");
        Comparator comp = Ch2.lexicographicComparator("lastName", "firstName");
        assertThat(comp.compare(tims, timdm)).isEqualTo(-1);
        assertThat(comp.compare(tims, elkes)).isEqualTo(-1);
        assertThat(comp.compare(timdm, elkes)).isEqualTo(-2);
        assertThat(comp.compare(tims, tims)).isEqualTo(0);
    }

    public class Person{
        public String firstName;
        public String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
    }
}