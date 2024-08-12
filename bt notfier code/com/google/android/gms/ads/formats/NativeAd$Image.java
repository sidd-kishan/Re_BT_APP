/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 */
package com.google.android.gms.ads.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;

@Deprecated
public static abstract class NativeAd.Image {
    public abstract Drawable getDrawable();

    public abstract double getScale();

    public abstract Uri getUri();

    public int zza() {
        return -1;
    }

    public int zzb() {
        return -1;
    }
}
