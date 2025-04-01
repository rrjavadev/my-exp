package com.example;

import com.example.event.OrderEvent;
import com.example.event.OrderEventFactory;
import com.example.handler.OrderEventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DisruptorDemoTest {

    @Mock
    private OrderEventHandler handler1;

    @Mock
    private OrderEventHandler handler2;

    @Test
    void testDisruptorProcessing() throws InterruptedException {
        // Arrange
        int bufferSize = 4;
        com.lmax.disruptor.dsl.Disruptor<OrderEvent> disruptor = new com.lmax.disruptor.dsl.Disruptor<>(
                new OrderEventFactory(),
                bufferSize, DaemonThreadFactory.INSTANCE
        );

        CountDownLatch latch = new CountDownLatch(2);
        OrderEventHandler testHandler = new OrderEventHandler("TestHandler") {
            @Override
            public void onEvent(OrderEvent event, long sequence, boolean endOfBatch) {
                latch.countDown();
            }
        };

        disruptor.handleEventsWith(testHandler);
        disruptor.start();

        // Act
        RingBuffer<OrderEvent> ringBuffer = disruptor.getRingBuffer();
        OrderEventProducer producer = new OrderEventProducer(ringBuffer);
        
        producer.onData(1L, "Test Product", 100.0, 5);
        producer.onData(2L, "Test Product 2", 200.0, 10);

        // Assert
        assertTrue(latch.await(5, TimeUnit.SECONDS), "Events should be processed within 5 seconds");
        disruptor.shutdown();
    }

    @Test
    void testOrderEventProducer() {
        // Arrange
        RingBuffer<OrderEvent> ringBuffer = mock(RingBuffer.class);
        when(ringBuffer.next()).thenReturn(0L);
        OrderEventProducer producer = new OrderEventProducer(ringBuffer);

        // Act
        producer.onData(1L, "Test Product", 100.0, 5);

        // Assert
        verify(ringBuffer).next();
        verify(ringBuffer, times(2)).publish(0L);
    }

    @Test
    void testMultipleHandlers() throws InterruptedException {
        // Arrange
        int bufferSize = 4;
        com.lmax.disruptor.dsl.Disruptor<OrderEvent> disruptor = new com.lmax.disruptor.dsl.Disruptor<>(
                new OrderEventFactory(),
                bufferSize,
                DaemonThreadFactory.INSTANCE
        );

        CountDownLatch latch = new CountDownLatch(4); // 2 events * 2 handlers
        OrderEventHandler handler1 = new OrderEventHandler("Handler1") {
            @Override
            public void onEvent(OrderEvent event, long sequence, boolean endOfBatch) {
                latch.countDown();
            }
        };
        OrderEventHandler handler2 = new OrderEventHandler("Handler2") {
            @Override
            public void onEvent(OrderEvent event, long sequence, boolean endOfBatch) {
                latch.countDown();
            }
        };

        disruptor.handleEventsWith(handler1, handler2);
        disruptor.start();

        // Act
        RingBuffer<OrderEvent> ringBuffer = disruptor.getRingBuffer();
        OrderEventProducer producer = new OrderEventProducer(ringBuffer);
        
        producer.onData(1L, "Test Product", 100.0, 5);
        producer.onData(2L, "Test Product 2", 200.0, 10);

        // Assert
        assertTrue(latch.await(5, TimeUnit.SECONDS), "All events should be processed by both handlers within 5 seconds");
        disruptor.shutdown();
    }
} 