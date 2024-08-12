/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool$KeyPool
 *  com.bumptech.glide.load.engine.bitmap_recycle.Poolable
 */
package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;

private static final class LruArrayPool.Key
implements Poolable {
    private Class<?> arrayClass;
    private final LruArrayPool.KeyPool pool;
    int size;

    LruArrayPool.Key(LruArrayPool.KeyPool keyPool) {
        this.pool = keyPool;
    }

    public boolean equals(Object object) {
        boolean bl;
        boolean bl2 = object instanceof LruArrayPool.Key;
        boolean bl3 = bl = false;
        if (!bl2) return bl3;
        object = (LruArrayPool.Key)object;
        bl3 = bl;
        if (this.size != ((LruArrayPool.Key)object).size) return bl3;
        bl3 = bl;
        if (this.arrayClass != ((LruArrayPool.Key)object).arrayClass) return bl3;
        bl3 = true;
        return bl3;
    }

    public int hashCode() {
        int n = this.size;
        Class<?> clazz = this.arrayClass;
        int n2 = clazz != null ? clazz.hashCode() : 0;
        return n * 31 + n2;
    }

    void init(int n, Class<?> clazz) {
        this.size = n;
        this.arrayClass = clazz;
    }

    public void offer() {
        this.pool.offer((Poolable)this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Key{size=");
        stringBuilder.append(this.size);
        stringBuilder.append("array=");
        stringBuilder.append(this.arrayClass);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
