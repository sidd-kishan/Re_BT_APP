/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap
 *  com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
 *  com.bumptech.glide.load.engine.bitmap_recycle.Poolable
 *  com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy$1
 *  com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy$Key
 *  com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy$KeyPool
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap;
import com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy;
import com.bumptech.glide.util.Util;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class SizeConfigStrategy
implements LruPoolStrategy {
    private static final Bitmap.Config[] ALPHA_8_IN_CONFIGS;
    private static final Bitmap.Config[] ARGB_4444_IN_CONFIGS;
    private static final Bitmap.Config[] ARGB_8888_IN_CONFIGS;
    private static final int MAX_SIZE_MULTIPLE = 8;
    private static final Bitmap.Config[] RGB_565_IN_CONFIGS;
    private final GroupedLinkedMap<Key, Bitmap> groupedMap;
    private final KeyPool keyPool = new KeyPool();
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> sortedSizes;

    static {
        ARGB_8888_IN_CONFIGS = new Bitmap.Config[]{Bitmap.Config.ARGB_8888, null};
        RGB_565_IN_CONFIGS = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        ARGB_4444_IN_CONFIGS = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        ALPHA_8_IN_CONFIGS = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    public SizeConfigStrategy() {
        this.groupedMap = new GroupedLinkedMap();
        this.sortedSizes = new HashMap<Bitmap.Config, NavigableMap<Integer, Integer>>();
    }

    private void decrementBitmapOfSize(Integer n, Bitmap bitmap) {
        NavigableMap<Integer, Integer> navigableMap = this.getSizesForConfig(bitmap.getConfig());
        Integer n2 = (Integer)navigableMap.get(n);
        if (n2 == null) {
            navigableMap = new StringBuilder();
            ((StringBuilder)((Object)navigableMap)).append("Tried to decrement empty size, size: ");
            ((StringBuilder)((Object)navigableMap)).append(n);
            ((StringBuilder)((Object)navigableMap)).append(", removed: ");
            ((StringBuilder)((Object)navigableMap)).append(this.logBitmap(bitmap));
            ((StringBuilder)((Object)navigableMap)).append(", this: ");
            ((StringBuilder)((Object)navigableMap)).append(this);
            throw new NullPointerException(((StringBuilder)((Object)navigableMap)).toString());
        }
        if (n2 == 1) {
            navigableMap.remove(n);
        } else {
            navigableMap.put(n, n2 - 1);
        }
    }

    private Key findBestKey(int n, Bitmap.Config config) {
        Integer n2;
        Bitmap.Config config2;
        Key key;
        Key key2 = this.keyPool.get(n, config);
        Bitmap.Config[] configArray = SizeConfigStrategy.getInConfigs(config);
        int n3 = configArray.length;
        int n4 = 0;
        while (true) {
            key = key2;
            if (n4 >= n3) return key;
            config2 = configArray[n4];
            n2 = this.getSizesForConfig(config2).ceilingKey(n);
            if (n2 != null && n2 <= n * 8) {
                if (n2 != n) break;
                if (config2 == null) {
                    key = key2;
                    if (config == null) return key;
                    break;
                }
                key = key2;
                if (config2.equals((Object)config)) return key;
                break;
            }
            ++n4;
        }
        this.keyPool.offer((Poolable)key2);
        key = this.keyPool.get(n2.intValue(), config2);
        return key;
    }

    static String getBitmapString(int n, Bitmap.Config config) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(n);
        stringBuilder.append("](");
        stringBuilder.append(config);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private static Bitmap.Config[] getInConfigs(Bitmap.Config config) {
        int n = 1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()];
        if (n == 1) return ARGB_8888_IN_CONFIGS;
        if (n == 2) return RGB_565_IN_CONFIGS;
        if (n == 3) return ARGB_4444_IN_CONFIGS;
        if (n == 4) return ALPHA_8_IN_CONFIGS;
        return new Bitmap.Config[]{config};
    }

    private NavigableMap<Integer, Integer> getSizesForConfig(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap;
        NavigableMap<Integer, Integer> navigableMap2 = navigableMap = this.sortedSizes.get(config);
        if (navigableMap != null) return navigableMap2;
        navigableMap2 = new TreeMap<Integer, Integer>();
        this.sortedSizes.put(config, navigableMap2);
        return navigableMap2;
    }

    public Bitmap get(int n, int n2, Bitmap.Config config) {
        Bitmap bitmap = (Bitmap)this.groupedMap.get((Poolable)(config = this.findBestKey(Util.getBitmapByteSize((int)n, (int)n2, (Bitmap.Config)config), config)));
        if (bitmap == null) return bitmap;
        this.decrementBitmapOfSize(config.size, bitmap);
        config = bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
        bitmap.reconfigure(n, n2, config);
        return bitmap;
    }

    public int getSize(Bitmap bitmap) {
        return Util.getBitmapByteSize((Bitmap)bitmap);
    }

    public String logBitmap(int n, int n2, Bitmap.Config config) {
        return SizeConfigStrategy.getBitmapString(Util.getBitmapByteSize((int)n, (int)n2, (Bitmap.Config)config), config);
    }

    public String logBitmap(Bitmap bitmap) {
        return SizeConfigStrategy.getBitmapString(Util.getBitmapByteSize((Bitmap)bitmap), bitmap.getConfig());
    }

    public void put(Bitmap object) {
        int n = Util.getBitmapByteSize((Bitmap)object);
        Key key = this.keyPool.get(n, object.getConfig());
        this.groupedMap.put((Poolable)key, object);
        NavigableMap<Integer, Integer> navigableMap = this.getSizesForConfig(object.getConfig());
        object = (Integer)navigableMap.get(key.size);
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
        this.decrementBitmapOfSize(Util.getBitmapByteSize((Bitmap)bitmap), bitmap);
        return bitmap;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SizeConfigStrategy{groupedMap=");
        stringBuilder.append(this.groupedMap);
        stringBuilder.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.sortedSizes.entrySet()) {
            stringBuilder.append(entry.getKey());
            stringBuilder.append('[');
            stringBuilder.append(entry.getValue());
            stringBuilder.append("], ");
        }
        if (!this.sortedSizes.isEmpty()) {
            stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), "");
        }
        stringBuilder.append(")}");
        return stringBuilder.toString();
    }
}
