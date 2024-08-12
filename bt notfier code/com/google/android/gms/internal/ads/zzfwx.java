/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftr
 *  com.google.android.gms.internal.ads.zzfts
 *  com.google.android.gms.internal.ads.zzftt
 *  com.google.android.gms.internal.ads.zzftu
 *  com.google.android.gms.internal.ads.zzfty
 *  com.google.android.gms.internal.ads.zzfwv
 *  com.google.android.gms.internal.ads.zzfww
 *  com.google.android.gms.internal.ads.zzgai
 *  com.google.android.gms.internal.ads.zzgak
 *  com.google.android.gms.internal.ads.zzgal
 *  com.google.android.gms.internal.ads.zzgan
 *  com.google.android.gms.internal.ads.zzgao
 *  com.google.android.gms.internal.ads.zzgdu
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftr;
import com.google.android.gms.internal.ads.zzfts;
import com.google.android.gms.internal.ads.zzftt;
import com.google.android.gms.internal.ads.zzftu;
import com.google.android.gms.internal.ads.zzfty;
import com.google.android.gms.internal.ads.zzfwv;
import com.google.android.gms.internal.ads.zzfww;
import com.google.android.gms.internal.ads.zzgai;
import com.google.android.gms.internal.ads.zzgak;
import com.google.android.gms.internal.ads.zzgal;
import com.google.android.gms.internal.ads.zzgan;
import com.google.android.gms.internal.ads.zzgao;
import com.google.android.gms.internal.ads.zzgdu;
import java.security.GeneralSecurityException;

public final class zzfwx
extends zzftu<zzgai> {
    public zzfwx() {
        super(zzgai.class, new zzftt[]{new zzfwv(zzfty.class)});
    }

    static /* synthetic */ void zzk(zzgao zzgao2) throws GeneralSecurityException {
        zzfwx.zzn(zzgao2);
    }

    public static final void zzl(zzgai zzgai2) throws GeneralSecurityException {
        zzgdu.zzb((int)zzgai2.zza(), (int)0);
        if (zzgai2.zzd().zzc() < 16) throw new GeneralSecurityException("key too short");
        zzfwx.zzn(zzgai2.zzc());
    }

    static /* synthetic */ zzftr<zzgal> zzm(int n, int n2, int n3, int n4) {
        zzgak zzgak2 = zzgal.zze();
        zzgan zzgan2 = zzgao.zzc();
        zzgan2.zzb(n3);
        zzgan2.zza(n2);
        zzgak2.zza((zzgao)zzgan2.zzah());
        zzgak2.zzb(n);
        return new zzftr((Object)((zzgal)zzgak2.zzah()), n4);
    }

    private static void zzn(zzgao zzgao2) throws GeneralSecurityException {
        if (zzgao2.zza() < 10) throw new GeneralSecurityException("tag size too small");
        int n = zzgao2.zzg() - 2;
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 4) {
                        if (n != 5) throw new GeneralSecurityException("unknown hash type");
                        if (zzgao2.zza() > 28) throw new GeneralSecurityException("tag size too big");
                    } else if (zzgao2.zza() > 64) throw new GeneralSecurityException("tag size too big");
                } else if (zzgao2.zza() > 32) throw new GeneralSecurityException("tag size too big");
            } else if (zzgao2.zza() > 48) throw new GeneralSecurityException("tag size too big");
        } else if (zzgao2.zza() > 20) throw new GeneralSecurityException("tag size too big");
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    public final zzfts<zzgal, zzgai> zzh() {
        return new zzfww(this, zzgal.class);
    }

    public final int zzi() {
        return 3;
    }

    public final int zzj() {
        return 2;
    }
}
