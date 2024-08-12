/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzdrx
 *  com.google.android.gms.internal.ads.zzein
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzdrx;
import com.google.android.gms.internal.ads.zzein;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfln;

final class zzeij
implements zzfln {
    private final zzein zza;
    private final zzcml zzb;
    private final zzezz zzc;
    private final zzdrx zzd;

    zzeij(zzein zzein2, zzcml zzcml2, zzezz zzezz2, zzdrx zzdrx2) {
        this.zza = zzein2;
        this.zzb = zzcml2;
        this.zzc = zzezz2;
        this.zzd = zzdrx2;
    }

    public final Object apply(Object object) {
        zzcml zzcml2 = this.zzb;
        zzezz zzezz2 = this.zzc;
        object = this.zzd;
        if (zzezz2.zzI) {
            zzcml2.zzau();
        }
        zzcml2.zzL();
        zzcml2.onPause();
        return object.zzh();
    }
}
