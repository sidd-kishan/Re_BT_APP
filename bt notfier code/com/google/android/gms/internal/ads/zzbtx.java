/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzblg
 *  com.google.android.gms.internal.ads.zzbug
 *  com.google.android.gms.internal.ads.zzcgz
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzblg;
import com.google.android.gms.internal.ads.zzbug;
import com.google.android.gms.internal.ads.zzcgz;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzbtx {
    private final Object zza = new Object();
    private final Object zzb = new Object();
    private zzbug zzc;
    private zzbug zzd;

    private static final Context zzc(Context context) {
        Context context2 = context.getApplicationContext();
        if (context2 != null) return context2;
        return context;
    }

    public final zzbug zza(Context context, zzcgz zzcgz2) {
        Object object = this.zzb;
        synchronized (object) {
            if (this.zzd == null) {
                zzbug zzbug2;
                this.zzd = zzbug2 = new zzbug(zzbtx.zzc(context), zzcgz2, (String)zzblg.zzb.zze());
            }
            context = this.zzd;
            return context;
        }
    }

    public final zzbug zzb(Context context, zzcgz zzcgz2) {
        Object object = this.zza;
        synchronized (object) {
            if (this.zzc == null) {
                zzbug zzbug2;
                context = zzbtx.zzc(context);
                zzbjd zzbjd2 = zzbjl.zza;
                this.zzc = zzbug2 = new zzbug(context, zzcgz2, (String)zzbet.zzc().zzc(zzbjd2));
            }
            context = this.zzc;
            return context;
        }
    }
}
