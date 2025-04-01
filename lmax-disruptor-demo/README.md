# LMAX Disruptor Demo

This project demonstrates the usage of the LMAX Disruptor library, which is a high-performance inter-thread messaging library. The demo shows how to implement a simple order processing system using the Disruptor pattern.

## Project Structure

- `OrderEvent.java` - The event class that holds order data
- `OrderEventFactory.java` - Factory class for creating OrderEvent instances
- `OrderEventHandler.java` - Handlers that process the events
- `DisruptorDemo.java` - Main class demonstrating the Disruptor pattern

## Key Concepts Demonstrated

1. **Ring Buffer**: A circular buffer that holds events
2. **Event Factory**: Creates new event instances
3. **Event Handlers**: Process events in parallel
4. **Producer**: Publishes events to the ring buffer
5. **Disruptor**: Orchestrates the event processing

## Running the Demo

1. Make sure you have Java 21 installed
2. Build the project:
   ```bash
   mvn clean package
   ```
3. Run the demo:
   ```bash
   mvn exec:java -Dexec.mainClass="com.example.DisruptorDemo"
   ```

## How It Works

1. The Disruptor is created with a ring buffer of size 1024
2. Two event handlers are registered to process events in parallel
3. The producer publishes 10 sample order events
4. Each event is processed by both handlers
5. The handlers simulate processing time with a 100ms delay

## Output

You should see log messages showing both handlers processing each event in parallel, demonstrating the high-performance nature of the Disruptor pattern.

## Key Benefits of LMAX Disruptor

1. **High Performance**: Zero contention between producers and consumers
2. **Low Latency**: Predictable latency for event processing
3. **Parallel Processing**: Multiple handlers can process events concurrently
4. **Memory Efficiency**: Reuses event objects to minimize garbage collection 