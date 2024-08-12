/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.collection.ArrayMap
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.Option
 */
package com.bumptech.glide.load;

import androidx.collection.ArrayMap;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import java.security.MessageDigest;

public final class Options
implements Key {
    private final ArrayMap<Option<?>, Object> values = new ArrayMap();

    private static <T> void updateDiskCacheKey(Option<T> option, Object object, MessageDigest messageDigest) {
        option.update(object, messageDigest);
    }

    public boolean equals(Object object) {
        if (!(object instanceof Options)) return false;
        object = (Options)object;
        return this.values.equals(((Options)object).values);
    }

    public <T> T get(Option<T> object) {
        object = this.values.containsKey(object) ? this.values.get(object) : object.getDefaultValue();
        return (T)object;
    }

    public int hashCode() {
        return this.values.hashCode();
    }

    public void putAll(Options options) {
        this.values.putAll(options.values);
    }

    public <T> Options set(Option<T> option, T t) {
        this.values.put(option, t);
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Options{values=");
        stringBuilder.append(this.values);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        int n = 0;
        while (n < this.values.size()) {
            Options.updateDiskCacheKey((Option)this.values.keyAt(n), this.values.valueAt(n), messageDigest);
            ++n;
        }
    }
}
