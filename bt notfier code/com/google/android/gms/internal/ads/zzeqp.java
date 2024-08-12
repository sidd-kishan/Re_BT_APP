/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzeqq
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeqq;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;

public final class zzeqp
implements zzery<zzeqq> {
    private final String zza;
    private final String zzb;

    zzeqp(String string, String string2) {
        this.zza = string;
        this.zzb = string2;
    }

    public final zzfsm<zzeqq> zza() {
        return zzfsd.zza((Object)new zzeqq(this.zza, this.zzb));
    }
}
