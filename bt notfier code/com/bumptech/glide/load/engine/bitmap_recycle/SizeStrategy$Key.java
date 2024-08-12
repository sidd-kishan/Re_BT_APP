/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.engine.bitmap_recycle.Poolable
 *  com.bumptech.glide.load.engine.bitmap_recycle.SizeStrategy
 *  com.bumptech.glide.load.engine.bitmap_recycle.SizeStrategy$KeyPool
 */
package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import com.bumptech.glide.load.engine.bitmap_recycle.SizeStrategy;

/*
 * Exception performing whole class analysis ignored.
 */
static final class SizeStrategy.Key
implements Poolable {
    private final SizeStrategy.KeyPool pool;
    int size;

    SizeStrategy.Key(SizeStrategy.KeyPool keyPool) {
        this.pool = keyPool;
    }

    public boolean equals(Object object) {
        boolean bl;
        boolean bl2 = object instanceof SizeStrategy.Key;
        boolean bl3 = bl = false;
        if (!bl2) return bl3;
        object = (SizeStrategy.Key)object;
        bl3 = bl;
        if (this.size != ((SizeStrategy.Key)object).size) return bl3;
        bl3 = true;
        return bl3;
    }

    public int hashCode() {
        return this.size;
    }

    public void init(int n) {
        this.size = n;
    }

    public void offer() {
        this.pool.offer((Poolable)this);
    }

    public String toString() {
        return SizeStrategy.getBitmapString((int)this.size);
    }
}
