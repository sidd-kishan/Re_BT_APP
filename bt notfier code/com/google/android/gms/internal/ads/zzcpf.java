/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbty
 *  com.google.android.gms.internal.ads.zzbtz
 *  com.google.android.gms.internal.ads.zzbud
 *  com.google.android.gms.internal.ads.zzcbt
 *  com.google.android.gms.internal.ads.zzcbu
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzcoo
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbty;
import com.google.android.gms.internal.ads.zzbtz;
import com.google.android.gms.internal.ads.zzbud;
import com.google.android.gms.internal.ads.zzcbt;
import com.google.android.gms.internal.ads.zzcbu;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzcoo;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;

public final class zzcpf
implements zzgla<zzcbu> {
    private final zzgln<Context> zza;

    public zzcpf(zzgln<Context> zzgln2) {
        this.zza = zzgln2;
    }

    public final zzcbu zza() {
        Context context = ((zzcoo)this.zza).zza();
        zzt.zzp().zza(context, zzcgz.zza()).zza("google.afma.request.getAdDictionary", (zzbtz)zzbud.zza, (zzbty)zzbud.zza);
        return new zzcbt(context, zzt.zzp().zza(context, zzcgz.zza()).zza("google.afma.sdkConstants.getSdkConstants", (zzbtz)zzbud.zza, (zzbty)zzbud.zza));
    }
}
