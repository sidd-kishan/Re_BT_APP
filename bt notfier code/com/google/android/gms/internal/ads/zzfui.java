/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftm
 *  com.google.android.gms.internal.ads.zzfto
 *  com.google.android.gms.internal.ads.zzftu
 *  com.google.android.gms.internal.ads.zzful
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftm;
import com.google.android.gms.internal.ads.zzfto;
import com.google.android.gms.internal.ads.zzftu;
import com.google.android.gms.internal.ads.zzful;
import java.security.GeneralSecurityException;
import java.util.Set;

final class zzfui
implements zzful {
    final zzftu zza;

    zzfui(zzftu zzftu2) {
        this.zza = zzftu2;
    }

    public final <Q> zzftm<Q> zza(Class<Q> zzfto2) throws GeneralSecurityException {
        try {
            zzfto2 = new zzfto(this.zza, zzfto2);
            return zzfto2;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new GeneralSecurityException("Primitive type not supported", illegalArgumentException);
        }
    }

    public final zzftm<?> zzb() {
        zzftu zzftu2 = this.zza;
        return new zzfto(zzftu2, zzftu2.zzg());
    }

    public final Class<?> zzc() {
        return this.zza.getClass();
    }

    public final Set<Class<?>> zzd() {
        return this.zza.zzf();
    }

    public final Class<?> zze() {
        return null;
    }
}
