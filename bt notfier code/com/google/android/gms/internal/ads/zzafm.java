/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzahd
 *  com.google.android.gms.internal.ads.zzakt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzahd;
import com.google.android.gms.internal.ads.zzakt;

public final class zzafm {
    public zzahd zza;
    public int zzb;
    public boolean zzc;
    public int zzd;
    public boolean zze;
    public int zzf;
    private boolean zzg;

    public zzafm(zzahd zzahd2) {
        this.zza = zzahd2;
    }

    static /* synthetic */ boolean zza(zzafm zzafm2) {
        return zzafm2.zzg;
    }

    public final void zzb(int n) {
        int n2 = this.zzg;
        boolean bl = true;
        if (1 != (n2 | n)) {
            bl = false;
        }
        this.zzg = bl;
        this.zzb += n;
    }

    public final void zzc(zzahd zzahd2) {
        boolean bl = this.zzg;
        boolean bl2 = this.zza != zzahd2;
        this.zzg = bl | bl2;
        this.zza = zzahd2;
    }

    public final void zzd(int n) {
        boolean bl = this.zzc;
        boolean bl2 = true;
        if (bl && this.zzd != 5) {
            if (n != 5) {
                bl2 = false;
            }
            zzakt.zza((boolean)bl2);
            return;
        }
        this.zzg = true;
        this.zzc = true;
        this.zzd = n;
    }

    public final void zze(int n) {
        this.zzg = true;
        this.zze = true;
        this.zzf = n;
    }
}
