/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.engine.EngineJob
 *  com.bumptech.glide.request.ResourceCallback
 */
package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.EngineJob;
import com.bumptech.glide.request.ResourceCallback;

public static class Engine.LoadStatus {
    private final ResourceCallback cb;
    private final EngineJob<?> engineJob;

    Engine.LoadStatus(ResourceCallback resourceCallback, EngineJob<?> engineJob) {
        this.cb = resourceCallback;
        this.engineJob = engineJob;
    }

    public void cancel() {
        this.engineJob.removeCallback(this.cb);
    }
}
