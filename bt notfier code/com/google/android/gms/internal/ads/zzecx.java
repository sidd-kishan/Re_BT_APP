/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzecu
 *  com.google.android.gms.internal.ads.zzfem
 *  com.google.android.gms.internal.ads.zzfet
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzecu;
import com.google.android.gms.internal.ads.zzfem;
import com.google.android.gms.internal.ads.zzfet;

public final class zzecx
implements zzfet {
    private final zzecu zza;

    zzecx(zzecu zzecu2) {
        this.zza = zzecu2;
    }

    public final void zzbE(zzfem zzfem2, String string) {
    }

    public final void zzbF(zzfem zzfem2, String string) {
        string = zzbjl.zzex;
        if ((Boolean)zzbet.zzc().zzc((zzbjd)string) == false) return;
        if (zzfem.zzd != zzfem2) return;
        this.zza.zze(zzt.zzj().elapsedRealtime());
    }

    public final void zzc(zzfem zzfem2, String string, Throwable throwable) {
        string = zzbjl.zzex;
        if ((Boolean)zzbet.zzc().zzc((zzbjd)string) == false) return;
        if (zzfem.zzd != zzfem2) return;
        if (this.zza.zzf() == 0L) return;
        this.zza.zzg(zzt.zzj().elapsedRealtime() - this.zza.zzf());
    }

    public final void zzd(zzfem zzfem2, String string) {
        string = zzbjl.zzex;
        if ((Boolean)zzbet.zzc().zzc((zzbjd)string) == false) return;
        if (zzfem.zzd != zzfem2) return;
        if (this.zza.zzf() == 0L) return;
        this.zza.zzg(zzt.zzj().elapsedRealtime() - this.zza.zzf());
    }
}
