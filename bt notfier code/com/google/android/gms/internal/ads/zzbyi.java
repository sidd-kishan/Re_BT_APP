/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.google.android.gms.internal.ads.zzbyj
 */
package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.internal.ads.zzbyj;

final class zzbyi
implements View.OnClickListener {
    final zzbyj zza;

    zzbyi(zzbyj zzbyj2) {
        this.zza = zzbyj2;
    }

    public final void onClick(View view) {
        this.zza.zzb(true);
    }
}
