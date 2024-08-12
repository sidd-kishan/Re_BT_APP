/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  com.google.android.gms.internal.ads.zzfgg
 *  com.google.android.gms.internal.ads.zzfgn
 *  com.google.android.gms.internal.ads.zzfgo
 *  com.google.android.gms.internal.ads.zzfgp
 *  com.google.android.gms.internal.ads.zzfgq
 *  com.google.android.gms.internal.ads.zzfgr
 *  com.google.android.gms.internal.ads.zzfgt
 *  com.google.android.gms.internal.ads.zzfhu
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.internal.ads.zzfgg;
import com.google.android.gms.internal.ads.zzfgn;
import com.google.android.gms.internal.ads.zzfgo;
import com.google.android.gms.internal.ads.zzfgp;
import com.google.android.gms.internal.ads.zzfgq;
import com.google.android.gms.internal.ads.zzfgr;
import com.google.android.gms.internal.ads.zzfgt;
import com.google.android.gms.internal.ads.zzfhu;
import java.util.Iterator;

public final class zzfgy {
    private static zzfgy zza;
    private float zzb = 0.0f;
    private final zzfgq zzc;
    private final zzfgo zzd;
    private zzfgp zze;
    private zzfgr zzf;

    public zzfgy(zzfgq zzfgq2, zzfgo zzfgo2) {
        this.zzc = zzfgq2;
        this.zzd = zzfgo2;
    }

    public static zzfgy zza() {
        if (zza != null) return zza;
        zzfgo zzfgo2 = new zzfgo();
        zza = new zzfgy(new zzfgq(), zzfgo2);
        return zza;
    }

    public final void zzb(Context context) {
        zzfgn zzfgn2 = new zzfgn();
        this.zze = new zzfgp(new Handler(), context, zzfgn2, this, null);
    }

    public final void zzc() {
        zzfgt.zza().zzg(this);
        zzfgt.zza().zzc();
        if (zzfgt.zza().zze()) {
            zzfhu.zzf().zzg();
        }
        this.zze.zza();
    }

    public final void zzd() {
        zzfhu.zzf().zzh();
        zzfgt.zza().zzd();
        this.zze.zzb();
    }

    public final void zze(float f) {
        this.zzb = f;
        if (this.zzf == null) {
            this.zzf = zzfgr.zza();
        }
        Iterator iterator = this.zzf.zzf().iterator();
        while (iterator.hasNext()) {
            ((zzfgg)iterator.next()).zzg().zzj(f);
        }
    }

    public final float zzf() {
        return this.zzb;
    }
}
