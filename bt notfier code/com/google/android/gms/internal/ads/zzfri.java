/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfqw$zzj
 *  com.google.android.gms.internal.ads.zzfre
 *  com.google.android.gms.internal.ads.zzfrg
 *  com.google.android.gms.internal.ads.zzfrh
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfqw;
import com.google.android.gms.internal.ads.zzfre;
import com.google.android.gms.internal.ads.zzfrg;
import com.google.android.gms.internal.ads.zzfrh;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

abstract class zzfri<OutputT>
extends zzfqw.zzj<OutputT> {
    private static final zzfre zzaO;
    private static final Logger zzaP;
    private volatile int remaining;
    @CheckForNull
    private volatile Set<Throwable> seenExceptions = null;

    static {
        Throwable throwable;
        zzfrg zzfrg2;
        zzaP = Logger.getLogger(zzfri.class.getName());
        try {
            zzfrg2 = new zzfrg(AtomicReferenceFieldUpdater.newUpdater(zzfri.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(zzfri.class, "remaining"));
            throwable = null;
        }
        catch (Throwable throwable2) {
            zzfrg2 = new zzfrh(null);
        }
        zzaO = zzfrg2;
        if (throwable == null) return;
        zzaP.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", throwable);
    }

    zzfri(int n) {
        this.remaining = n;
    }

    static /* synthetic */ Set zzC(zzfri zzfri2) {
        return zzfri2.seenExceptions;
    }

    static /* synthetic */ Set zzD(zzfri zzfri2, Set set) {
        zzfri2.seenExceptions = set;
        return set;
    }

    static /* synthetic */ int zzE(zzfri zzfri2) {
        return zzfri2.remaining;
    }

    static /* synthetic */ int zzF(zzfri zzfri2, int n) {
        zzfri2.remaining = n;
        return n;
    }

    final Set<Throwable> zzG() {
        Set<Throwable> set = this.seenExceptions;
        Set<Throwable> set2 = set;
        if (set != null) return set2;
        set2 = Collections.newSetFromMap(new ConcurrentHashMap());
        this.zzw(set2);
        zzaO.zza(this, null, set2);
        set2 = this.seenExceptions;
        set2.getClass();
        return set2;
    }

    final int zzH() {
        return zzaO.zzb(this);
    }

    final void zzI() {
        this.seenExceptions = null;
    }

    abstract void zzw(Set<Throwable> var1);
}
