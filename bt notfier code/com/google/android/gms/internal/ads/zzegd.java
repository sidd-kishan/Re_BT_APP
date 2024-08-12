/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzdjj
 *  com.google.android.gms.internal.ads.zzegf
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzdjj;
import com.google.android.gms.internal.ads.zzegf;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfln;

final class zzegd
implements zzfln {
    private final zzegf zza;
    private final zzcml zzb;
    private final zzezz zzc;
    private final zzdjj zzd;

    zzegd(zzegf zzegf2, zzcml zzcml2, zzezz zzezz2, zzdjj zzdjj2) {
        this.zza = zzegf2;
        this.zzb = zzcml2;
        this.zzc = zzezz2;
        this.zzd = zzdjj2;
    }

    public final Object apply(Object object) {
        zzcml zzcml2 = this.zzb;
        object = this.zzc;
        zzdjj zzdjj2 = this.zzd;
        if (((zzezz)object).zzI) {
            zzcml2.zzau();
        }
        zzcml2.zzL();
        zzcml2.onPause();
        return zzdjj2.zzh();
    }
}
