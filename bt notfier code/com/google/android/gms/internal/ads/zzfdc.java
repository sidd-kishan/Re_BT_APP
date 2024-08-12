/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfcw
 *  com.google.android.gms.internal.ads.zzfde
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfcw;
import com.google.android.gms.internal.ads.zzfde;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsm;

final class zzfdc
implements zzfrk {
    private final zzfde zza;
    private final zzfcw zzb;

    zzfdc(zzfde zzfde2, zzfcw zzfcw2) {
        this.zza = zzfde2;
        this.zzb = zzfcw2;
    }

    public final zzfsm zza(Object object) {
        return this.zza.zzc(this.zzb, (Exception)object);
    }
}
