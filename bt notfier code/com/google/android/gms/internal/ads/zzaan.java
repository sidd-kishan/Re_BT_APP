/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.ConditionVariable
 *  com.google.android.gms.internal.ads.zzaam
 *  com.google.android.gms.internal.ads.zzabr
 *  com.google.android.gms.internal.ads.zzfkk
 *  com.google.android.gms.internal.ads.zzged
 *  com.google.android.gms.internal.ads.zzxv
 *  com.google.android.gms.internal.ads.zzxz
 */
package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.ConditionVariable;
import com.google.android.gms.internal.ads.zzaam;
import com.google.android.gms.internal.ads.zzabr;
import com.google.android.gms.internal.ads.zzfkk;
import com.google.android.gms.internal.ads.zzged;
import com.google.android.gms.internal.ads.zzxv;
import com.google.android.gms.internal.ads.zzxz;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public final class zzaan {
    protected static volatile zzfkk zza;
    private static final ConditionVariable zzd;
    private static volatile Random zze;
    protected volatile Boolean zzb;
    private final zzabr zzc;

    static {
        zzd = new ConditionVariable();
        zza = null;
        zze = null;
    }

    public zzaan(zzabr zzabr2) {
        this.zzc = zzabr2;
        zzabr2.zze().execute((Runnable)new zzaam(this));
    }

    static /* synthetic */ zzabr zza(zzaan zzaan2) {
        return zzaan2.zzc;
    }

    static /* synthetic */ ConditionVariable zzb() {
        return zzd;
    }

    public static final int zzd() {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                return ThreadLocalRandom.current().nextInt();
            }
            int n = zzaan.zze().nextInt();
            return n;
        }
        catch (RuntimeException runtimeException) {
            return zzaan.zze().nextInt();
        }
    }

    private static Random zze() {
        if (zze != null) return zze;
        synchronized (zzaan.class) {
            Random random;
            if (zze != null) return zze;
            zze = random = new Random();
        }
        return zze;
    }

    /*
     * Enabled force condition propagation
     */
    public final void zzc(int n, int n2, long l, String object, Exception exception) {
        try {
            zzd.block();
            if (this.zzb == false) return;
            if (zza == null) return;
            zzxv zzxv2 = zzxz.zza();
            zzxv2.zza(this.zzc.zza.getPackageName());
            zzxv2.zzb(l);
            if (object != null) {
                zzxv2.zze((String)object);
            }
            if (exception != null) {
                object = new StringWriter();
                PrintWriter printWriter = new PrintWriter((Writer)object);
                zzged.zzc((Throwable)exception, (PrintWriter)printWriter);
                zzxv2.zzc(((StringWriter)object).toString());
                zzxv2.zzd(exception.getClass().getName());
            }
            object = zza.zza(((zzxz)zzxv2.zzah()).zzao());
            object.zzc(n);
            if (n2 != -1) {
                object.zzb(n2);
            }
            object.zza();
            return;
        }
        catch (Exception exception2) {
            return;
        }
    }
}
