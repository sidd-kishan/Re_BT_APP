/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 *  com.google.android.gms.internal.ads.zzdnl
 */
package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import com.google.android.gms.internal.ads.zzdnl;

final class zzdnj
implements Runnable {
    private final zzdnl zza;
    private final ViewGroup zzb;

    zzdnj(zzdnl zzdnl2, ViewGroup viewGroup) {
        this.zza = zzdnl2;
        this.zzb = viewGroup;
    }

    @Override
    public final void run() {
        this.zza.zze(this.zzb);
    }
}
