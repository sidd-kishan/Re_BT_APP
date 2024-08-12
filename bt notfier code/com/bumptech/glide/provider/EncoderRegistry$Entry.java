/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.Encoder
 */
package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;

private static final class EncoderRegistry.Entry<T> {
    private final Class<T> dataClass;
    final Encoder<T> encoder;

    EncoderRegistry.Entry(Class<T> clazz, Encoder<T> encoder) {
        this.dataClass = clazz;
        this.encoder = encoder;
    }

    boolean handles(Class<?> clazz) {
        return this.dataClass.isAssignableFrom(clazz);
    }
}
