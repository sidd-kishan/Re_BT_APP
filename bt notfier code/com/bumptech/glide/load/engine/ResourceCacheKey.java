/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.Transformation
 *  com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
 *  com.bumptech.glide.util.LruCache
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

final class ResourceCacheKey
implements Key {
    private static final LruCache<Class<?>, byte[]> RESOURCE_CLASS_BYTES = new LruCache(50L);
    private final ArrayPool arrayPool;
    private final Class<?> decodedResourceClass;
    private final int height;
    private final Options options;
    private final Key signature;
    private final Key sourceKey;
    private final Transformation<?> transformation;
    private final int width;

    ResourceCacheKey(ArrayPool arrayPool, Key key, Key key2, int n, int n2, Transformation<?> transformation, Class<?> clazz, Options options) {
        this.arrayPool = arrayPool;
        this.sourceKey = key;
        this.signature = key2;
        this.width = n;
        this.height = n2;
        this.transformation = transformation;
        this.decodedResourceClass = clazz;
        this.options = options;
    }

    private byte[] getResourceClassBytes() {
        byte[] byArray;
        byte[] byArray2 = byArray = (byte[])RESOURCE_CLASS_BYTES.get(this.decodedResourceClass);
        if (byArray != null) return byArray2;
        byArray2 = this.decodedResourceClass.getName().getBytes(CHARSET);
        RESOURCE_CLASS_BYTES.put(this.decodedResourceClass, (Object)byArray2);
        return byArray2;
    }

    public boolean equals(Object object) {
        boolean bl;
        boolean bl2 = object instanceof ResourceCacheKey;
        boolean bl3 = bl = false;
        if (!bl2) return bl3;
        object = (ResourceCacheKey)object;
        bl3 = bl;
        if (this.height != ((ResourceCacheKey)object).height) return bl3;
        bl3 = bl;
        if (this.width != ((ResourceCacheKey)object).width) return bl3;
        bl3 = bl;
        if (!Util.bothNullOrEqual(this.transformation, ((ResourceCacheKey)object).transformation)) return bl3;
        bl3 = bl;
        if (!this.decodedResourceClass.equals(((ResourceCacheKey)object).decodedResourceClass)) return bl3;
        bl3 = bl;
        if (!this.sourceKey.equals((Object)((ResourceCacheKey)object).sourceKey)) return bl3;
        bl3 = bl;
        if (!this.signature.equals((Object)((ResourceCacheKey)object).signature)) return bl3;
        bl3 = bl;
        if (!this.options.equals((Object)((ResourceCacheKey)object).options)) return bl3;
        bl3 = true;
        return bl3;
    }

    public int hashCode() {
        int n = ((this.sourceKey.hashCode() * 31 + this.signature.hashCode()) * 31 + this.width) * 31 + this.height;
        Transformation<?> transformation = this.transformation;
        int n2 = n;
        if (transformation == null) return (n2 * 31 + this.decodedResourceClass.hashCode()) * 31 + this.options.hashCode();
        n2 = n * 31 + transformation.hashCode();
        return (n2 * 31 + this.decodedResourceClass.hashCode()) * 31 + this.options.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ResourceCacheKey{sourceKey=");
        stringBuilder.append(this.sourceKey);
        stringBuilder.append(", signature=");
        stringBuilder.append(this.signature);
        stringBuilder.append(", width=");
        stringBuilder.append(this.width);
        stringBuilder.append(", height=");
        stringBuilder.append(this.height);
        stringBuilder.append(", decodedResourceClass=");
        stringBuilder.append(this.decodedResourceClass);
        stringBuilder.append(", transformation='");
        stringBuilder.append(this.transformation);
        stringBuilder.append('\'');
        stringBuilder.append(", options=");
        stringBuilder.append(this.options);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        byte[] byArray = (byte[])this.arrayPool.getExact(8, byte[].class);
        ByteBuffer.wrap(byArray).putInt(this.width).putInt(this.height).array();
        this.signature.updateDiskCacheKey(messageDigest);
        this.sourceKey.updateDiskCacheKey(messageDigest);
        messageDigest.update(byArray);
        Transformation<?> transformation = this.transformation;
        if (transformation != null) {
            transformation.updateDiskCacheKey(messageDigest);
        }
        this.options.updateDiskCacheKey(messageDigest);
        messageDigest.update(this.getResourceClassBytes());
        this.arrayPool.put((Object)byArray);
    }
}
