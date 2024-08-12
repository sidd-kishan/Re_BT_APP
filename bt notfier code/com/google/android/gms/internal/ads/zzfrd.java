/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzflx
 *  com.google.android.gms.internal.ads.zzfoe
 *  com.google.android.gms.internal.ads.zzfql
 *  com.google.android.gms.internal.ads.zzfrb
 *  com.google.android.gms.internal.ads.zzfrc
 *  com.google.android.gms.internal.ads.zzfri
 *  com.google.android.gms.internal.ads.zzfrr
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzflx;
import com.google.android.gms.internal.ads.zzfoe;
import com.google.android.gms.internal.ads.zzfql;
import com.google.android.gms.internal.ads.zzfrb;
import com.google.android.gms.internal.ads.zzfrc;
import com.google.android.gms.internal.ads.zzfri;
import com.google.android.gms.internal.ads.zzfrr;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

abstract class zzfrd<InputT, OutputT>
extends zzfri<OutputT> {
    private static final Logger zza = Logger.getLogger(zzfrd.class.getName());
    @CheckForNull
    private zzfoe<? extends zzfsm<? extends InputT>> zzb;
    private final boolean zzc;
    private final boolean zzd;

    zzfrd(zzfoe<? extends zzfsm<? extends InputT>> zzfoe2, boolean bl, boolean bl2) {
        super(zzfoe2.size());
        if (zzfoe2 == null) throw null;
        this.zzb = zzfoe2;
        this.zzc = bl;
        this.zzd = bl2;
    }

    private final void zzJ(Throwable throwable) {
        if (throwable == null) throw null;
        if (this.zzc && !this.zzq(throwable) && zzfrd.zzM(this.zzG(), throwable)) {
            zzfrd.zzK(throwable);
            return;
        }
        if (!(throwable instanceof Error)) return;
        zzfrd.zzK(throwable);
    }

    private static void zzK(Throwable throwable) {
        String string = true != throwable instanceof Error ? "Got more than one input Future failure. Logging failures after the first" : "Input Future failed with Error";
        zza.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", string, throwable);
    }

    private final void zzL(int n, Future<? extends InputT> future) {
        try {
            this.zzz(n, zzfsd.zzq(future));
            return;
        }
        catch (Throwable throwable) {
            this.zzJ(throwable);
            return;
        }
        catch (ExecutionException executionException) {
            this.zzJ(executionException.getCause());
            return;
        }
    }

    private static boolean zzM(Set<Throwable> set, Throwable throwable) {
        while (throwable != null) {
            if (!set.add(throwable)) {
                return false;
            }
            throwable = throwable.getCause();
        }
        return true;
    }

    static /* synthetic */ zzfoe zza(zzfrd zzfrd2, zzfoe zzfoe2) {
        zzfrd2.zzb = null;
        return null;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    static /* synthetic */ void zzx(zzfrd zzfrd2, int n, Future future) {
        zzfrd2.zzL(n, future);
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    static /* synthetic */ void zzy(zzfrd zzfrd2, zzfoe object) {
        int n = zzfrd2.zzH();
        int n2 = 0;
        boolean bl = n >= 0;
        zzflx.zzb((boolean)bl, (Object)"Less than 0 remaining futures");
        if (n != 0) return;
        if (object != null) {
            zzfql zzfql2 = object.zza();
            while (zzfql2.hasNext()) {
                object = (Future)zzfql2.next();
                if (!object.isCancelled()) {
                    zzfrd2.zzL(n2, (Future)object);
                }
                ++n2;
            }
        }
        zzfrd2.zzI();
        zzfrd2.zzA();
        zzfrd2.zzB(2);
    }

    abstract void zzA();

    void zzB(int n) {
        this.zzb = null;
    }

    final void zzb() {
        Object object = this.zzb;
        object.getClass();
        if (object.isEmpty()) {
            this.zzA();
            return;
        }
        if (this.zzc) {
            zzfql zzfql2 = this.zzb.zza();
            int n = 0;
            while (zzfql2.hasNext()) {
                object = (zzfsm)zzfql2.next();
                object.zze((Runnable)new zzfrb(this, (zzfsm)object, n), (Executor)zzfrr.zza);
                ++n;
            }
            return;
        }
        object = this.zzd ? this.zzb : null;
        object = new zzfrc(this, object);
        zzfql zzfql3 = this.zzb.zza();
        while (zzfql3.hasNext()) {
            ((zzfsm)zzfql3.next()).zze((Runnable)object, (Executor)zzfrr.zza);
        }
    }

    @CheckForNull
    protected final String zzc() {
        zzfoe<zzfsm<InputT>> zzfoe2 = this.zzb;
        if (zzfoe2 == null) return super.zzc();
        return "futures=".concat(zzfoe2.toString());
    }

    protected final void zzd() {
        zzfql zzfql2 = this.zzb;
        boolean bl = true;
        this.zzB(1);
        boolean bl2 = this.isCancelled();
        if (zzfql2 == null) {
            bl = false;
        }
        if (!(bl & bl2)) return;
        bl2 = this.zzo();
        zzfql2 = zzfql2.zza();
        while (zzfql2.hasNext()) {
            ((Future)zzfql2.next()).cancel(bl2);
        }
    }

    final void zzw(Set<Throwable> set) {
        if (set == null) throw null;
        if (this.isCancelled()) return;
        Throwable throwable = this.zzu();
        throwable.getClass();
        zzfrd.zzM(set, throwable);
    }

    abstract void zzz(int var1, InputT var2);
}
