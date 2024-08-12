/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfrj
 *  com.google.android.gms.internal.ads.zzfrt
 *  com.google.android.gms.internal.ads.zzfsl
 *  com.google.android.gms.internal.ads.zzfsz
 *  com.google.android.gms.internal.ads.zzfta
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfrj;
import com.google.android.gms.internal.ads.zzfrt;
import com.google.android.gms.internal.ads.zzfsl;
import com.google.android.gms.internal.ads.zzfsz;
import com.google.android.gms.internal.ads.zzfta;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import javax.annotation.CheckForNull;

final class zzftb<V>
extends zzfrt<V>
implements RunnableFuture<V> {
    @CheckForNull
    private volatile zzfsl<?> zza;

    zzftb(zzfrj<V> zzfrj2) {
        this.zza = new zzfsz(this, zzfrj2);
    }

    zzftb(Callable<V> callable) {
        this.zza = new zzfta(this, callable);
    }

    static <V> zzftb<V> zza(Runnable runnable, V v) {
        return new zzftb<V>(Executors.callable(runnable, v));
    }

    @Override
    public final void run() {
        zzfsl<?> zzfsl2 = this.zza;
        if (zzfsl2 != null) {
            zzfsl2.run();
        }
        this.zza = null;
    }

    @CheckForNull
    protected final String zzc() {
        Object object = this.zza;
        if (object == null) return super.zzc();
        String string = object.toString();
        object = new StringBuilder(string.length() + 7);
        ((StringBuilder)object).append("task=[");
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append("]");
        return ((StringBuilder)object).toString();
    }

    protected final void zzd() {
        zzfsl<?> zzfsl2;
        if (this.zzo() && (zzfsl2 = this.zza) != null) {
            zzfsl2.zzh();
        }
        this.zza = null;
    }
}
