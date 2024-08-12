/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
 *  com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
 *  com.bumptech.glide.load.engine.bitmap_recycle.ByteArrayAdapter
 *  com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap
 *  com.bumptech.glide.load.engine.bitmap_recycle.IntegerArrayAdapter
 *  com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool$Key
 *  com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool$KeyPool
 *  com.bumptech.glide.load.engine.bitmap_recycle.Poolable
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.ByteArrayAdapter;
import com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap;
import com.bumptech.glide.load.engine.bitmap_recycle.IntegerArrayAdapter;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import com.bumptech.glide.util.Preconditions;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class LruArrayPool
implements ArrayPool {
    private static final int DEFAULT_SIZE = 0x400000;
    static final int MAX_OVER_SIZE_MULTIPLE = 8;
    private static final int SINGLE_ARRAY_MAX_SIZE_DIVISOR = 2;
    private final Map<Class<?>, ArrayAdapterInterface<?>> adapters;
    private int currentSize;
    private final GroupedLinkedMap<Key, Object> groupedMap = new GroupedLinkedMap();
    private final KeyPool keyPool = new KeyPool();
    private final int maxSize;
    private final Map<Class<?>, NavigableMap<Integer, Integer>> sortedSizes = new HashMap();

    public LruArrayPool() {
        this.adapters = new HashMap();
        this.maxSize = 0x400000;
    }

    public LruArrayPool(int n) {
        this.adapters = new HashMap();
        this.maxSize = n;
    }

    private void decrementArrayOfSize(int n, Class<?> serializable) {
        NavigableMap<Integer, Integer> navigableMap = this.getSizesForAdapter((Class<?>)serializable);
        if ((serializable = (Integer)navigableMap.get(n)) == null) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("Tried to decrement empty size, size: ");
            ((StringBuilder)serializable).append(n);
            ((StringBuilder)serializable).append(", this: ");
            ((StringBuilder)serializable).append(this);
            throw new NullPointerException(((StringBuilder)serializable).toString());
        }
        if ((Integer)serializable == 1) {
            navigableMap.remove(n);
        } else {
            navigableMap.put(n, (Integer)serializable - 1);
        }
    }

    private void evict() {
        this.evictToSize(this.maxSize);
    }

    private void evictToSize(int n) {
        while (this.currentSize > n) {
            Object object = this.groupedMap.removeLast();
            Preconditions.checkNotNull((Object)object);
            ArrayAdapterInterface<Object> arrayAdapterInterface = this.getAdapterFromObject(object);
            this.currentSize -= arrayAdapterInterface.getArrayLength(object) * arrayAdapterInterface.getElementSizeInBytes();
            this.decrementArrayOfSize(arrayAdapterInterface.getArrayLength(object), object.getClass());
            if (!Log.isLoggable((String)arrayAdapterInterface.getTag(), (int)2)) continue;
            String string = arrayAdapterInterface.getTag();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("evicted: ");
            stringBuilder.append(arrayAdapterInterface.getArrayLength(object));
            Log.v((String)string, (String)stringBuilder.toString());
        }
    }

    private <T> ArrayAdapterInterface<T> getAdapterFromObject(T t) {
        return this.getAdapterFromType(t.getClass());
    }

    private <T> ArrayAdapterInterface<T> getAdapterFromType(Class<T> clazz) {
        IntegerArrayAdapter integerArrayAdapter = this.adapters.get(clazz);
        Object object = integerArrayAdapter;
        if (integerArrayAdapter != null) return object;
        if (clazz.equals(int[].class)) {
            object = new IntegerArrayAdapter();
        } else {
            if (!clazz.equals(byte[].class)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("No array pool found for: ");
                ((StringBuilder)object).append(clazz.getSimpleName());
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
            object = new ByteArrayAdapter();
        }
        this.adapters.put(clazz, (ArrayAdapterInterface<?>)object);
        return object;
    }

    private <T> T getArrayForKey(Key key) {
        return (T)this.groupedMap.get((Poolable)key);
    }

    private <T> T getForKey(Key key, Class<T> object) {
        ArrayAdapterInterface<T> arrayAdapterInterface = this.getAdapterFromType((Class<T>)object);
        Object object2 = this.getArrayForKey(key);
        if (object2 != null) {
            this.currentSize -= arrayAdapterInterface.getArrayLength(object2) * arrayAdapterInterface.getElementSizeInBytes();
            this.decrementArrayOfSize(arrayAdapterInterface.getArrayLength(object2), (Class<?>)object);
        }
        object = object2;
        if (object2 != null) return (T)object;
        if (Log.isLoggable((String)arrayAdapterInterface.getTag(), (int)2)) {
            object2 = arrayAdapterInterface.getTag();
            object = new StringBuilder();
            ((StringBuilder)object).append("Allocated ");
            ((StringBuilder)object).append(key.size);
            ((StringBuilder)object).append(" bytes");
            Log.v(object2, (String)((StringBuilder)object).toString());
        }
        object = arrayAdapterInterface.newArray(key.size);
        return (T)object;
    }

    private NavigableMap<Integer, Integer> getSizesForAdapter(Class<?> clazz) {
        NavigableMap<Integer, Integer> navigableMap;
        NavigableMap<Integer, Integer> navigableMap2 = navigableMap = this.sortedSizes.get(clazz);
        if (navigableMap != null) return navigableMap2;
        navigableMap2 = new TreeMap<Integer, Integer>();
        this.sortedSizes.put(clazz, navigableMap2);
        return navigableMap2;
    }

    private boolean isNoMoreThanHalfFull() {
        int n = this.currentSize;
        boolean bl = n == 0 || this.maxSize / n >= 2;
        return bl;
    }

    private boolean isSmallEnoughForReuse(int n) {
        boolean bl = n <= this.maxSize / 2;
        return bl;
    }

    private boolean mayFillRequest(int n, Integer n2) {
        boolean bl = n2 != null && (this.isNoMoreThanHalfFull() || n2 <= n * 8);
        return bl;
    }

    public void clearMemory() {
        synchronized (this) {
            this.evictToSize(0);
            return;
        }
    }

    public <T> T get(int n, Class<T> clazz) {
        synchronized (this) {
            Integer n2 = this.getSizesForAdapter(clazz).ceilingKey(n);
            n2 = this.mayFillRequest(n, n2) ? this.keyPool.get(n2.intValue(), clazz) : this.keyPool.get(n, clazz);
            clazz = this.getForKey((Key)n2, clazz);
        }
        return (T)clazz;
    }

    int getCurrentSize() {
        Iterator<Class<?>> iterator = this.sortedSizes.keySet().iterator();
        int n = 0;
        block0: while (iterator.hasNext()) {
            Class<?> clazz = iterator.next();
            Iterator iterator2 = this.sortedSizes.get(clazz).keySet().iterator();
            int n2 = n;
            while (true) {
                n = n2;
                if (!iterator2.hasNext()) continue block0;
                Integer n3 = (Integer)iterator2.next();
                ArrayAdapterInterface<?> arrayAdapterInterface = this.getAdapterFromType(clazz);
                n2 += n3 * (Integer)this.sortedSizes.get(clazz).get(n3) * arrayAdapterInterface.getElementSizeInBytes();
            }
            break;
        }
        return n;
    }

    public <T> T getExact(int n, Class<T> clazz) {
        synchronized (this) {
            clazz = this.getForKey(this.keyPool.get(n, clazz), clazz);
        }
        return (T)clazz;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public <T> void put(T object) {
        synchronized (this) {
            Serializable serializable = object.getClass();
            Key key = this.getAdapterFromType((Class<T>)serializable);
            int n = key.getArrayLength(object);
            int n2 = key.getElementSizeInBytes() * n;
            boolean bl = this.isSmallEnoughForReuse(n2);
            if (!bl) {
                return;
            }
            key = this.keyPool.get(n, serializable);
            this.groupedMap.put((Poolable)key, object);
            object = this.getSizesForAdapter((Class<?>)serializable);
            serializable = (Integer)object.get(key.size);
            int n3 = key.size;
            n = 1;
            if (serializable != null) {
                n = 1 + (Integer)serializable;
            }
            object.put(n3, n);
            this.currentSize += n2;
            this.evict();
            return;
        }
    }

    @Deprecated
    public <T> void put(T t, Class<T> clazz) {
        this.put(t);
    }

    /*
     * Unable to fully structure code
     */
    public void trimMemory(int var1_1) {
        synchronized (this) {
            block3: {
                if (var1_1 < 40) ** GOTO lbl6
                try {
                    this.clearMemory();
                    break block3;
lbl6:
                    // 1 sources

                    if (var1_1 < 20) return;
                    this.evictToSize(this.maxSize / 2);
                }
                catch (Throwable var2_2) {}
                throw var2_2;
            }
            return;
        }
    }
}
