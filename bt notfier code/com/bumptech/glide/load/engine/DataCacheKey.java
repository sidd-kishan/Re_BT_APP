/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.Key
 */
package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

final class DataCacheKey
implements Key {
    private final Key signature;
    private final Key sourceKey;

    DataCacheKey(Key key, Key key2) {
        this.sourceKey = key;
        this.signature = key2;
    }

    public boolean equals(Object object) {
        boolean bl;
        boolean bl2 = object instanceof DataCacheKey;
        boolean bl3 = bl = false;
        if (!bl2) return bl3;
        object = (DataCacheKey)object;
        bl3 = bl;
        if (!this.sourceKey.equals((Object)((DataCacheKey)object).sourceKey)) return bl3;
        bl3 = bl;
        if (!this.signature.equals((Object)((DataCacheKey)object).signature)) return bl3;
        bl3 = true;
        return bl3;
    }

    Key getSourceKey() {
        return this.sourceKey;
    }

    public int hashCode() {
        return this.sourceKey.hashCode() * 31 + this.signature.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataCacheKey{sourceKey=");
        stringBuilder.append(this.sourceKey);
        stringBuilder.append(", signature=");
        stringBuilder.append(this.signature);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.sourceKey.updateDiskCacheKey(messageDigest);
        this.signature.updateDiskCacheKey(messageDigest);
    }
}
