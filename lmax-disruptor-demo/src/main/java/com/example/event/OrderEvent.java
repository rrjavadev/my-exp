package com.example.event;

public record OrderEvent(
    long orderId,
    String productName,
    double price,
    int quantity
) {
    // Records are immutable by default, so we don't need setters
    // The constructor is automatically generated
} 