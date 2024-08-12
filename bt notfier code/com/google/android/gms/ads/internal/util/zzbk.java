/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zzbo
 *  com.google.android.gms.ads.internal.util.zzbr
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzwg
 *  com.google.android.gms.internal.ads.zzwl
 */
package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.util.zzbo;
import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzwg;
import com.google.android.gms.internal.ads.zzwl;

final class zzbk
implements zzwg {
    final String zza;
    final zzbo zzb;

    zzbk(zzbr zzbr2, String string, zzbo zzbo2) {
        this.zza = string;
        this.zzb = zzbo2;
    }

    public final void zza(zzwl object) {
        String string = this.zza;
        object = object.toString();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 21 + String.valueOf(object).length());
        stringBuilder.append("Failed to load URL: ");
        stringBuilder.append(string);
        stringBuilder.append("\n");
        stringBuilder.append((String)object);
        zze.zzi((String)stringBuilder.toString());
        this.zzb.zza(null);
    }
}
