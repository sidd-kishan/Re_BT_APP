/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfts
 *  com.google.android.gms.internal.ads.zzfux
 *  com.google.android.gms.internal.ads.zzfxt
 *  com.google.android.gms.internal.ads.zzfxu
 *  com.google.android.gms.internal.ads.zzfxx
 *  com.google.android.gms.internal.ads.zzfya
 *  com.google.android.gms.internal.ads.zzgds
 *  com.google.android.gms.internal.ads.zzgdu
 *  com.google.android.gms.internal.ads.zzgex
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfts;
import com.google.android.gms.internal.ads.zzfux;
import com.google.android.gms.internal.ads.zzfxt;
import com.google.android.gms.internal.ads.zzfxu;
import com.google.android.gms.internal.ads.zzfxx;
import com.google.android.gms.internal.ads.zzfya;
import com.google.android.gms.internal.ads.zzgds;
import com.google.android.gms.internal.ads.zzgdu;
import com.google.android.gms.internal.ads.zzgex;
import java.security.GeneralSecurityException;

final class zzfuw
extends zzfts<zzfxx, zzfxu> {
    final zzfux zza;

    zzfuw(zzfux zzfux2, Class clazz) {
        this.zza = zzfux2;
        super(clazz);
    }

    public static final zzfxu zzg(zzfxx zzfxx2) throws GeneralSecurityException {
        zzfxt zzfxt2 = zzfxu.zzf();
        zzfxt2.zzb(zzfxx2.zza());
        zzfxt2.zzc(zzgex.zzt((byte[])zzgds.zza((int)zzfxx2.zzc())));
        zzfxt2.zza(0);
        return (zzfxu)zzfxt2.zzah();
    }

    public final void zzf(zzfxx zzfxx2) throws GeneralSecurityException {
        zzgdu.zza((int)zzfxx2.zzc());
        zzfux.zzk((zzfux)this.zza, (zzfya)zzfxx2.zza());
    }
}
