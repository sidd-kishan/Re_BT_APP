/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcxg
 *  com.google.android.gms.internal.ads.zzcxl
 *  com.google.android.gms.internal.ads.zzcxm
 *  com.google.android.gms.internal.ads.zzeec
 *  com.google.android.gms.internal.ads.zzeed
 *  com.google.android.gms.internal.ads.zzegq
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcxg;
import com.google.android.gms.internal.ads.zzcxl;
import com.google.android.gms.internal.ads.zzcxm;
import com.google.android.gms.internal.ads.zzeec;
import com.google.android.gms.internal.ads.zzeed;
import com.google.android.gms.internal.ads.zzegq;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.Collections;
import java.util.List;

public final class zzcxn {
    public final List<? extends zzfsm<? extends zzcxg>> zza;

    public zzcxn(zzcxg zzcxg2) {
        this.zza = Collections.singletonList(zzfsd.zza((Object)zzcxg2));
    }

    public zzcxn(List<? extends zzfsm<? extends zzcxg>> list) {
        this.zza = list;
    }

    public static zzeec<zzcxn> zza(zzegq<? extends zzcxg> zzegq2) {
        return new zzeed(zzegq2, zzcxl.zza);
    }

    public static zzeec<zzcxn> zzb(zzeec<? extends zzcxg> zzeec2) {
        return new zzeed(zzeec2, zzcxm.zza);
    }
}
