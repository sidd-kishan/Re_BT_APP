/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzagb
 *  com.google.android.gms.internal.ads.zzagk
 *  com.google.android.gms.internal.ads.zzaiq
 *  com.google.android.gms.internal.ads.zzay
 *  com.google.android.gms.internal.ads.zzfpj
 *  com.google.android.gms.internal.ads.zzfpr
 *  com.google.android.gms.internal.ads.zzgm
 *  com.google.android.gms.internal.ads.zzgq
 *  com.google.android.gms.internal.ads.zzgs
 *  com.google.android.gms.internal.ads.zzhe
 *  com.google.android.gms.internal.ads.zzhf
 *  com.google.android.gms.internal.ads.zzhh
 *  com.google.android.gms.internal.ads.zzht
 *  com.google.android.gms.internal.ads.zzhu
 *  com.google.android.gms.internal.ads.zzko
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzagb;
import com.google.android.gms.internal.ads.zzagk;
import com.google.android.gms.internal.ads.zzaiq;
import com.google.android.gms.internal.ads.zzay;
import com.google.android.gms.internal.ads.zzfpj;
import com.google.android.gms.internal.ads.zzfpr;
import com.google.android.gms.internal.ads.zzgm;
import com.google.android.gms.internal.ads.zzgq;
import com.google.android.gms.internal.ads.zzgs;
import com.google.android.gms.internal.ads.zzhe;
import com.google.android.gms.internal.ads.zzhf;
import com.google.android.gms.internal.ads.zzhh;
import com.google.android.gms.internal.ads.zzht;
import com.google.android.gms.internal.ads.zzhu;
import com.google.android.gms.internal.ads.zzko;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzhv
extends zzgq<Integer> {
    private static final zzagk zza;
    private final zzhh[] zzb;
    private final zzaiq[] zzc;
    private final ArrayList<zzhh> zzd;
    private final Map<Object, Long> zze;
    private final zzfpj<Object, zzgm> zzf;
    private int zzg;
    private long[][] zzh;
    private zzhu zzi;
    private final zzgs zzj;

    static {
        zzagb zzagb2 = new zzagb();
        zzagb2.zza("MergingMediaSource");
        zza = zzagb2.zzc();
    }

    public zzhv(boolean bl, boolean bl2, zzhh ... zzhhArray) {
        zzgs zzgs2 = new zzgs();
        this.zzb = zzhhArray;
        this.zzj = zzgs2;
        this.zzd = new ArrayList<zzhh>(Arrays.asList(zzhhArray));
        this.zzg = -1;
        this.zzc = new zzaiq[zzhhArray.length];
        this.zzh = new long[0][];
        this.zze = new HashMap<Object, Long>();
        this.zzf = zzfpr.zzb((int)8).zzb(2).zza();
    }

    public final void zzA(zzhe zzhhArray) {
        zzht zzht2 = (zzht)zzhhArray;
        int n = 0;
        while (n < (zzhhArray = this.zzb).length) {
            zzhhArray[n].zzA(zzht2.zza(n));
            ++n;
        }
    }

    public final zzhe zzC(zzhf zzhf2, zzko zzko2, long l) {
        int n = this.zzb.length;
        zzhe[] zzheArray = new zzhe[n];
        zzhf zzhf3 = this.zzc;
        int n2 = 0;
        int n3 = zzhf3[0].zzi(zzhf2.zza);
        while (n2 < n) {
            zzhf3 = zzhf2.zzc(this.zzc[n2].zzj(n3));
            zzheArray[n2] = this.zzb[n2].zzC(zzhf3, zzko2, l - this.zzh[n3][n2]);
            ++n2;
        }
        return new zzht(this.zzj, this.zzh[n3], zzheArray, null);
    }

    protected final void zza(zzay zzay2) {
        super.zza(zzay2);
        int n = 0;
        while (n < this.zzb.length) {
            this.zzw(n, this.zzb[n]);
            ++n;
        }
    }

    protected final void zzd() {
        super.zzd();
        Arrays.fill(this.zzc, null);
        this.zzg = -1;
        this.zzi = null;
        this.zzd.clear();
        Collections.addAll(this.zzd, this.zzb);
    }

    public final void zzu() throws IOException {
        zzhu zzhu2 = this.zzi;
        if (zzhu2 != null) throw zzhu2;
        super.zzu();
    }

    public final zzagk zzz() {
        zzagk zzagk2 = this.zzb;
        zzagk2 = ((zzhh[])zzagk2).length > 0 ? zzagk2[0].zzz() : zza;
        return zzagk2;
    }
}
