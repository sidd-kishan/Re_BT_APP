/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap$Config
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import com.bumptech.glide.util.Preconditions;

public final class PreFillType {
    static final Bitmap.Config DEFAULT_CONFIG = Bitmap.Config.RGB_565;
    private final Bitmap.Config config;
    private final int height;
    private final int weight;
    private final int width;

    PreFillType(int n, int n2, Bitmap.Config config, int n3) {
        this.config = (Bitmap.Config)Preconditions.checkNotNull((Object)config, (String)"Config must not be null");
        this.width = n;
        this.height = n2;
        this.weight = n3;
    }

    public boolean equals(Object object) {
        boolean bl;
        boolean bl2 = object instanceof PreFillType;
        boolean bl3 = bl = false;
        if (!bl2) return bl3;
        object = (PreFillType)object;
        bl3 = bl;
        if (this.height != ((PreFillType)object).height) return bl3;
        bl3 = bl;
        if (this.width != ((PreFillType)object).width) return bl3;
        bl3 = bl;
        if (this.weight != ((PreFillType)object).weight) return bl3;
        bl3 = bl;
        if (this.config != ((PreFillType)object).config) return bl3;
        bl3 = true;
        return bl3;
    }

    Bitmap.Config getConfig() {
        return this.config;
    }

    int getHeight() {
        return this.height;
    }

    int getWeight() {
        return this.weight;
    }

    int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return ((this.width * 31 + this.height) * 31 + this.config.hashCode()) * 31 + this.weight;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PreFillSize{width=");
        stringBuilder.append(this.width);
        stringBuilder.append(", height=");
        stringBuilder.append(this.height);
        stringBuilder.append(", config=");
        stringBuilder.append(this.config);
        stringBuilder.append(", weight=");
        stringBuilder.append(this.weight);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
