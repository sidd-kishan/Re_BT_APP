/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zzb
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzcjb
 *  com.google.android.gms.internal.ads.zzckq
 *  com.google.android.gms.internal.ads.zzckr
 *  com.google.android.gms.internal.ads.zzcla
 *  com.google.android.gms.internal.ads.zzclj
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzcjb;
import com.google.android.gms.internal.ads.zzckq;
import com.google.android.gms.internal.ads.zzckr;
import com.google.android.gms.internal.ads.zzcla;
import com.google.android.gms.internal.ads.zzclj;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.Callable;

public final class zzcks
extends zzb {
    final zzcjb zza;
    final zzcla zzb;
    private final String zzc;
    private final String[] zzd;

    zzcks(zzcjb zzcjb2, zzcla zzcla2, String string, String[] stringArray) {
        this.zza = zzcjb2;
        this.zzb = zzcla2;
        this.zzc = string;
        this.zzd = stringArray;
        zzt.zzy().zzc(this);
    }

    public final void zza() {
        try {
            this.zzb.zze(this.zzc, this.zzd);
            return;
        }
        finally {
            zzs.zza.post((Runnable)new zzckr(this));
        }
    }

    public final zzfsm<?> zzc() {
        zzbjd zzbjd2 = zzbjl.zzbo;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return super.zzc();
        if (!(this.zzb instanceof zzclj)) return super.zzc();
        return zzchg.zze.zzb((Callable)new zzckq(this));
    }

    public final String zzd() {
        return this.zzc;
    }

    final /* synthetic */ Boolean zze() throws Exception {
        return this.zzb.zzf(this.zzc, this.zzd, this);
    }
}
