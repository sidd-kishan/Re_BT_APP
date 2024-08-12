/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 *  com.google.android.gms.internal.ads.zzyg
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;
import com.google.android.gms.internal.ads.zzyg;

public final class zzyh
extends zzgga<zzyh, zzyg>
implements zzghj {
    private static final zzyh zzk;
    private int zzb;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";

    static {
        zzyh zzyh2;
        zzk = zzyh2 = new zzyh();
        zzgga.zzay(zzyh.class, (zzgga)zzyh2);
    }

    private zzyh() {
    }

    static /* synthetic */ zzyh zza() {
        return zzk;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzyh.zzaz((zzghi)zzk, (String)"\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u1008\u0000\u0002\u1008\u0001\u0003\u1008\u0002\u0004\u1008\u0003\u0005\u1008\u0004\u0006\u1008\u0005", (Object[])new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        if (n == 3) return new zzyh();
        if (n == 4) return new zzyg(null);
        if (n == 5) return zzk;
        return null;
    }
}
