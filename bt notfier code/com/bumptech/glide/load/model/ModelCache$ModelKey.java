/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide.load.model;

import com.bumptech.glide.util.Util;
import java.util.Queue;

static final class ModelCache.ModelKey<A> {
    private static final Queue<ModelCache.ModelKey<?>> KEY_QUEUE = Util.createQueue((int)0);
    private int height;
    private A model;
    private int width;

    private ModelCache.ModelKey() {
    }

    /*
     * Enabled unnecessary exception pruning
     */
    static <A> ModelCache.ModelKey<A> get(A a, int n, int n2) {
        ModelCache.ModelKey<?> modelKey;
        ModelCache.ModelKey<A> modelKey2 = KEY_QUEUE;
        synchronized (modelKey2) {
            modelKey = KEY_QUEUE.poll();
        }
        modelKey2 = modelKey;
        if (modelKey == null) {
            modelKey2 = new ModelCache.ModelKey<A>();
        }
        super.init(a, n, n2);
        return modelKey2;
    }

    private void init(A a, int n, int n2) {
        this.model = a;
        this.width = n;
        this.height = n2;
    }

    public boolean equals(Object object) {
        boolean bl;
        boolean bl2 = object instanceof ModelCache.ModelKey;
        boolean bl3 = bl = false;
        if (!bl2) return bl3;
        object = (ModelCache.ModelKey)object;
        bl3 = bl;
        if (this.width != ((ModelCache.ModelKey)object).width) return bl3;
        bl3 = bl;
        if (this.height != ((ModelCache.ModelKey)object).height) return bl3;
        bl3 = bl;
        if (!this.model.equals(((ModelCache.ModelKey)object).model)) return bl3;
        bl3 = true;
        return bl3;
    }

    public int hashCode() {
        return (this.height * 31 + this.width) * 31 + this.model.hashCode();
    }

    public void release() {
        Queue<ModelCache.ModelKey<?>> queue = KEY_QUEUE;
        synchronized (queue) {
            KEY_QUEUE.offer(this);
            return;
        }
    }
}
