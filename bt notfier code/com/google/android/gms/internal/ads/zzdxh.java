/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdxi
 *  com.google.android.gms.internal.ads.zzdxk
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxi;
import com.google.android.gms.internal.ads.zzdxk;

final class zzdxh
implements Runnable {
    private final zzdxi zza;
    private final String zzb;

    zzdxh(zzdxi zzdxi2, String string) {
        this.zza = zzdxi2;
        this.zzb = string;
    }

    @Override
    public final void run() {
        zzdxi zzdxi2 = this.zza;
        String string = this.zzb;
        zzdxk.zzk((zzdxk)zzdxi2.zza, (String)string);
    }
}
