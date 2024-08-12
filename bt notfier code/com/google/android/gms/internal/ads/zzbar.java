/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbam
 *  com.google.android.gms.internal.ads.zzbaq
 *  com.google.android.gms.internal.ads.zzbbx
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggf
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbam;
import com.google.android.gms.internal.ads.zzbaq;
import com.google.android.gms.internal.ads.zzbbx;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggf;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzbar
extends zzgga<zzbar, zzbaq>
implements zzghj {
    private static final zzbar zzi;
    private int zzb;
    private String zze = "";
    private int zzf;
    private zzggf zzg = zzbar.zzaB();
    private zzbbx zzh;

    static {
        zzbar zzbar2;
        zzi = zzbar2 = new zzbar();
        zzgga.zzay(zzbar.class, (zzgga)zzbar2);
    }

    private zzbar() {
    }

    static /* synthetic */ zzbar zza() {
        return zzi;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzbar();
            if (n == 4) return new zzbaq(null);
            if (n == 5) return zzi;
            return null;
        }
        object = zzbam.zza;
        return zzbar.zzaz((zzghi)zzi, (String)"\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u1008\u0000\u0002\u100c\u0001\u0003\u0016\u0004\u1009\u0002", (Object[])new Object[]{"zzb", "zze", "zzf", object, "zzg", "zzh"});
    }
}
