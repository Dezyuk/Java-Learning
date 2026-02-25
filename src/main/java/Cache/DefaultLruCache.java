package Cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultLruCache extends LinkedHashMap<Integer, Integer> implements LruCache {
    private int capacity;


    public DefaultLruCache() {
        super(16, 0.75f, true);
    }

    public DefaultLruCache(int capacity) {
        super(16, 0.75f, true);
        this.capacity = capacity;
    }


    @Override
    public int get(int key) {
        Integer result = super.get(key);
        if (result == null) {
            return -1;
        }
        return result;
    }

    @Override
    public void put(int key, int value) {
        super.put(key,value);
    }

    @Override
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        if (size() > this.capacity) {
            return true;
        }
        return false;
    }
}
