/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.ads.formats.AdManagerAdViewOptions
 *  com.google.android.gms.ads.formats.NativeAdOptions$Builder
 *  com.google.android.gms.ads.formats.PublisherAdViewOptions
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbdr
 *  com.google.android.gms.internal.ads.zzbfu
 *  com.google.android.gms.internal.ads.zzbfy
 *  com.google.android.gms.internal.ads.zzbis
 *  com.google.android.gms.internal.ads.zzblv
 *  com.google.android.gms.internal.ads.zzbny
 *  com.google.android.gms.internal.ads.zzbrx
 *  com.google.android.gms.internal.ads.zzeli
 *  com.google.android.gms.internal.ads.zzfah
 *  com.google.android.gms.internal.ads.zzfap
 *  com.google.android.gms.internal.ads.zzfaq
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbdr;
import com.google.android.gms.internal.ads.zzbfu;
import com.google.android.gms.internal.ads.zzbfy;
import com.google.android.gms.internal.ads.zzbis;
import com.google.android.gms.internal.ads.zzblv;
import com.google.android.gms.internal.ads.zzbny;
import com.google.android.gms.internal.ads.zzbrx;
import com.google.android.gms.internal.ads.zzeli;
import com.google.android.gms.internal.ads.zzfah;
import com.google.android.gms.internal.ads.zzfap;
import com.google.android.gms.internal.ads.zzfaq;
import java.util.ArrayList;
import java.util.List;

public final class zzfar {
    public final zzbis zza;
    public final zzbrx zzb;
    public final zzeli zzc;
    public final zzbdg zzd;
    public final zzbdl zze;
    public final String zzf;
    public final ArrayList<String> zzg;
    public final ArrayList<String> zzh;
    public final zzblv zzi;
    public final zzbdr zzj;
    public final int zzk;
    public final AdManagerAdViewOptions zzl;
    public final PublisherAdViewOptions zzm;
    public final zzbfu zzn;
    public final zzfah zzo;
    public final boolean zzp;
    public final zzbfy zzq;

    /* synthetic */ zzfar(zzfap zzfap2, zzfaq object) {
        boolean bl;
        this.zze = zzfap.zzb((zzfap)zzfap2);
        this.zzf = zzfap.zzc((zzfap)zzfap2);
        this.zzq = zzfap.zzN((zzfap)zzfap2);
        int n = zzfap.zza((zzfap)zzfap2).zza;
        long l = zzfap.zza((zzfap)zzfap2).zzb;
        object = zzfap.zza((zzfap)zzfap2).zzc;
        int n2 = zzfap.zza((zzfap)zzfap2).zzd;
        List list = zzfap.zza((zzfap)zzfap2).zze;
        boolean bl2 = zzfap.zza((zzfap)zzfap2).zzf;
        int n3 = zzfap.zza((zzfap)zzfap2).zzg;
        boolean bl3 = zzfap.zza((zzfap)zzfap2).zzh;
        boolean bl4 = bl = true;
        if (!bl3) {
            bl4 = zzfap.zze((zzfap)zzfap2) ? bl : false;
        }
        this.zzd = new zzbdg(n, l, (Bundle)object, n2, list, bl2, n3, bl4, zzfap.zza((zzfap)zzfap2).zzi, zzfap.zza((zzfap)zzfap2).zzj, zzfap.zza((zzfap)zzfap2).zzk, zzfap.zza((zzfap)zzfap2).zzl, zzfap.zza((zzfap)zzfap2).zzm, zzfap.zza((zzfap)zzfap2).zzn, zzfap.zza((zzfap)zzfap2).zzo, zzfap.zza((zzfap)zzfap2).zzp, zzfap.zza((zzfap)zzfap2).zzq, zzfap.zza((zzfap)zzfap2).zzr, zzfap.zza((zzfap)zzfap2).zzs, zzfap.zza((zzfap)zzfap2).zzt, zzfap.zza((zzfap)zzfap2).zzu, zzfap.zza((zzfap)zzfap2).zzv, zzs.zze((int)zzfap.zza((zzfap)zzfap2).zzw), zzfap.zza((zzfap)zzfap2).zzx);
        object = zzfap.zzd((zzfap)zzfap2) != null ? zzfap.zzd((zzfap)zzfap2) : (zzfap.zzh((zzfap)zzfap2) != null ? zzfap.zzh((zzfap)zzfap2).zzf : null);
        this.zza = object;
        this.zzg = zzfap.zzf((zzfap)zzfap2);
        this.zzh = zzfap.zzg((zzfap)zzfap2);
        object = zzfap.zzf((zzfap)zzfap2) == null ? null : (zzfap.zzh((zzfap)zzfap2) == null ? new zzblv(new NativeAdOptions.Builder().build()) : zzfap.zzh((zzfap)zzfap2));
        this.zzi = object;
        this.zzj = zzfap.zzi((zzfap)zzfap2);
        this.zzk = zzfap.zzm((zzfap)zzfap2);
        this.zzl = zzfap.zzj((zzfap)zzfap2);
        this.zzm = zzfap.zzk((zzfap)zzfap2);
        this.zzn = zzfap.zzl((zzfap)zzfap2);
        this.zzb = zzfap.zzn((zzfap)zzfap2);
        this.zzo = new zzfah(zzfap.zzo((zzfap)zzfap2), null);
        this.zzp = zzfap.zzp((zzfap)zzfap2);
        this.zzc = zzfap.zzq((zzfap)zzfap2);
    }

    public final zzbny zza() {
        PublisherAdViewOptions publisherAdViewOptions = this.zzm;
        if (publisherAdViewOptions == null) {
            if (this.zzl == null) return null;
        }
        if (publisherAdViewOptions == null) return this.zzl.zza();
        return publisherAdViewOptions.zzc();
    }
}
