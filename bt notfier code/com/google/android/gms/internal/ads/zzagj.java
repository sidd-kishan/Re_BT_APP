/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.zzaga
 *  com.google.android.gms.internal.ads.zzagf
 *  com.google.android.gms.internal.ads.zzagi
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzaga;
import com.google.android.gms.internal.ads.zzagf;
import com.google.android.gms.internal.ads.zzagi;
import com.google.android.gms.internal.ads.zzamq;
import java.util.List;

public final class zzagj {
    public final Uri zza;
    public final String zzb;
    public final zzagf zzc;
    public final zzaga zzd;
    public final List zze;
    public final String zzf;
    public final List zzg;
    public final Object zzh;

    /* synthetic */ zzagj(Uri uri, String string, zzagf zzagf2, zzaga zzaga2, List list, String string2, List list2, Object object, zzagi zzagi2) {
        this.zza = uri;
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = list;
        this.zzf = null;
        this.zzg = list2;
        this.zzh = null;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzagj)) {
            return false;
        }
        object = (zzagj)object;
        if (!this.zza.equals((Object)((zzagj)object).zza)) return false;
        String string = ((zzagj)object).zzb;
        if (!zzamq.zzc(null, null)) return false;
        string = ((zzagj)object).zzc;
        if (!zzamq.zzc(null, null)) return false;
        string = ((zzagj)object).zzd;
        if (!zzamq.zzc(null, null)) return false;
        if (!this.zze.equals(((zzagj)object).zze)) return false;
        string = ((zzagj)object).zzf;
        if (!zzamq.zzc(null, null)) return false;
        if (!this.zzg.equals(((zzagj)object).zzg)) return false;
        object = ((zzagj)object).zzh;
        if (!zzamq.zzc(null, null)) return false;
        return true;
    }

    public final int hashCode() {
        return ((this.zza.hashCode() * 923521 + this.zze.hashCode()) * 961 + this.zzg.hashCode()) * 31;
    }
}
