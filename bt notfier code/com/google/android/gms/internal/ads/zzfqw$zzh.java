/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfqw
 *  com.google.android.gms.internal.ads.zzfqw$zza
 *  com.google.android.gms.internal.ads.zzfqw$zzd
 *  com.google.android.gms.internal.ads.zzfqw$zze
 *  com.google.android.gms.internal.ads.zzfqw$zzl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfqw;
import javax.annotation.CheckForNull;

final class zzfqw$zzh
extends zzfqw.zza {
    private zzfqw$zzh() {
        super(null);
    }

    /* synthetic */ zzfqw$zzh(zzfqw.zze zze2) {
        super(null);
    }

    final void zza(zzfqw.zzl zzl2, Thread thread) {
        zzl2.thread = thread;
    }

    final void zzb(zzfqw.zzl zzl2, @CheckForNull zzfqw.zzl zzl3) {
        zzl2.next = zzl3;
    }

    final boolean zzc(zzfqw<?> zzfqw2, @CheckForNull zzfqw.zzl zzl2, @CheckForNull zzfqw.zzl zzl3) {
        synchronized (zzfqw2) {
            if (zzfqw.zzl(zzfqw2) != zzl2) return false;
            zzfqw.zzm(zzfqw2, (zzfqw.zzl)zzl3);
            return true;
        }
    }

    final boolean zzd(zzfqw<?> zzfqw2, @CheckForNull zzfqw.zzd zzd2, zzfqw.zzd zzd3) {
        synchronized (zzfqw2) {
            if (zzfqw.zzj(zzfqw2) != zzd2) return false;
            zzfqw.zzk(zzfqw2, (zzfqw.zzd)zzd3);
            return true;
        }
    }

    final boolean zze(zzfqw<?> zzfqw2, @CheckForNull Object object, Object object2) {
        synchronized (zzfqw2) {
            if (zzfqw.zzh(zzfqw2) != object) return false;
            zzfqw.zzi(zzfqw2, (Object)object2);
            return true;
        }
    }
}
