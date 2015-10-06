package chapter3;

import org.junit.Test;

public class PeekTest {

    @Test
    public void peekIsLazy() throws Exception {
        Peek.peek();
    }
}