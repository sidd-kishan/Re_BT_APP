/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfrw
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfrw;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Executor;

public abstract class zzfry<V>
extends zzfrw<V>
implements zzfsm<V> {
    protected zzfry() {
    }

    protected abstract zzfsm<? extends V> zzc();

    public final void zze(Runnable runnable, Executor executor) {
        this.zzc().zze(runnable, executor);
    }
}
