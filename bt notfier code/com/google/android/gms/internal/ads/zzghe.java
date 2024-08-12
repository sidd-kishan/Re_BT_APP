/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzghd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzghd;

final class zzghe {
    private static final zzghd zza;
    private static final zzghd zzb;

    static {
        zzghd zzghd2;
        try {
            zzghd2 = (zzghd)Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        }
        catch (Exception exception) {
            zzghd2 = null;
        }
        zza = zzghd2;
        zzb = new zzghd();
    }

    static zzghd zza() {
        return zza;
    }

    static zzghd zzb() {
        return zzb;
    }
}
