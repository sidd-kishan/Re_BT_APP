/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.util.pool.StateVerifier$DefaultStateVerifier
 */
package com.bumptech.glide.util.pool;

import com.bumptech.glide.util.pool.StateVerifier;

public abstract class StateVerifier {
    private static final boolean DEBUG = false;

    private StateVerifier() {
    }

    public static StateVerifier newInstance() {
        return new DefaultStateVerifier();
    }

    abstract void setRecycled(boolean var1);

    public abstract void throwIfRecycled();
}
