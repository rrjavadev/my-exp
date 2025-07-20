package lru;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    @Test
    void shouldRemoveOldestEntryWhenCacheIsFull() {
        // Given
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1); // Cache: {1=1}
        cache.put(2, 2); // Cache: {1=1, 2=2}

        // When
        cache.put(3, 3); // This should evict key 1

        // Then
        assertNull(cache.get(1)); // Key 1 should be evicted
        assertEquals(2, cache.get(2)); // Key 2 should still be present
        assertEquals(3, cache.get(3)); // Key 3 should be present
    }

}