/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  com.bumptech.glide.load.engine.bitmap_recycle.AttributeStrategy$Key
 *  com.bumptech.glide.load.engine.bitmap_recycle.AttributeStrategy$KeyPool
 *  com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap
 *  com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
 *  com.bumptech.glide.load.engine.bitmap_recycle.Poolable
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.AttributeStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap;
import com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import com.bumptech.glide.util.Util;

class AttributeStrategy
implements LruPoolStrategy {
    private final GroupedLinkedMap<Key, Bitmap> groupedMap;
    private final KeyPool keyPool = new KeyPool();

    AttributeStrategy() {
        this.groupedMap = new GroupedLinkedMap();
    }

    static String getBitmapString(int n, int n2, Bitmap.Config config) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(n);
        stringBuilder.append("x");
        stringBuilder.append(n2);
        stringBuilder.append("], ");
        stringBuilder.append(config);
        return stringBuilder.toString();
    }

    private static String getBitmapString(Bitmap bitmap) {
        return AttributeStrategy.getBitmapString(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    public Bitmap get(int n, int n2, Bitmap.Config config) {
        config = this.keyPool.get(n, n2, config);
        return (Bitmap)this.groupedMap.get((Poolable)config);
    }

    public int getSize(Bitmap bitmap) {
        return Util.getBitmapByteSize((Bitmap)bitmap);
    }

    public String logBitmap(int n, int n2, Bitmap.Config config) {
        return AttributeStrategy.getBitmapString(n, n2, config);
    }

    public String logBitmap(Bitmap bitmap) {
        return AttributeStrategy.getBitmapString(bitmap);
    }

    public void put(Bitmap bitmap) {
        Key key = this.keyPool.get(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        this.groupedMap.put((Poolable)key, (Object)bitmap);
    }

    public Bitmap removeLast() {
        return (Bitmap)this.groupedMap.removeLast();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AttributeStrategy:\n  ");
        stringBuilder.append(this.groupedMap);
        return stringBuilder.toString();
    }
}
