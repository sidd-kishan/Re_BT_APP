/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzbtt
 *  com.google.android.gms.internal.ads.zzfln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzbtt;
import com.google.android.gms.internal.ads.zzfln;

final class zzbuo
implements zzfln {
    private final String zza;
    private final zzbpr zzb;

    zzbuo(String string, zzbpr zzbpr2) {
        this.zza = string;
        this.zzb = zzbpr2;
    }

    public final Object apply(Object object) {
        String string = this.zza;
        zzbpr zzbpr2 = this.zzb;
        object = (zzbtt)object;
        object.zzm(string, zzbpr2);
        return object;
    }
}
