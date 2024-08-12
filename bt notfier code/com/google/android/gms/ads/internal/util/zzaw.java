/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zzaz
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbgp
 */
package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzaz;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbgp;

final class zzaw
extends zzbgp {
    final Context zza;
    final zzaz zzb;

    zzaw(zzaz zzaz2, Context context) {
        this.zzb = zzaz2;
        this.zza = context;
    }

    public final void zze(zzbcz zzbcz2) {
        if (zzbcz2 == null) {
            return;
        }
        this.zzb.zzn(this.zza, zzbcz2.zzb, true, true);
    }
}
