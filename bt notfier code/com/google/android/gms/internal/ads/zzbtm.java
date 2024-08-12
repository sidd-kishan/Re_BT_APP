/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbtj
 *  com.google.android.gms.internal.ads.zzbtk
 *  com.google.android.gms.internal.ads.zzbtl
 *  com.google.android.gms.internal.ads.zzbtr
 *  com.google.android.gms.internal.ads.zzbtt
 *  com.google.android.gms.internal.ads.zzchn
 *  com.google.android.gms.internal.ads.zzcho
 *  com.google.android.gms.internal.ads.zzchp
 *  com.google.android.gms.internal.ads.zzchs
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbtj;
import com.google.android.gms.internal.ads.zzbtk;
import com.google.android.gms.internal.ads.zzbtl;
import com.google.android.gms.internal.ads.zzbtr;
import com.google.android.gms.internal.ads.zzbtt;
import com.google.android.gms.internal.ads.zzchn;
import com.google.android.gms.internal.ads.zzcho;
import com.google.android.gms.internal.ads.zzchp;
import com.google.android.gms.internal.ads.zzchs;

public final class zzbtm
extends zzchs<zzbtt> {
    private final Object zza = new Object();
    private final zzbtr zzb;
    private boolean zzc;

    public zzbtm(zzbtr zzbtr2) {
        this.zzb = zzbtr2;
    }

    static /* synthetic */ zzbtr zza(zzbtm zzbtm2) {
        return zzbtm2.zzb;
    }

    public final void zzb() {
        Object object = this.zza;
        synchronized (object) {
            if (this.zzc) {
                return;
            }
            this.zzc = true;
            zzbtj zzbtj2 = new zzbtj(this);
            zzcho zzcho2 = new zzcho();
            this.zzf((zzchp)zzbtj2, (zzchn)zzcho2);
            zzbtj2 = new zzbtk(this);
            zzcho2 = new zzbtl(this);
            this.zzf((zzchp)zzbtj2, (zzchn)zzcho2);
            return;
        }
    }
}
