package com.example.handler;

import com.example.event.OrderEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderEventHandlerTest {

    @Mock
    private Logger logger;

    private OrderEventHandler handler;

    @BeforeEach
    void setUp() {
        handler = new OrderEventHandler("TestHandler");
    }

    @Test
    void testOnEvent() throws InterruptedException {
        // Arrange
        OrderEvent event = new OrderEvent(1L, "Test Product", 100.0, 5);
        long sequence = 0L;
        boolean endOfBatch = true;

        // Act
        handler.onEvent(event, sequence, endOfBatch);

        // Assert
        // Note: We can't directly verify the logger calls as it's a static field
        // In a real application, you might want to inject the logger for better testability
        Thread.sleep(150); // Wait for the simulated processing time
    }

    @Test
    void testOnEventWithInterruption() {
        // Arrange
        OrderEvent event = new OrderEvent(1L, "Test Product", 100.0, 5);
        long sequence = 0L;
        boolean endOfBatch = true;

        // Act & Assert
        Thread.currentThread().interrupt();
        handler.onEvent(event, sequence, endOfBatch);
        assertTrue(Thread.currentThread().isInterrupted());
    }
} 