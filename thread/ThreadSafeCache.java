package newreview.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Author : dong
 * Time:2019/8/2
 */

/**
 * 读写锁Map
 */
public class ThreadSafeCache {
    private Map<String,String> map = new HashMap<>();
    private ReentrantReadWriteLock reentrantReadWriteLock
            = new ReentrantReadWriteLock();

    public String getValue(String key) {
        reentrantReadWriteLock.readLock();
        return map.get(key);
    }

    public void setValue(String key,String value) {
        reentrantReadWriteLock.writeLock();
        map.put(key,value);
    }

}
