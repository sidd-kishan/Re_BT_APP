/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzayq
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzetf
 *  com.google.android.gms.internal.ads.zzeth
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzayq;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzetf;
import com.google.android.gms.internal.ads.zzeth;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.concurrent.Callable;

public final class zzetg
implements zzery<zzeth> {
    final zzfsn zza;
    final Context zzb;
    final zzayq zzc;

    public zzetg(zzayq zzayq2, zzfsn zzfsn2, Context context, byte[] byArray) {
        this.zzc = zzayq2;
        this.zza = zzfsn2;
        this.zzb = context;
    }

    public final zzfsm<zzeth> zza() {
        return this.zza.zzb((Callable)new zzetf(this));
    }
}
