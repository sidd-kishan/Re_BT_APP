/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.collection.ArrayMap
 *  com.bumptech.glide.util.MultiClassKey
 */
package com.bumptech.glide.provider;

import androidx.collection.ArrayMap;
import com.bumptech.glide.util.MultiClassKey;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ModelToResourceClassCache {
    private final ArrayMap<MultiClassKey, List<Class<?>>> registeredResourceClassCache;
    private final AtomicReference<MultiClassKey> resourceClassKeyRef = new AtomicReference();

    public ModelToResourceClassCache() {
        this.registeredResourceClassCache = new ArrayMap();
    }

    public void clear() {
        ArrayMap<MultiClassKey, List<Class<?>>> arrayMap = this.registeredResourceClassCache;
        synchronized (arrayMap) {
            this.registeredResourceClassCache.clear();
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public List<Class<?>> get(Class<?> multiClassKey, Class<?> clazz) {
        Object object = this.resourceClassKeyRef.getAndSet(null);
        if (object == null) {
            multiClassKey = new MultiClassKey(multiClassKey, clazz);
        } else {
            object.set(multiClassKey, clazz);
            multiClassKey = object;
        }
        clazz = this.registeredResourceClassCache;
        synchronized (clazz) {
            object = (List)this.registeredResourceClassCache.get((Object)multiClassKey);
        }
        this.resourceClassKeyRef.set(multiClassKey);
        return object;
    }

    public void put(Class<?> clazz, Class<?> clazz2, List<Class<?>> list) {
        ArrayMap<MultiClassKey, List<Class<?>>> arrayMap = this.registeredResourceClassCache;
        synchronized (arrayMap) {
            ArrayMap<MultiClassKey, List<Class<?>>> arrayMap2 = this.registeredResourceClassCache;
            MultiClassKey multiClassKey = new MultiClassKey(clazz, clazz2);
            arrayMap2.put((Object)multiClassKey, list);
            return;
        }
    }
}
