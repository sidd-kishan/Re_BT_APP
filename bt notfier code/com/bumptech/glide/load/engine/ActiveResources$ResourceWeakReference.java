/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.engine.EngineResource
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

static final class ActiveResources.ResourceWeakReference
extends WeakReference<EngineResource<?>> {
    final boolean isCacheable;
    final Key key;
    Resource<?> resource;

    ActiveResources.ResourceWeakReference(Key object, EngineResource<?> engineResource, ReferenceQueue<? super EngineResource<?>> referenceQueue, boolean bl) {
        super(engineResource, referenceQueue);
        this.key = (Key)Preconditions.checkNotNull((Object)object);
        object = engineResource.isCacheable() && bl ? (Resource)Preconditions.checkNotNull((Object)engineResource.getResource()) : null;
        this.resource = object;
        this.isCacheable = engineResource.isCacheable();
    }

    void reset() {
        this.resource = null;
        this.clear();
    }
}
