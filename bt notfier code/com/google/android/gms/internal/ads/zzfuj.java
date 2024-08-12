/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftm
 *  com.google.android.gms.internal.ads.zzftu
 *  com.google.android.gms.internal.ads.zzfuf
 *  com.google.android.gms.internal.ads.zzfug
 *  com.google.android.gms.internal.ads.zzful
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftm;
import com.google.android.gms.internal.ads.zzftu;
import com.google.android.gms.internal.ads.zzfuf;
import com.google.android.gms.internal.ads.zzfug;
import com.google.android.gms.internal.ads.zzful;
import java.security.GeneralSecurityException;
import java.util.Set;

final class zzfuj
implements zzful {
    final zzfug zza;
    final zzftu zzb;

    zzfuj(zzfug zzfug2, zzftu zzftu2) {
        this.zza = zzfug2;
        this.zzb = zzftu2;
    }

    public final <Q> zzftm<Q> zza(Class<Q> zzfuf2) throws GeneralSecurityException {
        try {
            zzfuf2 = new zzfuf(this.zza, this.zzb, zzfuf2);
            return zzfuf2;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new GeneralSecurityException("Primitive type not supported", illegalArgumentException);
        }
    }

    public final zzftm<?> zzb() {
        zzfug zzfug2 = this.zza;
        return new zzfuf(zzfug2, this.zzb, zzfug2.zzg());
    }

    public final Class<?> zzc() {
        return this.zza.getClass();
    }

    public final Set<Class<?>> zzd() {
        return this.zza.zzf();
    }

    public final Class<?> zze() {
        return this.zzb.getClass();
    }
}
