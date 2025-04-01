package com.example.handler;

import com.example.event.OrderEvent;
import com.lmax.disruptor.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderEventHandler implements EventHandler<OrderEvent> {
    private static final Logger logger = LoggerFactory.getLogger(OrderEventHandler.class);
    private final String handlerName;

    public OrderEventHandler(String handlerName) {
        this.handlerName = handlerName;
    }

    @Override
    public void onEvent(OrderEvent event, long sequence, boolean endOfBatch) {
        logger.info("Handler: {} - Processing event: orderId={}, product={}, price={}, quantity={}",
                handlerName,
                event.orderId(),
                event.productName(),
                event.price(),
                event.quantity());
        
        // Simulate some processing time
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
} 