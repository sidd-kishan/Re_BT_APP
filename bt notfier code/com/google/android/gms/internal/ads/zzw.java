/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzadw
 *  com.google.android.gms.internal.ads.zzfoj
 *  com.google.android.gms.internal.ads.zzfot
 *  com.google.android.gms.internal.ads.zzu
 *  com.google.android.gms.internal.ads.zzv
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzadw;
import com.google.android.gms.internal.ads.zzfoj;
import com.google.android.gms.internal.ads.zzfot;
import com.google.android.gms.internal.ads.zzu;
import com.google.android.gms.internal.ads.zzv;

public class zzw {
    public static final zzw zza;
    @Deprecated
    public static final zzw zzb;
    public static final zzadw<zzw> zzz;
    public final int zzc = Integer.MAX_VALUE;
    public final int zzd = Integer.MAX_VALUE;
    public final int zze = Integer.MAX_VALUE;
    public final int zzf = Integer.MAX_VALUE;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final int zzj;
    public final int zzk;
    public final int zzl;
    public final boolean zzm;
    public final zzfoj<String> zzn;
    public final zzfoj<String> zzo;
    public final int zzp;
    public final int zzq;
    public final int zzr;
    public final zzfoj<String> zzs;
    public final zzfoj<String> zzt;
    public final int zzu;
    public final boolean zzv;
    public final boolean zzw;
    public final boolean zzx;
    public final zzfot<Integer> zzy;

    static {
        zzw zzw2;
        zza = zzw2 = new zzw(new zzv());
        zzb = zzw2;
        zzz = com.google.android.gms.internal.ads.zzu.zza;
    }

    protected zzw(zzv zzv2) {
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = 0;
        this.zzj = 0;
        this.zzk = com.google.android.gms.internal.ads.zzv.zza((zzv)zzv2);
        this.zzl = com.google.android.gms.internal.ads.zzv.zzb((zzv)zzv2);
        this.zzm = com.google.android.gms.internal.ads.zzv.zzc((zzv)zzv2);
        this.zzn = com.google.android.gms.internal.ads.zzv.zzd((zzv)zzv2);
        this.zzo = com.google.android.gms.internal.ads.zzv.zze((zzv)zzv2);
        this.zzp = 0;
        this.zzq = Integer.MAX_VALUE;
        this.zzr = Integer.MAX_VALUE;
        this.zzs = com.google.android.gms.internal.ads.zzv.zzf((zzv)zzv2);
        this.zzt = com.google.android.gms.internal.ads.zzv.zzg((zzv)zzv2);
        this.zzu = com.google.android.gms.internal.ads.zzv.zzh((zzv)zzv2);
        this.zzv = false;
        this.zzw = false;
        this.zzx = false;
        this.zzy = com.google.android.gms.internal.ads.zzv.zzi((zzv)zzv2);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzw)object;
        if (this.zzm != ((zzw)object).zzm) return false;
        if (this.zzk != ((zzw)object).zzk) return false;
        if (this.zzl != ((zzw)object).zzl) return false;
        if (!this.zzn.equals(((zzw)object).zzn)) return false;
        if (!this.zzo.equals(((zzw)object).zzo)) return false;
        if (!this.zzs.equals(((zzw)object).zzs)) return false;
        if (!this.zzt.equals(((zzw)object).zzt)) return false;
        if (this.zzu != ((zzw)object).zzu) return false;
        if (!this.zzy.equals(((zzw)object).zzy)) return false;
        return true;
    }

    public int hashCode() {
        return ((((((((((this.zzm - 1048002209) * 31 + this.zzk) * 31 + this.zzl) * 31 + this.zzn.hashCode()) * 31 + this.zzo.hashCode()) * 961 + Integer.MAX_VALUE) * 31 + Integer.MAX_VALUE) * 31 + this.zzs.hashCode()) * 31 + this.zzt.hashCode()) * 31 + this.zzu) * 923521 + this.zzy.hashCode();
    }
}
