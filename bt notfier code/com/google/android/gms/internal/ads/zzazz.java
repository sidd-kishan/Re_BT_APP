/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzazx
 *  com.google.android.gms.internal.ads.zzazy
 *  com.google.android.gms.internal.ads.zzbbt
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzazx;
import com.google.android.gms.internal.ads.zzazy;
import com.google.android.gms.internal.ads.zzbbt;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzazz
extends zzgga<zzazz, zzazy>
implements zzghj {
    private static final zzazz zzg;
    private int zzb;
    private int zze;
    private zzbbt zzf;

    static {
        zzazz zzazz2;
        zzg = zzazz2 = new zzazz();
        zzgga.zzay(zzazz.class, (zzgga)zzazz2);
    }

    private zzazz() {
    }

    static /* synthetic */ zzazz zza() {
        return zzg;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzazz();
            if (n == 4) return new zzazy(null);
            if (n == 5) return zzg;
            return null;
        }
        object = zzazx.zzc();
        return zzazz.zzaz((zzghi)zzg, (String)"\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u1009\u0001", (Object[])new Object[]{"zzb", "zze", object, "zzf"});
    }
}
