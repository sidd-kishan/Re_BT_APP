/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.resource.transcode.ResourceTranscoder
 */
package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;

private static final class TranscoderRegistry.Entry<Z, R> {
    private final Class<Z> fromClass;
    private final Class<R> toClass;
    final ResourceTranscoder<Z, R> transcoder;

    TranscoderRegistry.Entry(Class<Z> clazz, Class<R> clazz2, ResourceTranscoder<Z, R> resourceTranscoder) {
        this.fromClass = clazz;
        this.toClass = clazz2;
        this.transcoder = resourceTranscoder;
    }

    public boolean handles(Class<?> clazz, Class<?> clazz2) {
        boolean bl = this.fromClass.isAssignableFrom(clazz) && clazz2.isAssignableFrom(this.toClass);
        return bl;
    }
}
