/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.ResourceEncoder
 */
package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceEncoder;

private static final class ResourceEncoderRegistry.Entry<T> {
    final ResourceEncoder<T> encoder;
    private final Class<T> resourceClass;

    ResourceEncoderRegistry.Entry(Class<T> clazz, ResourceEncoder<T> resourceEncoder) {
        this.resourceClass = clazz;
        this.encoder = resourceEncoder;
    }

    boolean handles(Class<?> clazz) {
        return this.resourceClass.isAssignableFrom(clazz);
    }
}
