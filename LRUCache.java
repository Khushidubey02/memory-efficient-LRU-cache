import java.util.*;

class LRUCache {
    int capacity;
    LinkedHashMap<Integer, Integer> cache;

    LRUCache(int cap) {
        capacity = cap;
        cache = new LinkedHashMap<>(cap, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    void put(int key, int value) {
        cache.put(key, value);
    }

    int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    void show() {
        System.out.println("Cache: " + cache);
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(3);
        lru.put(1, 100);
        lru.put(2, 200);
        lru.put(3, 300);
        lru.show();
        lru.get(2);
        lru.put(4, 400);
        lru.show();
    }
}