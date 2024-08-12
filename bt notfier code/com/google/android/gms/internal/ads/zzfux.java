/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfts
 *  com.google.android.gms.internal.ads.zzftt
 *  com.google.android.gms.internal.ads.zzftu
 *  com.google.android.gms.internal.ads.zzfuv
 *  com.google.android.gms.internal.ads.zzfuw
 *  com.google.android.gms.internal.ads.zzfxu
 *  com.google.android.gms.internal.ads.zzfxx
 *  com.google.android.gms.internal.ads.zzfya
 *  com.google.android.gms.internal.ads.zzgdl
 *  com.google.android.gms.internal.ads.zzgdu
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfts;
import com.google.android.gms.internal.ads.zzftt;
import com.google.android.gms.internal.ads.zzftu;
import com.google.android.gms.internal.ads.zzfuv;
import com.google.android.gms.internal.ads.zzfuw;
import com.google.android.gms.internal.ads.zzfxu;
import com.google.android.gms.internal.ads.zzfxx;
import com.google.android.gms.internal.ads.zzfya;
import com.google.android.gms.internal.ads.zzgdl;
import com.google.android.gms.internal.ads.zzgdu;
import java.security.GeneralSecurityException;

public final class zzfux
extends zzftu<zzfxu> {
    zzfux() {
        super(zzfxu.class, new zzftt[]{new zzfuv(zzgdl.class)});
    }

    static /* synthetic */ void zzk(zzfux zzfux2, zzfya zzfya2) throws GeneralSecurityException {
        zzfux.zzm(zzfya2);
    }

    public static final void zzl(zzfxu zzfxu2) throws GeneralSecurityException {
        zzgdu.zzb((int)zzfxu2.zza(), (int)0);
        zzgdu.zza((int)zzfxu2.zzd().zzc());
        zzfux.zzm(zzfxu2.zzc());
    }

    private static final void zzm(zzfya zzfya2) throws GeneralSecurityException {
        if (zzfya2.zza() < 12) throw new GeneralSecurityException("invalid IV size");
        if (zzfya2.zza() > 16) throw new GeneralSecurityException("invalid IV size");
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    public final zzfts<zzfxx, zzfxu> zzh() {
        return new zzfuw(this, zzfxx.class);
    }

    public final int zzi() {
        return 3;
    }
}
