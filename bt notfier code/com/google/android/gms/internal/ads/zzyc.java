/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 *  com.google.android.gms.internal.ads.zzyb
 *  com.google.android.gms.internal.ads.zzye
 *  com.google.android.gms.internal.ads.zzyh
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;
import com.google.android.gms.internal.ads.zzyb;
import com.google.android.gms.internal.ads.zzye;
import com.google.android.gms.internal.ads.zzyh;

public final class zzyc
extends zzgga<zzyc, zzyb>
implements zzghj {
    private static final zzyc zzg;
    private int zzb;
    private zzye zze;
    private zzyh zzf;

    static {
        zzyc zzyc2;
        zzg = zzyc2 = new zzyc();
        zzgga.zzay(zzyc.class, (zzgga)zzyc2);
    }

    private zzyc() {
    }

    static /* synthetic */ zzyc zza() {
        return zzg;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzyc.zzaz((zzghi)zzg, (String)"\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u1009\u0000\u0002\u1009\u0001", (Object[])new Object[]{"zzb", "zze", "zzf"});
        if (n == 3) return new zzyc();
        if (n == 4) return new zzyb(null);
        if (n == 5) return zzg;
        return null;
    }
}
