package com.example;

import com.example.event.OrderEvent;
import com.example.event.OrderEventFactory;
import com.example.handler.OrderEventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.util.concurrent.Executors;

public class DisruptorDemo {
    private static final Logger logger = LoggerFactory.getLogger(DisruptorDemo.class);
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws InterruptedException {
        // Create a Disruptor with a RingBuffer of size 1024
        Disruptor<OrderEvent> disruptor = new Disruptor<>(
                new OrderEventFactory(),
                BUFFER_SIZE,
                DaemonThreadFactory.INSTANCE);

        // Connect the handlers
        disruptor.handleEventsWith(
                new OrderEventHandler("Handler1"),
                new OrderEventHandler("Handler2"),
                new OrderEventHandler("Handler3")
        );

        // Start the Disruptor
        disruptor.start();

        // Get the ring buffer from the Disruptor
        RingBuffer<OrderEvent> ringBuffer = disruptor.getRingBuffer();

        // Create a producer that will publish events
        OrderEventProducer producer = new OrderEventProducer(ringBuffer);

        // Publish some events
        for (int i = 0; i < 10; i++) {
            producer.onData(i, "Product-" + i, 100.0 + i, i + 1);
            Thread.sleep(100); // Simulate some delay between events
        }

        // Shutdown the Disruptor
        disruptor.shutdown();
    }
}

class OrderEventProducer {
    private final RingBuffer<OrderEvent> ringBuffer;

    public OrderEventProducer(RingBuffer<OrderEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(long orderId, String productName, double price, int quantity) {
        long sequence = ringBuffer.next();  // Grab the next sequence
        try {
            // Create a new OrderEvent record
            OrderEvent event = new OrderEvent(orderId, productName, price, quantity);
            // The event will be published to the ring buffer
            ringBuffer.publish(sequence);
        } finally {
            ringBuffer.publish(sequence); // Publish the event
        }
    }
} 