/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbxn
 *  com.google.android.gms.internal.ads.zzdbp
 *  com.google.android.gms.internal.ads.zzdbu
 *  com.google.android.gms.internal.ads.zzdkm
 *  com.google.android.gms.internal.ads.zzdkn
 *  com.google.android.gms.internal.ads.zzezz
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbxn;
import com.google.android.gms.internal.ads.zzdbp;
import com.google.android.gms.internal.ads.zzdbu;
import com.google.android.gms.internal.ads.zzdkm;
import com.google.android.gms.internal.ads.zzdkn;
import com.google.android.gms.internal.ads.zzezz;

final class zzegh
implements zzdkn {
    private final zzezz zza;
    private final zzbxn zzb;
    private final boolean zzc;
    private zzdbu zzd = null;

    zzegh(zzezz zzezz2, zzbxn zzbxn2, boolean bl) {
        this.zza = zzezz2;
        this.zzb = zzbxn2;
        this.zzc = bl;
    }

    public final void zza(boolean bl, Context context, zzdbp zzdbp2) throws zzdkm {
        try {
            bl = this.zzc ? this.zzb.zzm(ObjectWrapper.wrap((Object)context)) : this.zzb.zzk(ObjectWrapper.wrap((Object)context));
            if (!bl) throw new zzdkm("Adapter failed to show.");
            if (this.zzd == null) {
                return;
            }
            context = zzbjl.zzba;
            if ((Boolean)zzbet.zzc().zzc((zzbjd)context) != false) return;
            if (this.zza.zzU != 2) return;
        }
        catch (Throwable throwable) {
            throw new zzdkm(throwable);
        }
        this.zzd.zza();
    }

    public final void zzb(zzdbu zzdbu2) {
        this.zzd = zzdbu2;
    }
}
