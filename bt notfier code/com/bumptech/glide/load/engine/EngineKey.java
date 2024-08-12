/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.Transformation
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;
import java.util.Map;

class EngineKey
implements Key {
    private int hashCode;
    private final int height;
    private final Object model;
    private final Options options;
    private final Class<?> resourceClass;
    private final Key signature;
    private final Class<?> transcodeClass;
    private final Map<Class<?>, Transformation<?>> transformations;
    private final int width;

    EngineKey(Object object, Key key, int n, int n2, Map<Class<?>, Transformation<?>> map, Class<?> clazz, Class<?> clazz2, Options options) {
        this.model = Preconditions.checkNotNull((Object)object);
        this.signature = (Key)Preconditions.checkNotNull((Object)key, (String)"Signature must not be null");
        this.width = n;
        this.height = n2;
        this.transformations = (Map)Preconditions.checkNotNull(map);
        this.resourceClass = (Class)Preconditions.checkNotNull(clazz, (String)"Resource class must not be null");
        this.transcodeClass = (Class)Preconditions.checkNotNull(clazz2, (String)"Transcode class must not be null");
        this.options = (Options)Preconditions.checkNotNull((Object)options);
    }

    public boolean equals(Object object) {
        boolean bl;
        boolean bl2 = object instanceof EngineKey;
        boolean bl3 = bl = false;
        if (!bl2) return bl3;
        object = (EngineKey)object;
        bl3 = bl;
        if (!this.model.equals(((EngineKey)object).model)) return bl3;
        bl3 = bl;
        if (!this.signature.equals((Object)((EngineKey)object).signature)) return bl3;
        bl3 = bl;
        if (this.height != ((EngineKey)object).height) return bl3;
        bl3 = bl;
        if (this.width != ((EngineKey)object).width) return bl3;
        bl3 = bl;
        if (!this.transformations.equals(((EngineKey)object).transformations)) return bl3;
        bl3 = bl;
        if (!this.resourceClass.equals(((EngineKey)object).resourceClass)) return bl3;
        bl3 = bl;
        if (!this.transcodeClass.equals(((EngineKey)object).transcodeClass)) return bl3;
        bl3 = bl;
        if (!this.options.equals((Object)((EngineKey)object).options)) return bl3;
        bl3 = true;
        return bl3;
    }

    public int hashCode() {
        int n;
        if (this.hashCode != 0) return this.hashCode;
        this.hashCode = n = this.model.hashCode();
        this.hashCode = n = n * 31 + this.signature.hashCode();
        this.hashCode = n = n * 31 + this.width;
        this.hashCode = n = n * 31 + this.height;
        this.hashCode = n = n * 31 + this.transformations.hashCode();
        this.hashCode = n = n * 31 + this.resourceClass.hashCode();
        this.hashCode = n = n * 31 + this.transcodeClass.hashCode();
        this.hashCode = n * 31 + this.options.hashCode();
        return this.hashCode;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EngineKey{model=");
        stringBuilder.append(this.model);
        stringBuilder.append(", width=");
        stringBuilder.append(this.width);
        stringBuilder.append(", height=");
        stringBuilder.append(this.height);
        stringBuilder.append(", resourceClass=");
        stringBuilder.append(this.resourceClass);
        stringBuilder.append(", transcodeClass=");
        stringBuilder.append(this.transcodeClass);
        stringBuilder.append(", signature=");
        stringBuilder.append(this.signature);
        stringBuilder.append(", hashCode=");
        stringBuilder.append(this.hashCode);
        stringBuilder.append(", transformations=");
        stringBuilder.append(this.transformations);
        stringBuilder.append(", options=");
        stringBuilder.append(this.options);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
