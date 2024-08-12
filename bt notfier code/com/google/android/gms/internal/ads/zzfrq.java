/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfoe
 *  com.google.android.gms.internal.ads.zzfrd
 *  com.google.android.gms.internal.ads.zzfro
 *  com.google.android.gms.internal.ads.zzfrp
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfoe;
import com.google.android.gms.internal.ads.zzfrd;
import com.google.android.gms.internal.ads.zzfro;
import com.google.android.gms.internal.ads.zzfrp;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

final class zzfrq<V>
extends zzfrd<Object, V> {
    @CheckForNull
    private zzfrp<?> zza;

    zzfrq(zzfoe<? extends zzfsm<?>> zzfoe2, boolean bl, Executor executor, Callable<V> callable) {
        super(zzfoe2, bl, false);
        this.zza = new zzfro(this, callable, executor);
        this.zzb();
    }

    static /* synthetic */ zzfrp zzJ(zzfrq zzfrq2, zzfrp zzfrp2) {
        zzfrq2.zza = null;
        return null;
    }

    final void zzA() {
        zzfrp<?> zzfrp2 = this.zza;
        if (zzfrp2 == null) return;
        zzfrp2.zze();
    }

    final void zzB(int n) {
        super.zzB(n);
        if (n != 1) return;
        this.zza = null;
    }

    protected final void zzn() {
        zzfrp<?> zzfrp2 = this.zza;
        if (zzfrp2 == null) return;
        zzfrp2.zzh();
    }

    final void zzz(int n, @CheckForNull Object object) {
    }
}
