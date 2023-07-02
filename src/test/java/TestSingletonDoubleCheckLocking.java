import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TestSingletonDoubleCheckLocking {
    @Test
    public void testWithSingleThread() {
        Set<OracleDBDoubleCheckLocking> instances = new HashSet<>();

        for (int i = 0; i < 100; i++) {
            instances.add(OracleDBDoubleCheckLocking.getInstance());
        }

        Assertions.assertEquals(1, instances.size());
    }

    @Test
    public void testWithMultiThread() throws InterruptedException {
        Set<OracleDBDoubleCheckLocking> instances = Collections.synchronizedSet(new HashSet<>());

        // Create Runnable Class.
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                instances.add(OracleDBDoubleCheckLocking.getInstance());
            }
        };

        // Create 1000 Threads.
        final int numberOfThreads = 1000;
        Thread[] threads = new Thread[numberOfThreads];

        for (int index = 0; index < numberOfThreads; index++) {
            threads[index] = new Thread(runnable);
            threads[index].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        Assertions.assertEquals(1, instances.size());

    }
}
