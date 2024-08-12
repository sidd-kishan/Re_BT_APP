/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznv
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznv;
import java.io.IOException;

final class zzux {
    public final int zza;
    public final long zzb;

    private zzux(int n, long l) {
        this.zza = n;
        this.zzb = l;
    }

    public static zzux zza(zznv zznv2, zzamf zzamf2) throws IOException {
        byte[] byArray = zzamf2.zzi();
        ((zznp)zznv2).zzh(byArray, 0, 8, false);
        zzamf2.zzh(0);
        return new zzux(zzamf2.zzv(), zzamf2.zzu());
    }
}
