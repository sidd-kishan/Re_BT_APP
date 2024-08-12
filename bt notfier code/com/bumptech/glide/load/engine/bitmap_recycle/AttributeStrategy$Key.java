/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap$Config
 *  com.bumptech.glide.load.engine.bitmap_recycle.AttributeStrategy
 *  com.bumptech.glide.load.engine.bitmap_recycle.AttributeStrategy$KeyPool
 *  com.bumptech.glide.load.engine.bitmap_recycle.Poolable
 */
package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.AttributeStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;

/*
 * Exception performing whole class analysis ignored.
 */
static class AttributeStrategy.Key
implements Poolable {
    private Bitmap.Config config;
    private int height;
    private final AttributeStrategy.KeyPool pool;
    private int width;

    public AttributeStrategy.Key(AttributeStrategy.KeyPool keyPool) {
        this.pool = keyPool;
    }

    public boolean equals(Object object) {
        boolean bl;
        boolean bl2 = object instanceof AttributeStrategy.Key;
        boolean bl3 = bl = false;
        if (!bl2) return bl3;
        object = (AttributeStrategy.Key)object;
        bl3 = bl;
        if (this.width != ((AttributeStrategy.Key)object).width) return bl3;
        bl3 = bl;
        if (this.height != ((AttributeStrategy.Key)object).height) return bl3;
        bl3 = bl;
        if (this.config != ((AttributeStrategy.Key)object).config) return bl3;
        bl3 = true;
        return bl3;
    }

    public int hashCode() {
        int n = this.width;
        int n2 = this.height;
        Bitmap.Config config = this.config;
        int n3 = config != null ? config.hashCode() : 0;
        return (n * 31 + n2) * 31 + n3;
    }

    public void init(int n, int n2, Bitmap.Config config) {
        this.width = n;
        this.height = n2;
        this.config = config;
    }

    public void offer() {
        this.pool.offer((Poolable)this);
    }

    public String toString() {
        return AttributeStrategy.getBitmapString((int)this.width, (int)this.height, (Bitmap.Config)this.config);
    }
}
