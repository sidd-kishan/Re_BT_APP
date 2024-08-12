/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfts
 *  com.google.android.gms.internal.ads.zzftt
 *  com.google.android.gms.internal.ads.zzftu
 *  com.google.android.gms.internal.ads.zzfty
 *  com.google.android.gms.internal.ads.zzfws
 *  com.google.android.gms.internal.ads.zzfwt
 *  com.google.android.gms.internal.ads.zzfxf
 *  com.google.android.gms.internal.ads.zzfxi
 *  com.google.android.gms.internal.ads.zzfxl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfts;
import com.google.android.gms.internal.ads.zzftt;
import com.google.android.gms.internal.ads.zzftu;
import com.google.android.gms.internal.ads.zzfty;
import com.google.android.gms.internal.ads.zzfws;
import com.google.android.gms.internal.ads.zzfwt;
import com.google.android.gms.internal.ads.zzfxf;
import com.google.android.gms.internal.ads.zzfxi;
import com.google.android.gms.internal.ads.zzfxl;
import java.security.GeneralSecurityException;

public final class zzfwu
extends zzftu<zzfxf> {
    zzfwu() {
        super(zzfxf.class, new zzftt[]{new zzfws(zzfty.class)});
    }

    static /* synthetic */ void zzk(zzfxl zzfxl2) throws GeneralSecurityException {
        zzfwu.zzm(zzfxl2);
    }

    static /* synthetic */ void zzl(int n) throws GeneralSecurityException {
        zzfwu.zzn(n);
    }

    private static void zzm(zzfxl zzfxl2) throws GeneralSecurityException {
        if (zzfxl2.zza() < 10) throw new GeneralSecurityException("tag size too short");
        if (zzfxl2.zza() > 16) throw new GeneralSecurityException("tag size too long");
    }

    private static void zzn(int n) throws GeneralSecurityException {
        if (n != 32) throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    public final zzfts<zzfxi, zzfxf> zzh() {
        return new zzfwt(this, zzfxi.class);
    }

    public final int zzi() {
        return 3;
    }
}
