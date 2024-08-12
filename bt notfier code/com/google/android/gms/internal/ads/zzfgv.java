/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzfgv {
    private static final zzfgv zza = new zzfgv();
    private Context zzb;

    private zzfgv() {
    }

    public static zzfgv zza() {
        return zza;
    }

    public final Context zzb() {
        return this.zzb;
    }

    public final void zzc(Context object) {
        object = object != null ? object.getApplicationContext() : null;
        this.zzb = object;
    }
}
