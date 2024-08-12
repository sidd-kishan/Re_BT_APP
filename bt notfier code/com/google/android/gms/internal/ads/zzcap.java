/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcar
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcar;
import com.google.android.gms.internal.ads.zzcgt;

final class zzcap
implements Thread.UncaughtExceptionHandler {
    final Thread.UncaughtExceptionHandler zza;
    final zzcar zzb;

    zzcap(zzcar zzcar2, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzb = zzcar2;
        this.zza = uncaughtExceptionHandler;
    }

    @Override
    public final void uncaughtException(Thread thread, Throwable throwable) {
        try {
            this.zzb.zzc(thread, throwable);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.zza;
            if (uncaughtExceptionHandler == null) return;
            uncaughtExceptionHandler.uncaughtException(thread, throwable);
            return;
        }
        catch (Throwable throwable2) {
            try {
                zzcgt.zzf((String)"AdMob exception reporter failed reporting the exception.");
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.zza;
                if (uncaughtExceptionHandler == null) return;
                uncaughtExceptionHandler.uncaughtException(thread, throwable);
            }
            catch (Throwable throwable3) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.zza;
                if (uncaughtExceptionHandler == null) throw throwable3;
                uncaughtExceptionHandler.uncaughtException(thread, throwable);
                throw throwable3;
            }
        }
    }
}
