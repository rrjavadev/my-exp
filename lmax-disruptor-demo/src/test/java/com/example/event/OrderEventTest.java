package com.example.event;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderEventTest {

    @Test
    void testOrderEventCreation() {
        OrderEvent event = new OrderEvent(1L, "Test Product", 100.0, 5);
        
        assertEquals(1L, event.orderId());
        assertEquals("Test Product", event.productName());
        assertEquals(100.0, event.price());
        assertEquals(5, event.quantity());
    }

    @Test
    void testOrderEventEquality() {
        OrderEvent event1 = new OrderEvent(1L, "Test Product", 100.0, 5);
        OrderEvent event2 = new OrderEvent(1L, "Test Product", 100.0, 5);
        OrderEvent event3 = new OrderEvent(2L, "Test Product", 100.0, 5);

        assertEquals(event1, event2);
        assertNotEquals(event1, event3);
    }

    @Test
    void testOrderEventToString() {
        OrderEvent event = new OrderEvent(1L, "Test Product", 100.0, 5);
        String expected = "OrderEvent[orderId=1, productName=Test Product, price=100.0, quantity=5]";
        assertEquals(expected, event.toString());
    }
} 