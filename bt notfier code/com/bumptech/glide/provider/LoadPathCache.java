/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.collection.ArrayMap
 *  com.bumptech.glide.load.engine.DecodePath
 *  com.bumptech.glide.load.engine.LoadPath
 *  com.bumptech.glide.load.resource.transcode.ResourceTranscoder
 *  com.bumptech.glide.load.resource.transcode.UnitTranscoder
 *  com.bumptech.glide.util.MultiClassKey
 */
package com.bumptech.glide.provider;

import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.UnitTranscoder;
import com.bumptech.glide.util.MultiClassKey;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

public class LoadPathCache {
    private static final LoadPath<?, ?, ?> NO_PATHS_SIGNAL = new LoadPath(Object.class, Object.class, Object.class, Collections.singletonList(new DecodePath(Object.class, Object.class, Object.class, Collections.emptyList(), (ResourceTranscoder)new UnitTranscoder(), null)), null);
    private final ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> cache = new ArrayMap();
    private final AtomicReference<MultiClassKey> keyRef = new AtomicReference();

    private MultiClassKey getKey(Class<?> clazz, Class<?> clazz2, Class<?> clazz3) {
        MultiClassKey multiClassKey;
        MultiClassKey multiClassKey2 = multiClassKey = (MultiClassKey)this.keyRef.getAndSet(null);
        if (multiClassKey == null) {
            multiClassKey2 = new MultiClassKey();
        }
        multiClassKey2.set(clazz, clazz2, clazz3);
        return multiClassKey2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> get(Class<Data> clazz, Class<TResource> multiClassKey, Class<Transcode> loadPath) {
        multiClassKey = this.getKey(clazz, (Class<?>)multiClassKey, (Class<?>)loadPath);
        clazz = this.cache;
        synchronized (clazz) {
            loadPath = (LoadPath)this.cache.get((Object)multiClassKey);
        }
        this.keyRef.set(multiClassKey);
        return loadPath;
    }

    public boolean isEmptyLoadPath(LoadPath<?, ?, ?> loadPath) {
        return NO_PATHS_SIGNAL.equals(loadPath);
    }

    public void put(Class<?> clazz, Class<?> clazz2, Class<?> clazz3, LoadPath<?, ?, ?> loadPath) {
        ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> arrayMap = this.cache;
        synchronized (arrayMap) {
            ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> arrayMap2 = this.cache;
            MultiClassKey multiClassKey = new MultiClassKey(clazz, clazz2, clazz3);
            if (loadPath == null) {
                loadPath = NO_PATHS_SIGNAL;
            }
            arrayMap2.put((Object)multiClassKey, loadPath);
            return;
        }
    }
}
