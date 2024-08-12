/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.request.transition.DrawableCrossFadeFactory
 */
package com.bumptech.glide.request.transition;

import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;

public static class DrawableCrossFadeFactory.Builder {
    private static final int DEFAULT_DURATION_MS = 300;
    private final int durationMillis;
    private boolean isCrossFadeEnabled;

    public DrawableCrossFadeFactory.Builder() {
        this(300);
    }

    public DrawableCrossFadeFactory.Builder(int n) {
        this.durationMillis = n;
    }

    public DrawableCrossFadeFactory build() {
        return new DrawableCrossFadeFactory(this.durationMillis, this.isCrossFadeEnabled);
    }

    public DrawableCrossFadeFactory.Builder setCrossFadeEnabled(boolean bl) {
        this.isCrossFadeEnabled = bl;
        return this;
    }
}
