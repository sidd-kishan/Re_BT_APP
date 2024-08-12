/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzapw
 *  com.google.android.gms.internal.ads.zzapx
 *  com.google.android.gms.internal.ads.zzaqs
 *  com.google.android.gms.internal.ads.zzarc
 *  com.google.android.gms.internal.ads.zzard
 *  com.google.android.gms.internal.ads.zzare
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzapw;
import com.google.android.gms.internal.ads.zzapx;
import com.google.android.gms.internal.ads.zzaqs;
import com.google.android.gms.internal.ads.zzarc;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzare;

final class zzaqv {
    public final zzare zza = new zzare();
    public final zzapx zzb;
    public zzarc zzc;
    public zzaqs zzd;
    public int zze;
    public int zzf;
    public int zzg;
    public zzapw zzh;
    public zzard zzi;

    public zzaqv(zzapx zzapx2) {
        this.zzb = zzapx2;
    }

    public final void zza(zzarc zzarc2, zzaqs zzaqs2) {
        if (zzarc2 == null) throw null;
        this.zzc = zzarc2;
        if (zzaqs2 == null) throw null;
        this.zzd = zzaqs2;
        this.zzb.zza(zzarc2.zzf);
        this.zzb();
    }

    public final void zzb() {
        zzare zzare2 = this.zza;
        zzare2.zzd = 0;
        zzare2.zzr = 0L;
        zzare2.zzl = false;
        zzare2.zzq = false;
        zzare2.zzn = null;
        this.zze = 0;
        this.zzg = 0;
        this.zzf = 0;
        this.zzh = null;
        this.zzi = null;
    }
}
