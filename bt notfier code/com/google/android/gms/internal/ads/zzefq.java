/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel
 *  com.google.android.gms.ads.internal.overlay.zzm
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzchl
 *  com.google.android.gms.internal.ads.zzdbp
 *  com.google.android.gms.internal.ads.zzdkn
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzdbp;
import com.google.android.gms.internal.ads.zzdkn;

final class zzefq
implements zzdkn {
    private final zzchl zza;

    zzefq(zzchl zzchl2) {
        this.zza = zzchl2;
    }

    /*
     * Enabled force condition propagation
     */
    public final void zza(boolean bl, Context context, zzdbp zzdbp2) {
        zzdbp2 = this.zza;
        try {
            zzt.zzb();
            zzm.zza((Context)context, (AdOverlayInfoParcel)((AdOverlayInfoParcel)zzdbp2.get()), (boolean)true);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }
}
