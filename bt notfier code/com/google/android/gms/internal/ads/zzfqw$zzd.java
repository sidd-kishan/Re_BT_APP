/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

final class zzfqw$zzd {
    static final zzfqw$zzd zza = new zzfqw$zzd();
    @CheckForNull
    zzfqw$zzd next;
    @CheckForNull
    final Runnable zzb;
    @CheckForNull
    final Executor zzc;

    zzfqw$zzd() {
        this.zzb = null;
        this.zzc = null;
    }

    zzfqw$zzd(Runnable runnable, Executor executor) {
        this.zzb = runnable;
        this.zzc = executor;
    }
}
