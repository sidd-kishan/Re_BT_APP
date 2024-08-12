/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftk
 *  com.google.android.gms.internal.ads.zzftp
 *  com.google.android.gms.internal.ads.zzftr
 *  com.google.android.gms.internal.ads.zzfts
 *  com.google.android.gms.internal.ads.zzftt
 *  com.google.android.gms.internal.ads.zzfug
 *  com.google.android.gms.internal.ads.zzfwe
 *  com.google.android.gms.internal.ads.zzfwf
 *  com.google.android.gms.internal.ads.zzfzm
 *  com.google.android.gms.internal.ads.zzfzo
 *  com.google.android.gms.internal.ads.zzfzp
 *  com.google.android.gms.internal.ads.zzfzs
 *  com.google.android.gms.internal.ads.zzfzv
 *  com.google.android.gms.internal.ads.zzfzy
 *  com.google.android.gms.internal.ads.zzgaa
 *  com.google.android.gms.internal.ads.zzgab
 *  com.google.android.gms.internal.ads.zzgau
 *  com.google.android.gms.internal.ads.zzgex
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftk;
import com.google.android.gms.internal.ads.zzftp;
import com.google.android.gms.internal.ads.zzftr;
import com.google.android.gms.internal.ads.zzfts;
import com.google.android.gms.internal.ads.zzftt;
import com.google.android.gms.internal.ads.zzfug;
import com.google.android.gms.internal.ads.zzfwe;
import com.google.android.gms.internal.ads.zzfwf;
import com.google.android.gms.internal.ads.zzfzm;
import com.google.android.gms.internal.ads.zzfzo;
import com.google.android.gms.internal.ads.zzfzp;
import com.google.android.gms.internal.ads.zzfzs;
import com.google.android.gms.internal.ads.zzfzv;
import com.google.android.gms.internal.ads.zzfzy;
import com.google.android.gms.internal.ads.zzgaa;
import com.google.android.gms.internal.ads.zzgab;
import com.google.android.gms.internal.ads.zzgau;
import com.google.android.gms.internal.ads.zzgex;

public final class zzfwg
extends zzfug<zzfzv, zzfzy> {
    private static final byte[] zza = new byte[0];

    zzfwg() {
        super(zzfzv.class, zzfzy.class, new zzftt[]{new zzfwe(zzftk.class)});
    }

    static /* synthetic */ byte[] zzk() {
        return zza;
    }

    static /* synthetic */ zzftr<zzfzp> zzl(int n, int n2, int n3, zzftp zzftp2, byte[] object, int n4) {
        zzfzo zzfzo2 = zzfzp.zzd();
        zzgaa zzgaa2 = zzgab.zzc();
        n = 4;
        zzgaa2.zzb(4);
        zzgaa2.zzc(5);
        zzgaa2.zza(zzgex.zzt((byte[])object));
        object = (zzgab)zzgaa2.zzah();
        zzgaa2 = zzgau.zzd();
        zzgaa2.zza(zzftp2.zza());
        zzgaa2.zzb(zzgex.zzt((byte[])zzftp2.zzb()));
        n2 = zzftp2.zzd() - 1;
        if (n2 != 0) {
            if (n2 != 1) {
                n = n2 != 2 ? 6 : 5;
            }
        } else {
            n = 3;
        }
        zzgaa2.zzc(n);
        zzgaa2 = (zzgau)zzgaa2.zzah();
        zzftp2 = zzfzm.zzc();
        zzftp2.zza((zzgau)zzgaa2);
        zzftp2 = (zzfzm)zzftp2.zzah();
        zzgaa2 = zzfzs.zzd();
        zzgaa2.zza((zzgab)object);
        zzgaa2.zzb((zzfzm)zzftp2);
        zzgaa2.zzc(n3);
        zzfzo2.zza((zzfzs)zzgaa2.zzah());
        return new zzftr((Object)((zzfzp)zzfzo2.zzah()), n4);
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    public final zzfts<zzfzp, zzfzv> zzh() {
        return new zzfwf(this, zzfzp.class);
    }

    public final int zzi() {
        return 4;
    }
}
