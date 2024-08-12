/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzfif
 *  com.google.android.gms.internal.ads.zzfig
 *  com.google.android.gms.internal.ads.zzfih
 *  com.google.android.gms.internal.ads.zzfkk
 *  com.google.android.gms.internal.ads.zzfmk
 *  com.google.android.gms.internal.ads.zzxz
 *  com.google.android.gms.tasks.Continuation
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.Tasks
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzfif;
import com.google.android.gms.internal.ads.zzfig;
import com.google.android.gms.internal.ads.zzfih;
import com.google.android.gms.internal.ads.zzfkk;
import com.google.android.gms.internal.ads.zzfmk;
import com.google.android.gms.internal.ads.zzxz;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class zzfii {
    public static final int zza = 0;
    private static volatile int zzf = 1;
    private final Context zzb;
    private final Executor zzc;
    private final Task<zzfkk> zzd;
    private final boolean zze;

    zzfii(Context context, Executor executor, Task<zzfkk> task, boolean bl) {
        this.zzb = context;
        this.zzc = executor;
        this.zzd = task;
        this.zze = bl;
    }

    public static zzfii zza(Context context, Executor executor, boolean bl) {
        return new zzfii(context, executor, (Task<zzfkk>)Tasks.call((Executor)executor, (Callable)new zzfif(context, bl)), bl);
    }

    static void zzg(int n) {
        zzf = n;
    }

    private final Task<Boolean> zzh(int n, long l, Exception exception, String string, Map<String, String> zzxv2, String string2) {
        if (!this.zze) {
            return this.zzd.continueWith(this.zzc, zzfig.zza);
        }
        zzxv2 = zzxz.zza();
        zzxv2.zza(this.zzb.getPackageName());
        zzxv2.zzb(l);
        zzxv2.zzg(zzf);
        if (exception != null) {
            zzxv2.zzc(zzfmk.zzb((Throwable)exception));
            zzxv2.zzd(exception.getClass().getName());
        }
        if (string2 != null) {
            zzxv2.zze(string2);
        }
        if (string == null) return this.zzd.continueWith(this.zzc, (Continuation)new zzfih(zzxv2, n));
        zzxv2.zzf(string);
        return this.zzd.continueWith(this.zzc, (Continuation)new zzfih(zzxv2, n));
    }

    public final Task<Boolean> zzb(int n, long l) {
        return this.zzh(n, l, null, null, null, null);
    }

    public final Task<Boolean> zzc(int n, long l, Exception exception) {
        return this.zzh(n, l, exception, null, null, null);
    }

    public final Task<Boolean> zzd(int n, long l, String string, Map<String, String> map) {
        return this.zzh(n, l, null, string, null, null);
    }

    public final Task<Boolean> zze(int n, String string) {
        return this.zzh(n, 0L, null, null, null, string);
    }

    public final Task<Boolean> zzf(int n, long l, String string) {
        return this.zzh(n, l, null, null, null, string);
    }
}
