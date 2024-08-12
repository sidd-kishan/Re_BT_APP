/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 *  com.google.android.gms.internal.ads.zzzh
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;
import com.google.android.gms.internal.ads.zzzh;

public final class zzzi
extends zzgga<zzzi, zzzh>
implements zzghj {
    private static final zzzi zzh;
    private int zzb;
    private long zze;
    private String zzf = "";
    private zzgex zzg = zzgex.zzb;

    static {
        zzzi zzzi2;
        zzh = zzzi2 = new zzzi();
        zzgga.zzay(zzzi.class, (zzgga)zzzi2);
    }

    private zzzi() {
    }

    public static zzzi zzd() {
        return zzh;
    }

    static /* synthetic */ zzzi zze() {
        return zzh;
    }

    public final boolean zza() {
        if ((this.zzb & 1) == 0) return false;
        return true;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzzi.zzaz((zzghi)zzh, (String)"\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001\u1002\u0000\u0003\u1008\u0001\u0004\u100a\u0002", (Object[])new Object[]{"zzb", "zze", "zzf", "zzg"});
        if (n == 3) return new zzzi();
        if (n == 4) return new zzzh(null);
        if (n == 5) return zzh;
        return null;
    }

    public final long zzc() {
        return this.zze;
    }
}
