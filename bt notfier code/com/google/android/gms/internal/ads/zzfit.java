/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Looper
 *  com.google.android.gms.internal.ads.zzfiu
 *  com.google.android.gms.internal.ads.zzfje
 *  com.google.android.gms.internal.ads.zzfjf
 *  com.google.android.gms.internal.ads.zzfjh
 *  com.google.android.gms.internal.ads.zzfjj
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.internal.ads.zzfiu;
import com.google.android.gms.internal.ads.zzfje;
import com.google.android.gms.internal.ads.zzfjf;
import com.google.android.gms.internal.ads.zzfjh;
import com.google.android.gms.internal.ads.zzfjj;

public final class zzfit {
    private final Context zza;
    private final Looper zzb;

    public zzfit(Context context, Looper looper) {
        this.zza = context;
        this.zzb = looper;
    }

    public final void zza(String string) {
        zzfjh zzfjh2 = zzfjj.zza();
        zzfjh2.zza(this.zza.getPackageName());
        zzfjh2.zzc(2);
        zzfje zzfje2 = zzfjf.zza();
        zzfje2.zza(string);
        zzfje2.zzb(2);
        zzfjh2.zzb(zzfje2);
        string = (zzfjj)zzfjh2.zzah();
        new zzfiu(this.zza, this.zzb, (zzfjj)string).zza();
    }
}
