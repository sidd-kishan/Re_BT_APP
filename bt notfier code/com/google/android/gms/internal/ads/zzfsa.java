/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzflr
 *  com.google.android.gms.internal.ads.zzfls
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfte
 *  com.google.android.gms.internal.ads.zzftf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzflr;
import com.google.android.gms.internal.ads.zzfls;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfte;
import com.google.android.gms.internal.ads.zzftf;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

final class zzfsa<V>
implements Runnable {
    final Future<V> zza;
    final zzfrz<? super V> zzb;

    zzfsa(Future<V> future, zzfrz<? super V> zzfrz2) {
        this.zza = future;
        this.zzb = zzfrz2;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void run() {
        void var1_4;
        block5: {
            Future<V> future = this.zza;
            if (future instanceof zzfte && (future = zzftf.zza((zzfte)((zzfte)future))) != null) {
                this.zzb.zza((Throwable)((Object)future));
                return;
            }
            try {
                future = zzfsd.zzq(this.zza);
            }
            catch (Error error) {
                break block5;
            }
            catch (RuntimeException runtimeException) {
                // empty catch block
                break block5;
            }
            catch (ExecutionException executionException) {
                this.zzb.zza(executionException.getCause());
                return;
            }
            this.zzb.zzb((Object)future);
            return;
        }
        this.zzb.zza((Throwable)var1_4);
    }

    public final String toString() {
        zzflr zzflr2 = zzfls.zza((Object)this);
        zzflr2.zza(this.zzb);
        return zzflr2.toString();
    }
}
