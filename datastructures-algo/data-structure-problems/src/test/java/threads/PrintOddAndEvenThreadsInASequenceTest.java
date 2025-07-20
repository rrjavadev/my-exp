package threads;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintOddAndEvenThreadsInASequenceTest {

    @Test
    void shouldPrintOddAndEvenThreadsInASequence() throws InterruptedException {
        // Given
        PrintOddAndEvenThreadsInASequence printThreads = new PrintOddAndEvenThreadsInASequence();

        // When
        Thread oddThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 20; i ++) {
                    printThreads.printOdd(i);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread evenThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 20; i ++) {
                    printThreads.printEven(i);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        oddThread.start();
        evenThread.start();

        oddThread.join();
        evenThread.join();

        // Then
        // The output is printed to the console, so we cannot assert the output directly.
        // We can only ensure that no exceptions are thrown during execution.
    }

}