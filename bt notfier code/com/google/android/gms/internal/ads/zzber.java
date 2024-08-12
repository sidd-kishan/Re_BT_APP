/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbdd
 *  com.google.android.gms.internal.ads.zzbdf
 *  com.google.android.gms.internal.ads.zzbep
 *  com.google.android.gms.internal.ads.zzbhx
 *  com.google.android.gms.internal.ads.zzbog
 *  com.google.android.gms.internal.ads.zzboh
 *  com.google.android.gms.internal.ads.zzbzn
 *  com.google.android.gms.internal.ads.zzcde
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzcgz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbdd;
import com.google.android.gms.internal.ads.zzbdf;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzbhx;
import com.google.android.gms.internal.ads.zzbog;
import com.google.android.gms.internal.ads.zzboh;
import com.google.android.gms.internal.ads.zzbzn;
import com.google.android.gms.internal.ads.zzcde;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcgz;
import java.util.Random;

public final class zzber {
    private static final zzber zza = new zzber();
    private final zzcgm zzb;
    private final zzbep zzc;
    private final String zzd;
    private final zzcgz zze;
    private final Random zzf;

    protected zzber() {
        zzcgm zzcgm2 = new zzcgm();
        zzbep zzbep2 = new zzbep(new zzbdf(), new zzbdd(), new zzbhx(), new zzbog(), new zzcde(), new zzbzn(), new zzboh());
        String string = zzcgm.zzf();
        zzcgz zzcgz2 = new zzcgz(0, 213806000, true, false, false);
        Random random = new Random();
        this.zzb = zzcgm2;
        this.zzc = zzbep2;
        this.zzd = string;
        this.zze = zzcgz2;
        this.zzf = random;
    }

    public static zzcgm zza() {
        return zzber.zza.zzb;
    }

    public static zzbep zzb() {
        return zzber.zza.zzc;
    }

    public static String zzc() {
        return zzber.zza.zzd;
    }

    public static zzcgz zzd() {
        return zzber.zza.zze;
    }

    public static Random zze() {
        return zzber.zza.zzf;
    }
}
