/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.google.android.gms.internal.ads.zzfga
 *  com.google.android.gms.internal.ads.zzfgd
 *  com.google.android.gms.internal.ads.zzfge
 *  com.google.android.gms.internal.ads.zzfgg
 *  com.google.android.gms.internal.ads.zzfgi
 */
package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.internal.ads.zzfga;
import com.google.android.gms.internal.ads.zzfgd;
import com.google.android.gms.internal.ads.zzfge;
import com.google.android.gms.internal.ads.zzfgg;
import com.google.android.gms.internal.ads.zzfgi;

public abstract class zzfgc {
    public static zzfgc zze(zzfgd zzfgd2, zzfge zzfge2) {
        if (!zzfga.zzb()) throw new IllegalStateException("Method called before OM SDK activation");
        return new zzfgg(zzfgd2, zzfge2);
    }

    public abstract void zza();

    public abstract void zzb(View var1);

    public abstract void zzc();

    public abstract void zzd(View var1, zzfgi var2, String var3);
}
