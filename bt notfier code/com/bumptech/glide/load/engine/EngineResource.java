/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.engine.EngineResource$ResourceListener
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.load.engine;

import android.os.Looper;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

class EngineResource<Z>
implements Resource<Z> {
    private int acquired;
    private final boolean isCacheable;
    private final boolean isRecyclable;
    private boolean isRecycled;
    private Key key;
    private ResourceListener listener;
    private final Resource<Z> resource;

    EngineResource(Resource<Z> resource, boolean bl, boolean bl2) {
        this.resource = (Resource)Preconditions.checkNotNull(resource);
        this.isCacheable = bl;
        this.isRecyclable = bl2;
    }

    void acquire() {
        if (this.isRecycled) throw new IllegalStateException("Cannot acquire a recycled resource");
        if (!Looper.getMainLooper().equals(Looper.myLooper())) throw new IllegalThreadStateException("Must call acquire on the main thread");
        ++this.acquired;
    }

    public Z get() {
        return (Z)this.resource.get();
    }

    Resource<Z> getResource() {
        return this.resource;
    }

    public Class<Z> getResourceClass() {
        return this.resource.getResourceClass();
    }

    public int getSize() {
        return this.resource.getSize();
    }

    boolean isCacheable() {
        return this.isCacheable;
    }

    public void recycle() {
        if (this.acquired > 0) throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        if (this.isRecycled) throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        this.isRecycled = true;
        if (!this.isRecyclable) return;
        this.resource.recycle();
    }

    void release() {
        int n;
        if (this.acquired <= 0) throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        if (!Looper.getMainLooper().equals(Looper.myLooper())) throw new IllegalThreadStateException("Must call release on the main thread");
        this.acquired = n = this.acquired - 1;
        if (n != 0) return;
        this.listener.onResourceReleased(this.key, this);
    }

    void setResourceListener(Key key, ResourceListener resourceListener) {
        this.key = key;
        this.listener = resourceListener;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EngineResource{isCacheable=");
        stringBuilder.append(this.isCacheable);
        stringBuilder.append(", listener=");
        stringBuilder.append(this.listener);
        stringBuilder.append(", key=");
        stringBuilder.append(this.key);
        stringBuilder.append(", acquired=");
        stringBuilder.append(this.acquired);
        stringBuilder.append(", isRecycled=");
        stringBuilder.append(this.isRecycled);
        stringBuilder.append(", resource=");
        stringBuilder.append(this.resource);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
