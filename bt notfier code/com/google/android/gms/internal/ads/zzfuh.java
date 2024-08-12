/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftm
 *  com.google.android.gms.internal.ads.zzful
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftm;
import com.google.android.gms.internal.ads.zzful;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Set;

final class zzfuh
implements zzful {
    final zzftm zza;

    zzfuh(zzftm zzftm2) {
        this.zza = zzftm2;
    }

    public final <Q> zzftm<Q> zza(Class<Q> clazz) throws GeneralSecurityException {
        if (!this.zza.zze().equals(clazz)) throw new InternalError("This should never be called, as we always first check supportedPrimitives.");
        return this.zza;
    }

    public final zzftm<?> zzb() {
        return this.zza;
    }

    public final Class<?> zzc() {
        return this.zza.getClass();
    }

    public final Set<Class<?>> zzd() {
        return Collections.singleton(this.zza.zze());
    }

    public final Class<?> zze() {
        return null;
    }
}
