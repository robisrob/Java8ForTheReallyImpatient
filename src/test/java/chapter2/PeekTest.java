package chapter2;

import org.junit.Test;

import static org.junit.Assert.*;

public class PeekTest {

    @Test
    public void peekIsLazy() throws Exception {
        Peek.peek();
    }
}