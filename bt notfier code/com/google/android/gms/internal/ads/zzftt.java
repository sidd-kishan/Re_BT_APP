/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public abstract class zzftt<PrimitiveT, KeyT> {
    private final Class<PrimitiveT> zza;

    public zzftt(Class<PrimitiveT> clazz) {
        this.zza = clazz;
    }

    final Class<PrimitiveT> zza() {
        return this.zza;
    }

    public abstract PrimitiveT zzb(KeyT var1) throws GeneralSecurityException;
}
