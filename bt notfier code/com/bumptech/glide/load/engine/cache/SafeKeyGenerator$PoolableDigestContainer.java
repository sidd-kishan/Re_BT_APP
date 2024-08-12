/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.util.pool.FactoryPools$Poolable
 *  com.bumptech.glide.util.pool.StateVerifier
 */
package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.security.MessageDigest;

private static final class SafeKeyGenerator.PoolableDigestContainer
implements FactoryPools.Poolable {
    final MessageDigest messageDigest;
    private final StateVerifier stateVerifier = StateVerifier.newInstance();

    SafeKeyGenerator.PoolableDigestContainer(MessageDigest messageDigest) {
        this.messageDigest = messageDigest;
    }

    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }
}
