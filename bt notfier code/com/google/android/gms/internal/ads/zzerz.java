/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzery
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzery;

final class zzerz
implements Runnable {
    private final zzery zza;
    private final long zzb;

    zzerz(zzery zzery2, long l) {
        this.zza = zzery2;
        this.zzb = l;
    }

    @Override
    public final void run() {
        Object object = this.zza;
        long l = this.zzb;
        String string = object.getClass().getCanonicalName();
        long l2 = zzt.zzj().elapsedRealtime();
        object = new StringBuilder(String.valueOf(string).length() + 40);
        ((StringBuilder)object).append("Signal runtime : ");
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append(" = ");
        ((StringBuilder)object).append(l2 - l);
        zze.zza((String)((StringBuilder)object).toString());
    }
}
