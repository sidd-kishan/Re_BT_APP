/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfqw
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfqw;
import javax.annotation.CheckForNull;

final class zzfqw$zzb {
    @CheckForNull
    static final zzfqw$zzb zza;
    @CheckForNull
    static final zzfqw$zzb zzb;
    final boolean zzc;
    @CheckForNull
    final Throwable zzd;

    static {
        if (zzfqw.zzf()) {
            zzb = null;
            zza = null;
        } else {
            zzb = new zzfqw$zzb(false, null);
            zza = new zzfqw$zzb(true, null);
        }
    }

    zzfqw$zzb(boolean bl, @CheckForNull Throwable throwable) {
        this.zzc = bl;
        this.zzd = throwable;
    }
}
