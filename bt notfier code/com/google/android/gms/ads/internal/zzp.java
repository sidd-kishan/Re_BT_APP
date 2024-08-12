/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  com.google.android.gms.ads.internal.zzq
 *  com.google.android.gms.ads.internal.zzs
 *  com.google.android.gms.internal.ads.zzaas
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.ads.zzaas;
import com.google.android.gms.internal.ads.zzcgt;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class zzp
extends AsyncTask<Void, Void, String> {
    final zzs zza;

    /* synthetic */ zzp(zzs zzs2, zzq zzq2) {
        this.zza = zzs2;
    }

    /*
     * WARNING - void declaration
     */
    protected final String zza(Void ... zzs2) {
        block4: {
            void var1_5;
            try {
                zzs2 = this.zza;
                zzs.zzh((zzs)zzs2, (zzaas)((zzaas)zzs.zzc((zzs)zzs2).get(1000L, TimeUnit.MILLISECONDS)));
                break block4;
            }
            catch (TimeoutException timeoutException) {
                zzcgt.zzj((String)"", (Throwable)timeoutException);
                break block4;
            }
            catch (ExecutionException executionException) {
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
            zzcgt.zzj((String)"", (Throwable)var1_5);
        }
        return this.zza.zzT();
    }
}
