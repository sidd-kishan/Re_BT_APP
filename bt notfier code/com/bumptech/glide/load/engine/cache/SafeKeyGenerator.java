/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.util.Pools$Pool
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.engine.cache.SafeKeyGenerator$PoolableDigestContainer
 *  com.bumptech.glide.util.LruCache
 *  com.bumptech.glide.util.Preconditions
 *  com.bumptech.glide.util.Util
 *  com.bumptech.glide.util.pool.FactoryPools
 *  com.bumptech.glide.util.pool.FactoryPools$Factory
 */
package com.bumptech.glide.load.engine.cache;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.SafeKeyGenerator;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;

public class SafeKeyGenerator {
    private final Pools.Pool<PoolableDigestContainer> digestPool;
    private final LruCache<Key, String> loadIdToSafeHash = new LruCache(1000L);

    public SafeKeyGenerator() {
        this.digestPool = FactoryPools.threadSafe((int)10, (FactoryPools.Factory)new /* Unavailable Anonymous Inner Class!! */);
    }

    private String calculateHexStringDigest(Key object) {
        PoolableDigestContainer poolableDigestContainer = (PoolableDigestContainer)Preconditions.checkNotNull((Object)this.digestPool.acquire());
        try {
            object.updateDiskCacheKey(poolableDigestContainer.messageDigest);
            object = Util.sha256BytesToHex((byte[])poolableDigestContainer.messageDigest.digest());
            return object;
        }
        finally {
            this.digestPool.release((Object)poolableDigestContainer);
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public String getSafeKey(Key key) {
        LruCache<Key, String> lruCache;
        Object object = this.loadIdToSafeHash;
        synchronized (object) {
            lruCache = (LruCache<Key, String>)this.loadIdToSafeHash.get((Object)key);
        }
        object = lruCache;
        if (lruCache == null) {
            object = this.calculateHexStringDigest(key);
        }
        lruCache = this.loadIdToSafeHash;
        synchronized (lruCache) {
            this.loadIdToSafeHash.put((Object)key, object);
            return object;
        }
    }
}
