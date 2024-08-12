/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.AdSize
 */
package com.google.android.gms.ads;

import com.google.android.gms.ads.AdSize;

public final class zza {
    public static AdSize zza(int n, int n2, String string) {
        return new AdSize(n, n2, string);
    }

    public static AdSize zzb(int n, int n2) {
        AdSize adSize = new AdSize(n, n2);
        adSize.zzc(true);
        adSize.zzd(n2);
        return adSize;
    }

    public static AdSize zzc(int n, int n2) {
        AdSize adSize = new AdSize(n, n2);
        adSize.zzg(true);
        adSize.zzi(n2);
        return adSize;
    }

    public static boolean zzd(AdSize adSize) {
        return adSize.zzf();
    }

    public static int zze(AdSize adSize) {
        return adSize.zzh();
    }

    public static boolean zzf(AdSize adSize) {
        return adSize.zza();
    }

    public static boolean zzg(AdSize adSize) {
        return adSize.zzb();
    }

    public static int zzh(AdSize adSize) {
        return adSize.zze();
    }
}
