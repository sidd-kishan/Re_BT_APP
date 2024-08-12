/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzdbp
 *  com.google.android.gms.internal.ads.zzdkm
 *  com.google.android.gms.internal.ads.zzdkn
 *  com.google.android.gms.internal.ads.zzeef
 *  com.google.android.gms.internal.ads.zzfaw
 *  com.google.android.gms.internal.ads.zzfbi
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzdbp;
import com.google.android.gms.internal.ads.zzdkm;
import com.google.android.gms.internal.ads.zzdkn;
import com.google.android.gms.internal.ads.zzeef;
import com.google.android.gms.internal.ads.zzfaw;
import com.google.android.gms.internal.ads.zzfbi;

final class zzehw
implements zzdkn {
    private final zzeef zza;

    zzehw(zzeef zzeef2) {
        this.zza = zzeef2;
    }

    public final void zza(boolean bl, Context context, zzdbp zzdbp2) {
        zzdbp2 = this.zza;
        try {
            ((zzfbi)zzdbp2.zzb).zzs(bl);
            ((zzfbi)zzdbp2.zzb).zzw(context);
            return;
        }
        catch (zzfaw zzfaw2) {
            throw new zzdkm(zzfaw2.getCause());
        }
    }
}
