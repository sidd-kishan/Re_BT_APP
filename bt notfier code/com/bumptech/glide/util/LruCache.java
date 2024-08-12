/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<T, Y> {
    private final Map<T, Y> cache = new LinkedHashMap<T, Y>(100, 0.75f, true);
    private long currentSize;
    private final long initialMaxSize;
    private long maxSize;

    public LruCache(long l) {
        this.initialMaxSize = l;
        this.maxSize = l;
    }

    private void evict() {
        this.trimToSize(this.maxSize);
    }

    public void clearMemory() {
        this.trimToSize(0L);
    }

    public boolean contains(T t) {
        synchronized (this) {
            boolean bl = this.cache.containsKey(t);
            return bl;
        }
    }

    public Y get(T object) {
        synchronized (this) {
            object = this.cache.get(object);
        }
        return (Y)object;
    }

    protected int getCount() {
        synchronized (this) {
            int n = this.cache.size();
            return n;
        }
    }

    public long getCurrentSize() {
        synchronized (this) {
            long l = this.currentSize;
            return l;
        }
    }

    public long getMaxSize() {
        synchronized (this) {
            long l = this.maxSize;
            return l;
        }
    }

    protected int getSize(Y y) {
        return 1;
    }

    protected void onItemEvicted(T t, Y y) {
    }

    public Y put(T t, Y y) {
        Y y2;
        synchronized (this) {
            long l = this.getSize(y);
            if (l >= this.maxSize) {
                this.onItemEvicted(t, y);
                return null;
            }
            if (y != null) {
                this.currentSize += l;
            }
            if ((y2 = this.cache.put(t, y)) != null) {
                this.currentSize -= (long)this.getSize(y2);
                if (!y2.equals(y)) {
                    this.onItemEvicted(t, y2);
                }
            }
            this.evict();
        }
        return y2;
    }

    public Y remove(T object) {
        synchronized (this) {
            object = this.cache.remove(object);
            if (object == null) return (Y)object;
            this.currentSize -= (long)this.getSize(object);
        }
        return (Y)object;
    }

    /*
     * Unable to fully structure code
     */
    public void setSizeMultiplier(float var1_1) {
        synchronized (this) {
            if (var1_1 < 0.0f) ** GOTO lbl7
            try {
                this.maxSize = Math.round((float)this.initialMaxSize * var1_1);
                this.evict();
                return;
lbl7:
                // 1 sources

                var2_3 = new IllegalArgumentException("Multiplier must be >= 0");
                throw var2_3;
            }
            catch (Throwable var2_2) {}
            throw var2_2;
        }
    }

    protected void trimToSize(long l) {
        synchronized (this) {
            try {
                while (this.currentSize > l) {
                    Iterator<Map.Entry<T, Y>> iterator = this.cache.entrySet().iterator();
                    Map.Entry<Object, Object> entry = iterator.next();
                    Y y = entry.getValue();
                    this.currentSize -= (long)this.getSize(y);
                    entry = entry.getKey();
                    iterator.remove();
                    this.onItemEvicted(entry, y);
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }
}
