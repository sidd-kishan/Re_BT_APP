/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.bumptech.glide.load.Transformation
 *  com.bumptech.glide.load.engine.Resource
 */
package com.bumptech.glide.load;

import android.content.Context;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MultiTransformation<T>
implements Transformation<T> {
    private final Collection<? extends Transformation<T>> transformations;

    public MultiTransformation(Collection<? extends Transformation<T>> collection) {
        if (collection.isEmpty()) throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        this.transformations = collection;
    }

    @SafeVarargs
    public MultiTransformation(Transformation<T> ... transformationArray) {
        if (transformationArray.length == 0) throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        this.transformations = Arrays.asList(transformationArray);
    }

    public boolean equals(Object object) {
        if (!(object instanceof MultiTransformation)) return false;
        object = (MultiTransformation)object;
        return this.transformations.equals(((MultiTransformation)object).transformations);
    }

    public int hashCode() {
        return this.transformations.hashCode();
    }

    public Resource<T> transform(Context context, Resource<T> resource, int n, int n2) {
        Iterator<Transformation<T>> iterator = this.transformations.iterator();
        Resource resource2 = resource;
        while (iterator.hasNext()) {
            Resource resource3 = iterator.next().transform(context, resource2, n, n2);
            if (resource2 != null && !resource2.equals(resource) && !resource2.equals(resource3)) {
                resource2.recycle();
            }
            resource2 = resource3;
        }
        return resource2;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        Iterator<Transformation<T>> iterator = this.transformations.iterator();
        while (iterator.hasNext()) {
            iterator.next().updateDiskCacheKey(messageDigest);
        }
    }
}
