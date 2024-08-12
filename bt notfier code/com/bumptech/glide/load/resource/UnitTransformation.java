/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.bumptech.glide.load.Transformation
 *  com.bumptech.glide.load.engine.Resource
 */
package com.bumptech.glide.load.resource;

import android.content.Context;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

public final class UnitTransformation<T>
implements Transformation<T> {
    private static final Transformation<?> TRANSFORMATION = new UnitTransformation();

    private UnitTransformation() {
    }

    public static <T> UnitTransformation<T> get() {
        return (UnitTransformation)TRANSFORMATION;
    }

    public Resource<T> transform(Context context, Resource<T> resource, int n, int n2) {
        return resource;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }
}
