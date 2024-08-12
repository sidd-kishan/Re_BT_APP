/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Looper
 *  com.google.android.gms.internal.ads.zzadx
 *  com.google.android.gms.internal.ads.zzadz
 *  com.google.android.gms.internal.ads.zzaea
 *  com.google.android.gms.internal.ads.zzafy
 *  com.google.android.gms.internal.ads.zzahy
 *  com.google.android.gms.internal.ads.zzahz
 *  com.google.android.gms.internal.ads.zzaie
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzaku
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzcy
 *  com.google.android.gms.internal.ads.zzg
 *  com.google.android.gms.internal.ads.zzgt
 *  com.google.android.gms.internal.ads.zzhq
 *  com.google.android.gms.internal.ads.zzjt
 *  com.google.android.gms.internal.ads.zzjz
 *  com.google.android.gms.internal.ads.zzki
 *  com.google.android.gms.internal.ads.zzkr
 *  com.google.android.gms.internal.ads.zznq
 *  com.google.android.gms.internal.ads.zzoa
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.internal.ads.zzadx;
import com.google.android.gms.internal.ads.zzadz;
import com.google.android.gms.internal.ads.zzaea;
import com.google.android.gms.internal.ads.zzafy;
import com.google.android.gms.internal.ads.zzahy;
import com.google.android.gms.internal.ads.zzahz;
import com.google.android.gms.internal.ads.zzaie;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzaku;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzcy;
import com.google.android.gms.internal.ads.zzg;
import com.google.android.gms.internal.ads.zzgt;
import com.google.android.gms.internal.ads.zzhq;
import com.google.android.gms.internal.ads.zzjt;
import com.google.android.gms.internal.ads.zzjz;
import com.google.android.gms.internal.ads.zzki;
import com.google.android.gms.internal.ads.zzkr;
import com.google.android.gms.internal.ads.zznq;
import com.google.android.gms.internal.ads.zzoa;

@Deprecated
public final class zzaia {
    private final Context zza;
    private final zzahy zzb;
    private final zzaku zzc;
    private zzjz zzd;
    private final zzhq zze;
    private zzafy zzf;
    private final zzki zzg;
    private final zzcy zzh;
    private final Looper zzi;
    private final zzg zzj;
    private final zzahz zzk;
    private boolean zzl;
    private final zzadz zzm;

    @Deprecated
    public zzaia(Context context, zzahy zzahy2) {
        zznq zznq2 = new zznq();
        zzjt zzjt2 = new zzjt(context);
        zzgt zzgt2 = new zzgt(context, (zzoa)zznq2);
        zznq2 = new zzaea();
        zzkr zzkr2 = zzkr.zzg((Context)context);
        zzcy zzcy2 = new zzcy(zzaku.zza);
        this.zza = context;
        this.zzb = zzahy2;
        this.zzd = zzjt2;
        this.zze = zzgt2;
        this.zzf = zznq2;
        this.zzg = zzkr2;
        this.zzh = zzcy2;
        this.zzi = zzamq.zzk();
        this.zzj = com.google.android.gms.internal.ads.zzg.zza;
        this.zzk = zzahz.zze;
        this.zzm = new zzadz(0.97f, 1.03f, 1000L, 1.0E-7f, zzadx.zzb((long)20L), zzadx.zzb((long)500L), 0.999f, null);
        this.zzc = zzaku.zza;
    }

    static /* synthetic */ Context zza(zzaia zzaia2) {
        return zzaia2.zza;
    }

    static /* synthetic */ zzahy zzb(zzaia zzaia2) {
        return zzaia2.zzb;
    }

    static /* synthetic */ zzaku zzc(zzaia zzaia2) {
        return zzaia2.zzc;
    }

    static /* synthetic */ zzjz zzd(zzaia zzaia2) {
        return zzaia2.zzd;
    }

    static /* synthetic */ zzhq zze(zzaia zzaia2) {
        return zzaia2.zze;
    }

    static /* synthetic */ zzafy zzf(zzaia zzaia2) {
        return zzaia2.zzf;
    }

    static /* synthetic */ zzki zzg(zzaia zzaia2) {
        return zzaia2.zzg;
    }

    static /* synthetic */ zzcy zzh(zzaia zzaia2) {
        return zzaia2.zzh;
    }

    static /* synthetic */ Looper zzi(zzaia zzaia2) {
        return zzaia2.zzi;
    }

    static /* synthetic */ zzg zzj(zzaia zzaia2) {
        return zzaia2.zzj;
    }

    static /* synthetic */ zzahz zzk(zzaia zzaia2) {
        return zzaia2.zzk;
    }

    static /* synthetic */ zzadz zzo(zzaia zzaia2) {
        return zzaia2.zzm;
    }

    @Deprecated
    public final zzaia zzl(zzjz zzjz2) {
        zzakt.zzd((boolean)(this.zzl ^ true));
        this.zzd = zzjz2;
        return this;
    }

    @Deprecated
    public final zzaia zzm(zzafy zzafy2) {
        zzakt.zzd((boolean)(this.zzl ^ true));
        this.zzf = zzafy2;
        return this;
    }

    @Deprecated
    public final zzaie zzn() {
        zzakt.zzd((boolean)(this.zzl ^ true));
        this.zzl = true;
        return new zzaie(this);
    }
}
