/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  androidx.collection.LruCache
 */
package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;
import androidx.collection.LruCache;

public final class zak
extends LruCache<Object, Drawable> {
    public zak() {
        super(10);
    }
}
