/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.ResourceDecoder
 */
package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceDecoder;

private static class ResourceDecoderRegistry.Entry<T, R> {
    private final Class<T> dataClass;
    final ResourceDecoder<T, R> decoder;
    final Class<R> resourceClass;

    public ResourceDecoderRegistry.Entry(Class<T> clazz, Class<R> clazz2, ResourceDecoder<T, R> resourceDecoder) {
        this.dataClass = clazz;
        this.resourceClass = clazz2;
        this.decoder = resourceDecoder;
    }

    public boolean handles(Class<?> clazz, Class<?> clazz2) {
        boolean bl = this.dataClass.isAssignableFrom(clazz) && clazz2.isAssignableFrom(this.resourceClass);
        return bl;
    }
}
