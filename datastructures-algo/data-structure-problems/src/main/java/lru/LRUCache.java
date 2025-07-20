package lru;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LRUCache extends LinkedHashMap {
    int intialCapacity;
   public LRUCache(int capacity){
       super(capacity, 0.75f, true);
       intialCapacity = capacity;
   }

   @Override
   protected boolean removeEldestEntry(java.util.Map.Entry eldest) {
        return size() > intialCapacity ;
    }
}
