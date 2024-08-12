/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.util.pool.StateVerifier
 */
package com.bumptech.glide.util.pool;

import com.bumptech.glide.util.pool.StateVerifier;

private static class StateVerifier.DebugStateVerifier
extends StateVerifier {
    private volatile RuntimeException recycledAtStackTraceException;

    StateVerifier.DebugStateVerifier() {
        super(null);
    }

    void setRecycled(boolean bl) {
        this.recycledAtStackTraceException = bl ? new RuntimeException("Released") : null;
    }

    public void throwIfRecycled() {
        if (this.recycledAtStackTraceException != null) throw new IllegalStateException("Already released", this.recycledAtStackTraceException);
    }
}
