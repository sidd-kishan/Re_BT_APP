/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  com.google.android.gms.internal.ads.zzvm
 *  com.google.android.gms.internal.ads.zzvo
 *  com.google.android.gms.internal.ads.zzvt
 *  com.google.android.gms.internal.ads.zzvv
 *  com.google.android.gms.internal.ads.zzvw
 *  com.google.android.gms.internal.ads.zzwc
 *  com.google.android.gms.internal.ads.zzwd
 *  com.google.android.gms.internal.ads.zzwe
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.ads.zzvm;
import com.google.android.gms.internal.ads.zzvo;
import com.google.android.gms.internal.ads.zzvt;
import com.google.android.gms.internal.ads.zzvv;
import com.google.android.gms.internal.ads.zzvw;
import com.google.android.gms.internal.ads.zzwc;
import com.google.android.gms.internal.ads.zzwd;
import com.google.android.gms.internal.ads.zzwe;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzwf {
    private final AtomicInteger zza;
    private final Set<zzwc<?>> zzb;
    private final PriorityBlockingQueue<zzwc<?>> zzc;
    private final PriorityBlockingQueue<zzwc<?>> zzd;
    private final zzvm zze;
    private final zzvv zzf;
    private final zzvw[] zzg;
    private zzvo zzh;
    private final List<zzwe> zzi;
    private final List<zzwd> zzj;
    private final zzvt zzk;

    public zzwf(zzvm zzvm2, zzvv zzvv2, int n) {
        zzvt zzvt2 = new zzvt(new Handler(Looper.getMainLooper()));
        this.zza = new AtomicInteger();
        this.zzb = new HashSet();
        this.zzc = new PriorityBlockingQueue();
        this.zzd = new PriorityBlockingQueue();
        this.zzi = new ArrayList<zzwe>();
        this.zzj = new ArrayList<zzwd>();
        this.zze = zzvm2;
        this.zzf = zzvv2;
        this.zzg = new zzvw[4];
        this.zzk = zzvt2;
    }

    public final void zza() {
        int n;
        zzvo zzvo2 = this.zzh;
        if (zzvo2 != null) {
            zzvo2.zzb();
        }
        zzvw[] zzvwArray = this.zzg;
        int n2 = 0;
        for (n = 0; n < 4; ++n) {
            zzvo2 = zzvwArray[n];
            if (zzvo2 == null) continue;
            zzvo2.zza();
        }
        this.zzh = zzvo2 = new zzvo(this.zzc, this.zzd, this.zze, this.zzk, null);
        zzvo2.start();
        n = n2;
        while (n < 4) {
            zzvo2 = new zzvw(this.zzd, this.zzf, this.zze, this.zzk, null);
            this.zzg[n] = zzvo2;
            zzvo2.start();
            ++n;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final <T> zzwc<T> zzb(zzwc<T> zzwc2) {
        zzwc2.zzg(this);
        Set<zzwc<?>> set = this.zzb;
        synchronized (set) {
            this.zzb.add(zzwc2);
        }
        zzwc2.zzh(this.zza.incrementAndGet());
        zzwc2.zzd("add-to-queue");
        this.zzd(zzwc2, 0);
        this.zzc.add(zzwc2);
        return zzwc2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    final <T> void zzc(zzwc<T> zzwc2) {
        Collection<Object> collection = this.zzb;
        // MONITORENTER : collection
        this.zzb.remove(zzwc2);
        // MONITOREXIT : collection
        collection = this.zzi;
        Iterator<zzwe> iterator = this.zzi.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                // MONITOREXIT : collection
                this.zzd(zzwc2, 5);
                return;
            }
            iterator.next().zza();
        }
        finally {
            // MONITORENTER : collection
        }
    }

    final void zzd(zzwc<?> object, int n) {
        object = this.zzj;
        synchronized (object) {
            try {
                Iterator<zzwd> iterator = this.zzj.iterator();
                while (iterator.hasNext()) {
                    iterator.next().zza();
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }
}
