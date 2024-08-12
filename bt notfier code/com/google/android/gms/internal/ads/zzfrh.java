/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfre
 *  com.google.android.gms.internal.ads.zzfrf
 *  com.google.android.gms.internal.ads.zzfri
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfre;
import com.google.android.gms.internal.ads.zzfrf;
import com.google.android.gms.internal.ads.zzfri;
import java.util.Set;
import javax.annotation.CheckForNull;

final class zzfrh
extends zzfre {
    private zzfrh() {
        super(null);
    }

    /* synthetic */ zzfrh(zzfrf zzfrf2) {
        super(null);
    }

    final void zza(zzfri<?> zzfri2, @CheckForNull Set<Throwable> set, Set<Throwable> set2) {
        synchronized (zzfri2) {
            if (zzfri.zzC(zzfri2) != null) return;
            zzfri.zzD(zzfri2, set2);
            return;
        }
    }

    final int zzb(zzfri<?> zzfri2) {
        synchronized (zzfri2) {
            int n = zzfri.zzE(zzfri2) - 1;
            zzfri.zzF(zzfri2, (int)n);
            return n;
        }
    }
}
