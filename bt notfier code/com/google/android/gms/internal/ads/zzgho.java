/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzghn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzghn;

final class zzgho {
    private static final zzghn zza;
    private static final zzghn zzb;

    static {
        zzghn zzghn2;
        try {
            zzghn2 = (zzghn)Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        }
        catch (Exception exception) {
            zzghn2 = null;
        }
        zza = zzghn2;
        zzb = new zzghn();
    }

    static zzghn zza() {
        return zza;
    }

    static zzghn zzb() {
        return zzb;
    }
}
