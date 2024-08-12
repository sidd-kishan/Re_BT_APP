/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzftg
 *  com.google.android.gms.internal.ads.zzftr
 *  com.google.android.gms.internal.ads.zzfts
 *  com.google.android.gms.internal.ads.zzftt
 *  com.google.android.gms.internal.ads.zzftu
 *  com.google.android.gms.internal.ads.zzfus
 *  com.google.android.gms.internal.ads.zzfut
 *  com.google.android.gms.internal.ads.zzfxo
 *  com.google.android.gms.internal.ads.zzfxr
 *  com.google.android.gms.internal.ads.zzfxw
 *  com.google.android.gms.internal.ads.zzfxx
 *  com.google.android.gms.internal.ads.zzfxz
 *  com.google.android.gms.internal.ads.zzfya
 *  com.google.android.gms.internal.ads.zzgal
 *  com.google.android.gms.internal.ads.zzgan
 *  com.google.android.gms.internal.ads.zzgao
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzftg;
import com.google.android.gms.internal.ads.zzftr;
import com.google.android.gms.internal.ads.zzfts;
import com.google.android.gms.internal.ads.zzftt;
import com.google.android.gms.internal.ads.zzftu;
import com.google.android.gms.internal.ads.zzfus;
import com.google.android.gms.internal.ads.zzfut;
import com.google.android.gms.internal.ads.zzfxo;
import com.google.android.gms.internal.ads.zzfxr;
import com.google.android.gms.internal.ads.zzfxw;
import com.google.android.gms.internal.ads.zzfxx;
import com.google.android.gms.internal.ads.zzfxz;
import com.google.android.gms.internal.ads.zzfya;
import com.google.android.gms.internal.ads.zzgal;
import com.google.android.gms.internal.ads.zzgan;
import com.google.android.gms.internal.ads.zzgao;

public final class zzfuu
extends zzftu<zzfxo> {
    zzfuu() {
        super(zzfxo.class, new zzftt[]{new zzfus(zzftg.class)});
    }

    static /* synthetic */ zzftr<zzfxr> zzk(int n, int n2, int n3, int n4, int n5, int n6) {
        zzfxw zzfxw2 = zzfxx.zze();
        zzfxz zzfxz2 = zzfya.zzc();
        zzfxz2.zza(16);
        zzfxw2.zza((zzfya)zzfxz2.zzah());
        zzfxw2.zzb(n);
        zzfxz2 = (zzfxx)zzfxw2.zzah();
        zzfxw2 = zzgal.zze();
        zzgan zzgan2 = zzgao.zzc();
        zzgan2.zzb(5);
        zzgan2.zza(n4);
        zzfxw2.zza((zzgao)zzgan2.zzah());
        zzfxw2.zzb(32);
        zzfxw2 = (zzgal)zzfxw2.zzah();
        zzgan2 = zzfxr.zze();
        zzgan2.zza((zzfxx)zzfxz2);
        zzgan2.zzb((zzgal)zzfxw2);
        return new zzftr((Object)((zzfxr)zzgan2.zzah()), n6);
    }

    public final String zzb() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    public final zzfts<zzfxr, zzfxo> zzh() {
        return new zzfut(this, zzfxr.class);
    }

    public final int zzi() {
        return 3;
    }

    public final int zzj() {
        return 2;
    }
}
