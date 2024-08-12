/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.util.Pools$Pool
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.util.Preconditions
 *  com.bumptech.glide.util.pool.FactoryPools
 *  com.bumptech.glide.util.pool.FactoryPools$Factory
 *  com.bumptech.glide.util.pool.FactoryPools$Poolable
 *  com.bumptech.glide.util.pool.StateVerifier
 */
package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;

final class LockedResource<Z>
implements Resource<Z>,
FactoryPools.Poolable {
    private static final Pools.Pool<LockedResource<?>> POOL = FactoryPools.threadSafe((int)20, (FactoryPools.Factory)new /* Unavailable Anonymous Inner Class!! */);
    private boolean isLocked;
    private boolean isRecycled;
    private final StateVerifier stateVerifier = StateVerifier.newInstance();
    private Resource<Z> toWrap;

    LockedResource() {
    }

    private void init(Resource<Z> resource) {
        this.isRecycled = false;
        this.isLocked = true;
        this.toWrap = resource;
    }

    static <Z> LockedResource<Z> obtain(Resource<Z> resource) {
        LockedResource lockedResource = (LockedResource)Preconditions.checkNotNull((Object)((LockedResource)POOL.acquire()));
        lockedResource.init(resource);
        return lockedResource;
    }

    private void release() {
        this.toWrap = null;
        POOL.release((Object)this);
    }

    public Z get() {
        return (Z)this.toWrap.get();
    }

    public Class<Z> getResourceClass() {
        return this.toWrap.getResourceClass();
    }

    public int getSize() {
        return this.toWrap.getSize();
    }

    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    public void recycle() {
        synchronized (this) {
            this.stateVerifier.throwIfRecycled();
            this.isRecycled = true;
            if (this.isLocked) return;
            this.toWrap.recycle();
            this.release();
            return;
        }
    }

    void unlock() {
        synchronized (this) {
            this.stateVerifier.throwIfRecycled();
            if (this.isLocked) {
                this.isLocked = false;
                if (!this.isRecycled) return;
                this.recycle();
                return;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Already unlocked");
            throw illegalStateException;
        }
    }
}
