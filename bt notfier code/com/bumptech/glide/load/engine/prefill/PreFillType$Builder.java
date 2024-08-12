/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap$Config
 *  com.bumptech.glide.load.engine.prefill.PreFillType
 */
package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.prefill.PreFillType;

public static class PreFillType.Builder {
    private Bitmap.Config config;
    private final int height;
    private int weight = 1;
    private final int width;

    public PreFillType.Builder(int n) {
        this(n, n);
    }

    public PreFillType.Builder(int n, int n2) {
        if (n <= 0) throw new IllegalArgumentException("Width must be > 0");
        if (n2 <= 0) throw new IllegalArgumentException("Height must be > 0");
        this.width = n;
        this.height = n2;
    }

    PreFillType build() {
        return new PreFillType(this.width, this.height, this.config, this.weight);
    }

    Bitmap.Config getConfig() {
        return this.config;
    }

    public PreFillType.Builder setConfig(Bitmap.Config config) {
        this.config = config;
        return this;
    }

    public PreFillType.Builder setWeight(int n) {
        if (n <= 0) throw new IllegalArgumentException("Weight must be > 0");
        this.weight = n;
        return this;
    }
}
