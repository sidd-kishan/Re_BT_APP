/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgfn
 *  com.google.android.gms.internal.ads.zzgfo
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgfn;
import com.google.android.gms.internal.ads.zzgfo;

final class zzgfp {
    private static final zzgfn<?> zza;
    private static final zzgfn<?> zzb;

    static {
        zzgfn zzgfn2;
        zza = new zzgfo();
        try {
            zzgfn2 = (zzgfn)Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        }
        catch (Exception exception) {
            zzgfn2 = null;
        }
        zzb = zzgfn2;
    }

    static zzgfn<?> zza() {
        return zza;
    }

    static zzgfn<?> zzb() {
        zzgfn<?> zzgfn2 = zzb;
        if (zzgfn2 == null) throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
        return zzgfn2;
    }
}
