/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap$Config
 *  com.bumptech.glide.load.engine.bitmap_recycle.Poolable
 *  com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy
 *  com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy$KeyPool
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy;
import com.bumptech.glide.util.Util;

/*
 * Exception performing whole class analysis ignored.
 */
static final class SizeConfigStrategy.Key
implements Poolable {
    private Bitmap.Config config;
    private final SizeConfigStrategy.KeyPool pool;
    int size;

    public SizeConfigStrategy.Key(SizeConfigStrategy.KeyPool keyPool) {
        this.pool = keyPool;
    }

    SizeConfigStrategy.Key(SizeConfigStrategy.KeyPool keyPool, int n, Bitmap.Config config) {
        this(keyPool);
        this.init(n, config);
    }

    public boolean equals(Object object) {
        boolean bl;
        boolean bl2 = object instanceof SizeConfigStrategy.Key;
        boolean bl3 = bl = false;
        if (!bl2) return bl3;
        object = (SizeConfigStrategy.Key)object;
        bl3 = bl;
        if (this.size != ((SizeConfigStrategy.Key)object).size) return bl3;
        bl3 = bl;
        if (!Util.bothNullOrEqual((Object)this.config, (Object)((SizeConfigStrategy.Key)object).config)) return bl3;
        bl3 = true;
        return bl3;
    }

    public int hashCode() {
        int n = this.size;
        Bitmap.Config config = this.config;
        int n2 = config != null ? config.hashCode() : 0;
        return n * 31 + n2;
    }

    public void init(int n, Bitmap.Config config) {
        this.size = n;
        this.config = config;
    }

    public void offer() {
        this.pool.offer((Poolable)this);
    }

    public String toString() {
        return SizeConfigStrategy.getBitmapString((int)this.size, (Bitmap.Config)this.config);
    }
}
