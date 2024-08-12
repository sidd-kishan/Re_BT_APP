/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzdbw
 *  com.google.android.gms.internal.ads.zzddb
 *  com.google.android.gms.internal.ads.zzddk
 *  com.google.android.gms.internal.ads.zzddn
 *  com.google.android.gms.internal.ads.zzdgl
 *  com.google.android.gms.internal.ads.zzdgm
 *  com.google.android.gms.internal.ads.zzdih
 *  com.google.android.gms.internal.ads.zzezz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzdbw;
import com.google.android.gms.internal.ads.zzddb;
import com.google.android.gms.internal.ads.zzddk;
import com.google.android.gms.internal.ads.zzddn;
import com.google.android.gms.internal.ads.zzdgl;
import com.google.android.gms.internal.ads.zzdgm;
import com.google.android.gms.internal.ads.zzdih;
import com.google.android.gms.internal.ads.zzezz;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzddl
extends zzdgm<zzddn>
implements zzdbw,
zzddb {
    private final zzezz zzb;
    private final AtomicBoolean zzc = new AtomicBoolean();

    public zzddl(Set<zzdih<zzddn>> set, zzezz zzezz2) {
        super(set);
        this.zzb = zzezz2;
    }

    private final void zzb() {
        zzbjd zzbjd2 = zzbjl.zzfA;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return;
        if (!this.zzc.compareAndSet(false, true)) return;
        zzbjd2 = this.zzb.zzab;
        if (zzbjd2 == null) return;
        if (zzbjd2.zza != 3) return;
        this.zzk((zzdgl)new zzddk(this));
    }

    public final void zzR() {
        if (this.zzb.zzb != 1) return;
        this.zzb();
    }

    final /* synthetic */ void zza(zzddn zzddn2) throws Exception {
        zzddn2.zzo(this.zzb.zzab);
    }

    public final void zzg() {
        int n = this.zzb.zzb;
        if (n != 2 && n != 5 && n != 4 && n != 6) {
            if (n != 7) return;
        }
        this.zzb();
    }
}
