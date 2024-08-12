/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.engine.EngineJob
 */
package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.EngineJob;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class Jobs {
    private final Map<Key, EngineJob<?>> jobs = new HashMap();
    private final Map<Key, EngineJob<?>> onlyCacheJobs = new HashMap();

    Jobs() {
    }

    private Map<Key, EngineJob<?>> getJobMap(boolean bl) {
        Map<Key, EngineJob<?>> map = bl ? this.onlyCacheJobs : this.jobs;
        return map;
    }

    EngineJob<?> get(Key key, boolean bl) {
        return this.getJobMap(bl).get(key);
    }

    Map<Key, EngineJob<?>> getAll() {
        return Collections.unmodifiableMap(this.jobs);
    }

    void put(Key key, EngineJob<?> engineJob) {
        this.getJobMap(engineJob.onlyRetrieveFromCache()).put(key, engineJob);
    }

    void removeIfCurrent(Key key, EngineJob<?> engineJob) {
        Map<Key, EngineJob<?>> map = this.getJobMap(engineJob.onlyRetrieveFromCache());
        if (!engineJob.equals(map.get(key))) return;
        map.remove(key);
    }
}
