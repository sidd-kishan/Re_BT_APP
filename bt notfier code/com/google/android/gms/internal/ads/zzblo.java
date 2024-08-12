/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 *  com.google.android.gms.internal.ads.zzblr
 *  com.google.android.gms.internal.ads.zzbly
 *  com.google.android.gms.internal.ads.zzbmh
 */
package com.google.android.gms.internal.ads;

import android.graphics.Color;
import com.google.android.gms.internal.ads.zzblr;
import com.google.android.gms.internal.ads.zzbly;
import com.google.android.gms.internal.ads.zzbmh;
import java.util.ArrayList;
import java.util.List;

public final class zzblo
extends zzbly {
    static final int zza;
    static final int zzb;
    private static final int zzc;
    private static final int zzd;
    private final String zze;
    private final List<zzblr> zzf = new ArrayList<zzblr>();
    private final List<zzbmh> zzg = new ArrayList<zzbmh>();
    private final int zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;

    static {
        int n;
        zzc = Color.rgb((int)12, (int)174, (int)206);
        zzd = n = Color.rgb((int)204, (int)204, (int)204);
        zza = n;
        zzb = zzc;
    }

    public zzblo(String string, List<zzblr> list, Integer n, Integer n2, Integer n3, int n4, int n5, boolean bl) {
        int n6;
        this.zze = string;
        for (n6 = 0; n6 < list.size(); ++n6) {
            string = list.get(n6);
            this.zzf.add((zzblr)string);
            this.zzg.add((zzbmh)string);
        }
        n6 = n != null ? n : zza;
        this.zzh = n6;
        n6 = n2 != null ? n2 : zzb;
        this.zzi = n6;
        n6 = n3 != null ? n3 : 12;
        this.zzj = n6;
        this.zzk = n4;
        this.zzl = n5;
    }

    public final String zzb() {
        return this.zze;
    }

    public final List<zzbmh> zzc() {
        return this.zzg;
    }

    public final List<zzblr> zzd() {
        return this.zzf;
    }

    public final int zze() {
        return this.zzh;
    }

    public final int zzf() {
        return this.zzi;
    }

    public final int zzg() {
        return this.zzj;
    }

    public final int zzh() {
        return this.zzk;
    }

    public final int zzi() {
        return this.zzl;
    }
}
