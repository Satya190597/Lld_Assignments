import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TestSingletonSingleThread {
    @Test
    public void testSingletonWithSingleThread() {
        Set<OracleDB> instances = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            instances.add(OracleDB.getInstance());
        }
        Assertions.assertEquals(1, instances.size());
    }

    @Test
    public void testSingletonWithMultiThreadFail() throws InterruptedException {
        Set<OracleDB> instances = Collections.synchronizedSet(new HashSet<>());

        // Create runnable class.
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                instances.add(OracleDB.getInstance());
            }
        };

        // Create 1000 Threads.
        final int numberOfThreads = 10000;
        Thread[] threads = new Thread[numberOfThreads];

        for (int index = 0; index < numberOfThreads; index++) {
            threads[index] = new Thread(runnable);
            threads[index].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Number Of Threads " + instances.size());

        Assertions.assertTrue(instances.size() >= 1);
    }
}
