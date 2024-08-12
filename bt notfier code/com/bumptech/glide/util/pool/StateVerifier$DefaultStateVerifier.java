/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.util.pool.StateVerifier
 */
package com.bumptech.glide.util.pool;

import com.bumptech.glide.util.pool.StateVerifier;

private static class StateVerifier.DefaultStateVerifier
extends StateVerifier {
    private volatile boolean isReleased;

    StateVerifier.DefaultStateVerifier() {
        super(null);
    }

    public void setRecycled(boolean bl) {
        this.isReleased = bl;
    }

    public void throwIfRecycled() {
        if (this.isReleased) throw new IllegalStateException("Already released");
    }
}
