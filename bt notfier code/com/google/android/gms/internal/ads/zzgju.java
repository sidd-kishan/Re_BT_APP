/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggj
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 *  com.google.android.gms.internal.ads.zzgjm
 *  com.google.android.gms.internal.ads.zzgjr
 *  com.google.android.gms.internal.ads.zzgjt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggj;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;
import com.google.android.gms.internal.ads.zzgjm;
import com.google.android.gms.internal.ads.zzgjr;
import com.google.android.gms.internal.ads.zzgjt;

public final class zzgju
extends zzgga<zzgju, zzgjr>
implements zzghj {
    private static final zzgju zzl;
    private int zzb;
    private zzgjt zze;
    private zzggj<zzgjm> zzf;
    private zzgex zzg;
    private zzgex zzh;
    private int zzi;
    private zzgex zzj;
    private byte zzk = (byte)2;

    static {
        zzgju zzgju2;
        zzl = zzgju2 = new zzgju();
        zzgga.zzay(zzgju.class, (zzgga)zzgju2);
    }

    private zzgju() {
        this.zzf = zzgju.zzaE();
        this.zzg = zzgex.zzb;
        this.zzh = zzgex.zzb;
        this.zzj = zzgex.zzb;
    }

    static /* synthetic */ zzgju zza() {
        return zzl;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return this.zzk;
        byte by = 1;
        if (n == 2) {
            return zzgju.zzaz((zzghi)zzl, (String)"\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001\u1009\u0000\u0002\u041b\u0003\u100a\u0001\u0004\u100a\u0002\u0005\u1004\u0003\u0006\u100a\u0004", (Object[])new Object[]{"zzb", "zze", "zzf", zzgjm.class, "zzg", "zzh", "zzi", "zzj"});
        }
        if (n == 3) return new zzgju();
        if (n == 4) return new zzgjr(null);
        if (n == 5) return zzl;
        if (object == null) {
            by = 0;
        }
        this.zzk = by;
        return null;
    }
}
