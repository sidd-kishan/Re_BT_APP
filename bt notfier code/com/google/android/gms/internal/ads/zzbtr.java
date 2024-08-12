/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zzbe
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.ads.zzbsn
 *  com.google.android.gms.internal.ads.zzbtm
 *  com.google.android.gms.internal.ads.zzbtn
 *  com.google.android.gms.internal.ads.zzbto
 *  com.google.android.gms.internal.ads.zzbtq
 *  com.google.android.gms.internal.ads.zzchn
 *  com.google.android.gms.internal.ads.zzcho
 *  com.google.android.gms.internal.ads.zzchp
 *  com.google.android.gms.internal.ads.zzchs
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbe;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbsn;
import com.google.android.gms.internal.ads.zzbtm;
import com.google.android.gms.internal.ads.zzbtn;
import com.google.android.gms.internal.ads.zzbto;
import com.google.android.gms.internal.ads.zzbtq;
import com.google.android.gms.internal.ads.zzchn;
import com.google.android.gms.internal.ads.zzcho;
import com.google.android.gms.internal.ads.zzchp;
import com.google.android.gms.internal.ads.zzchs;

public final class zzbtr
extends zzchs<zzbsn> {
    private final Object zza = new Object();
    private final zzbe<zzbsn> zzb;
    private boolean zzc;
    private int zzd;

    public zzbtr(zzbe<zzbsn> zzbe2) {
        this.zzb = zzbe2;
        this.zzc = false;
        this.zzd = 0;
    }

    public final zzbtm zza() {
        zzbtm zzbtm2 = new zzbtm(this);
        Object object = this.zza;
        synchronized (object) {
            zzbtn zzbtn2 = new zzbtn(this, zzbtm2);
            zzbto zzbto2 = new zzbto(this, zzbtm2);
            this.zzf((zzchp)zzbtn2, (zzchn)zzbto2);
            boolean bl = this.zzd >= 0;
            Preconditions.checkState((boolean)bl);
            ++this.zzd;
            return zzbtm2;
        }
    }

    protected final void zzb() {
        Object object = this.zza;
        synchronized (object) {
            boolean bl = this.zzd > 0;
            Preconditions.checkState((boolean)bl);
            zze.zza((String)"Releasing 1 reference for JS Engine");
            --this.zzd;
            this.zzd();
            return;
        }
    }

    public final void zzc() {
        Object object = this.zza;
        synchronized (object) {
            boolean bl = this.zzd >= 0;
            Preconditions.checkState((boolean)bl);
            zze.zza((String)"Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.zzc = true;
            this.zzd();
            return;
        }
    }

    protected final void zzd() {
        Object object = this.zza;
        synchronized (object) {
            boolean bl = this.zzd >= 0;
            Preconditions.checkState((boolean)bl);
            if (this.zzc && this.zzd == 0) {
                zze.zza((String)"No reference is left (including root). Cleaning up engine.");
                zzbtq zzbtq2 = new zzbtq(this);
                zzcho zzcho2 = new zzcho();
                this.zzf((zzchp)zzbtq2, (zzchn)zzcho2);
            } else {
                zze.zza((String)"There are still references to the engine. Not destroying.");
            }
            return;
        }
    }
}
