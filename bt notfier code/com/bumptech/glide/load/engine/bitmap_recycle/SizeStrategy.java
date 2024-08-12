/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap
 *  com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
 *  com.bumptech.glide.load.engine.bitmap_recycle.Poolable
 *  com.bumptech.glide.load.engine.bitmap_recycle.PrettyPrintTreeMap
 *  com.bumptech.glide.load.engine.bitmap_recycle.SizeStrategy$Key
 *  com.bumptech.glide.load.engine.bitmap_recycle.SizeStrategy$KeyPool
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap;
import com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import com.bumptech.glide.load.engine.bitmap_recycle.PrettyPrintTreeMap;
import com.bumptech.glide.load.engine.bitmap_recycle.SizeStrategy;
import com.bumptech.glide.util.Util;
import java.util.NavigableMap;

final class SizeStrategy
implements LruPoolStrategy {
    private static final int MAX_SIZE_MULTIPLE = 8;
    private final GroupedLinkedMap<Key, Bitmap> groupedMap;
    private final KeyPool keyPool = new KeyPool();
    private final NavigableMap<Integer, Integer> sortedSizes;

    SizeStrategy() {
        this.groupedMap = new GroupedLinkedMap();
        this.sortedSizes = new PrettyPrintTreeMap();
    }

    private void decrementBitmapOfSize(Integer n) {
        Integer n2 = (Integer)this.sortedSizes.get(n);
        if (n2 == 1) {
            this.sortedSizes.remove(n);
        } else {
            this.sortedSizes.put(n, n2 - 1);
        }
    }

    static String getBitmapString(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(n);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static String getBitmapString(Bitmap bitmap) {
        return SizeStrategy.getBitmapString(Util.getBitmapByteSize((Bitmap)bitmap));
    }

    public Bitmap get(int n, int n2, Bitmap.Config config) {
        int n3 = Util.getBitmapByteSize((int)n, (int)n2, (Bitmap.Config)config);
        Key key = this.keyPool.get(n3);
        Integer n4 = this.sortedSizes.ceilingKey(n3);
        Key key2 = key;
        if (n4 != null) {
            key2 = key;
            if (n4 != n3) {
                key2 = key;
                if (n4 <= n3 * 8) {
                    this.keyPool.offer((Poolable)key);
                    key2 = this.keyPool.get(n4.intValue());
                }
            }
        }
        if ((key2 = (Bitmap)this.groupedMap.get((Poolable)key2)) == null) return key2;
        key2.reconfigure(n, n2, config);
        this.decrementBitmapOfSize(n4);
        return key2;
    }

    public int getSize(Bitmap bitmap) {
        return Util.getBitmapByteSize((Bitmap)bitmap);
    }

    public String logBitmap(int n, int n2, Bitmap.Config config) {
        return SizeStrategy.getBitmapString(Util.getBitmapByteSize((int)n, (int)n2, (Bitmap.Config)config));
    }

    public String logBitmap(Bitmap bitmap) {
        return SizeStrategy.getBitmapString(bitmap);
    }

    public void put(Bitmap object) {
        int n = Util.getBitmapByteSize((Bitmap)object);
        Key key = this.keyPool.get(n);
        this.groupedMap.put((Poolable)key, object);
        object = (Integer)this.sortedSizes.get(key.size);
        NavigableMap<Integer, Integer> navigableMap = this.sortedSizes;
        int n2 = key.size;
        n = 1;
        if (object != null) {
            n = 1 + (Integer)object;
        }
        navigableMap.put(n2, n);
    }

    public Bitmap removeLast() {
        Bitmap bitmap = (Bitmap)this.groupedMap.removeLast();
        if (bitmap == null) return bitmap;
        this.decrementBitmapOfSize(Util.getBitmapByteSize((Bitmap)bitmap));
        return bitmap;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SizeStrategy:\n  ");
        stringBuilder.append(this.groupedMap);
        stringBuilder.append("\n  SortedSizes");
        stringBuilder.append(this.sortedSizes);
        return stringBuilder.toString();
    }
}
