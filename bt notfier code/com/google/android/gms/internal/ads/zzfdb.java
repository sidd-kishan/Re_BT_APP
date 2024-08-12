/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfcc
 *  com.google.android.gms.internal.ads.zzfcl
 *  com.google.android.gms.internal.ads.zzfcw
 *  com.google.android.gms.internal.ads.zzfcx
 *  com.google.android.gms.internal.ads.zzfde
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfcc;
import com.google.android.gms.internal.ads.zzfcl;
import com.google.android.gms.internal.ads.zzfcw;
import com.google.android.gms.internal.ads.zzfcx;
import com.google.android.gms.internal.ads.zzfde;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsm;

final class zzfdb
implements zzfrk {
    private final zzfde zza;
    private final zzfcw zzb;
    private final zzfcc zzc;
    private final zzfcx zzd;

    zzfdb(zzfde zzfde2, zzfcw zzfcw2, zzfcc zzfcc2, zzfcx zzfcx2) {
        this.zza = zzfde2;
        this.zzb = zzfcw2;
        this.zzc = zzfcc2;
        this.zzd = zzfcx2;
    }

    public final zzfsm zza(Object object) {
        return this.zza.zzd(this.zzb, this.zzc, this.zzd, (zzfcl)object);
    }
}
