/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbai
 *  com.google.android.gms.internal.ads.zzbaj
 *  com.google.android.gms.internal.ads.zzbbz
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbai;
import com.google.android.gms.internal.ads.zzbaj;
import com.google.android.gms.internal.ads.zzbbz;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzbak
extends zzgga<zzbak, zzbai>
implements zzghj {
    private static final zzbak zzi;
    private int zzb;
    private int zze;
    private zzbbz zzf;
    private String zzg = "";
    private String zzh = "";

    static {
        zzbak zzbak2;
        zzi = zzbak2 = new zzbak();
        zzgga.zzay(zzbak.class, (zzgga)zzbak2);
    }

    private zzbak() {
    }

    static /* synthetic */ zzbak zza() {
        return zzi;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzbak();
            if (n == 4) return new zzbai(null);
            if (n == 5) return zzi;
            return null;
        }
        object = zzbaj.zza;
        return zzbak.zzaz((zzghi)zzi, (String)"\u0001\u0004\u0000\u0001\u0005\b\u0004\u0000\u0000\u0000\u0005\u100c\u0000\u0006\u1009\u0001\u0007\u1008\u0002\b\u1008\u0003", (Object[])new Object[]{"zzb", "zze", object, "zzf", "zzg", "zzh"});
    }
}
