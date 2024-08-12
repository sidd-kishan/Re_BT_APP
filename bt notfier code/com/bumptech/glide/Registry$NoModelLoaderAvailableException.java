/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.Registry$MissingComponentException
 */
package com.bumptech.glide;

import com.bumptech.glide.Registry;

public static class Registry.NoModelLoaderAvailableException
extends Registry.MissingComponentException {
    public Registry.NoModelLoaderAvailableException(Class<?> clazz, Class<?> clazz2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to find any ModelLoaders for model: ");
        stringBuilder.append(clazz);
        stringBuilder.append(" and data: ");
        stringBuilder.append(clazz2);
        super(stringBuilder.toString());
    }

    public Registry.NoModelLoaderAvailableException(Object object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to find any ModelLoaders for model: ");
        stringBuilder.append(object);
        super(stringBuilder.toString());
    }
}
