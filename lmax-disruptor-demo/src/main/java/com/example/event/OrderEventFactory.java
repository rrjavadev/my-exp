package com.example.event;

import com.lmax.disruptor.EventFactory;

public class OrderEventFactory implements EventFactory<OrderEvent> {
    @Override
    public OrderEvent newInstance() {
        // Create a default event with dummy values
        // These will be replaced when the event is actually used
        return new OrderEvent(0L, "", 0.0, 0);
    }
} 