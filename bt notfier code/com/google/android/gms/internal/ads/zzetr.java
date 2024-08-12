/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbiw
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzetq
 *  com.google.android.gms.internal.ads.zzets
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbiw;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzetq;
import com.google.android.gms.internal.ads.zzets;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.List;
import java.util.concurrent.Callable;

public final class zzetr
implements zzery<zzets> {
    final zzfsn zza;
    final List<String> zzb;
    final zzbiw zzc;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public zzetr(zzbiw zzbiw2, zzfsn zzfsn2, List list, byte[] byArray) {
        this.zzc = zzbiw2;
        this.zza = zzfsn2;
        this.zzb = list;
    }

    public final zzfsm<zzets> zza() {
        return this.zza.zzb((Callable)new zzetq(this));
    }
}
