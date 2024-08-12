/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package com.google.android.gms.ads.internal.util;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzbz {
    final Map<Integer, Bitmap> zza = new ConcurrentHashMap<Integer, Bitmap>();
    private final AtomicInteger zzb = new AtomicInteger(0);

    public final Bitmap zza(Integer n) {
        return this.zza.get(n);
    }
}
