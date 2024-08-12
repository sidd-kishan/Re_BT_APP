/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.engine.cache.SafeKeyGenerator
 *  com.bumptech.glide.load.engine.cache.SafeKeyGenerator$PoolableDigestContainer
 *  com.bumptech.glide.util.pool.FactoryPools$Factory
 */
package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.SafeKeyGenerator;
import com.bumptech.glide.util.pool.FactoryPools;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class SafeKeyGenerator.1
implements FactoryPools.Factory<SafeKeyGenerator.PoolableDigestContainer> {
    final SafeKeyGenerator this$0;

    SafeKeyGenerator.1(SafeKeyGenerator safeKeyGenerator) {
        this.this$0 = safeKeyGenerator;
    }

    public SafeKeyGenerator.PoolableDigestContainer create() {
        try {
            SafeKeyGenerator.PoolableDigestContainer poolableDigestContainer = new SafeKeyGenerator.PoolableDigestContainer(MessageDigest.getInstance("SHA-256"));
            return poolableDigestContainer;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new RuntimeException(noSuchAlgorithmException);
        }
    }
}
