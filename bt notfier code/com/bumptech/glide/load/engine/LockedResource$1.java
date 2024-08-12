/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.engine.LockedResource
 *  com.bumptech.glide.util.pool.FactoryPools$Factory
 */
package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.LockedResource;
import com.bumptech.glide.util.pool.FactoryPools;

class LockedResource.1
implements FactoryPools.Factory<LockedResource<?>> {
    LockedResource.1() {
    }

    public LockedResource<?> create() {
        return new LockedResource();
    }
}
