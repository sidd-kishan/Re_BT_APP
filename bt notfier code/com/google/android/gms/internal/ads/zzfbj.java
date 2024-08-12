/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;

public final class zzfbj<T> {
    private final Deque<zzfsm<T>> zza = new LinkedBlockingDeque<zzfsm<T>>();
    private final Callable<T> zzb;
    private final zzfsn zzc;

    public zzfbj(Callable<T> callable, zzfsn zzfsn2) {
        this.zzb = callable;
        this.zzc = zzfsn2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zza(int n) {
        synchronized (this) {
            int n2 = this.zza.size();
            int n3 = 0;
            while (n3 < n - n2) {
                this.zza.add(this.zzc.zzb(this.zzb));
                ++n3;
            }
            return;
        }
    }

    public final zzfsm<T> zzb() {
        synchronized (this) {
            this.zza(1);
            zzfsm<T> zzfsm2 = this.zza.poll();
            return zzfsm2;
        }
    }

    public final void zzc(zzfsm<T> zzfsm2) {
        synchronized (this) {
            this.zza.addFirst(zzfsm2);
            return;
        }
    }
}
