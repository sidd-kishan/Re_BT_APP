/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.collection.SimpleArrayMap
 *  com.google.android.gms.internal.ads.zzbnf
 *  com.google.android.gms.internal.ads.zzbni
 *  com.google.android.gms.internal.ads.zzbnl
 *  com.google.android.gms.internal.ads.zzbno
 *  com.google.android.gms.internal.ads.zzbns
 *  com.google.android.gms.internal.ads.zzbnv
 *  com.google.android.gms.internal.ads.zzbsg
 *  com.google.android.gms.internal.ads.zzdmv
 *  com.google.android.gms.internal.ads.zzdmw
 */
package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;
import com.google.android.gms.internal.ads.zzbnf;
import com.google.android.gms.internal.ads.zzbni;
import com.google.android.gms.internal.ads.zzbnl;
import com.google.android.gms.internal.ads.zzbno;
import com.google.android.gms.internal.ads.zzbns;
import com.google.android.gms.internal.ads.zzbnv;
import com.google.android.gms.internal.ads.zzbsg;
import com.google.android.gms.internal.ads.zzdmv;
import com.google.android.gms.internal.ads.zzdmw;
import java.util.ArrayList;

public final class zzdmx {
    public static final zzdmx zza = new zzdmx(new zzdmv());
    private final zzbni zzb;
    private final zzbnf zzc;
    private final zzbnv zzd;
    private final zzbns zze;
    private final zzbsg zzf;
    private final SimpleArrayMap<String, zzbno> zzg;
    private final SimpleArrayMap<String, zzbnl> zzh;

    private zzdmx(zzdmv zzdmv2) {
        this.zzb = zzdmv2.zza;
        this.zzc = zzdmv2.zzb;
        this.zzd = zzdmv2.zzc;
        this.zzg = new SimpleArrayMap(zzdmv2.zzf);
        this.zzh = new SimpleArrayMap(zzdmv2.zzg);
        this.zze = zzdmv2.zzd;
        this.zzf = zzdmv2.zze;
    }

    /* synthetic */ zzdmx(zzdmv zzdmv2, zzdmw zzdmw2) {
        this(zzdmv2);
    }

    public final zzbni zza() {
        return this.zzb;
    }

    public final zzbnf zzb() {
        return this.zzc;
    }

    public final zzbnv zzc() {
        return this.zzd;
    }

    public final zzbns zzd() {
        return this.zze;
    }

    public final zzbsg zze() {
        return this.zzf;
    }

    public final zzbno zzf(String string) {
        return (zzbno)this.zzg.get((Object)string);
    }

    public final zzbnl zzg(String string) {
        return (zzbnl)this.zzh.get((Object)string);
    }

    public final ArrayList<String> zzh() {
        ArrayList<String> arrayList = new ArrayList<String>();
        if (this.zzd != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.zzb != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.zzc != null) {
            arrayList.add(Integer.toString(2));
        }
        if (this.zzg.size() > 0) {
            arrayList.add(Integer.toString(3));
        }
        if (this.zzf == null) return arrayList;
        arrayList.add(Integer.toString(7));
        return arrayList;
    }

    public final ArrayList<String> zzi() {
        ArrayList<String> arrayList = new ArrayList<String>(this.zzg.size());
        int n = 0;
        while (n < this.zzg.size()) {
            arrayList.add((String)this.zzg.keyAt(n));
            ++n;
        }
        return arrayList;
    }
}
