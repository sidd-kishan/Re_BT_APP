/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfts
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfts;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import java.security.GeneralSecurityException;

final class zzftn<KeyFormatProtoT extends zzghi, KeyProtoT extends zzghi> {
    final zzfts<KeyFormatProtoT, KeyProtoT> zza;

    zzftn(zzfts<KeyFormatProtoT, KeyProtoT> zzfts2) {
        this.zza = zzfts2;
    }

    final KeyProtoT zza(zzgex zzgex2) throws GeneralSecurityException, zzggm {
        zzgex2 = this.zza.zzc(zzgex2);
        this.zza.zzb((zzghi)zzgex2);
        return (KeyProtoT)this.zza.zzd((zzghi)zzgex2);
    }
}
