/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.Registry$MissingComponentException
 */
package com.bumptech.glide;

import com.bumptech.glide.Registry;

public static class Registry.NoSourceEncoderAvailableException
extends Registry.MissingComponentException {
    public Registry.NoSourceEncoderAvailableException(Class<?> clazz) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to find source encoder for data class: ");
        stringBuilder.append(clazz);
        super(stringBuilder.toString());
    }
}
