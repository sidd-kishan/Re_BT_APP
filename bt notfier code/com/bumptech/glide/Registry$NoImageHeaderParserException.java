/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.Registry$MissingComponentException
 */
package com.bumptech.glide;

import com.bumptech.glide.Registry;

public static final class Registry.NoImageHeaderParserException
extends Registry.MissingComponentException {
    public Registry.NoImageHeaderParserException() {
        super("Failed to find image header parser.");
    }
}
