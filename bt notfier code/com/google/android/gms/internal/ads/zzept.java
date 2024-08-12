/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzeps
 *  com.google.android.gms.internal.ads.zzepu
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzezy
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeps;
import com.google.android.gms.internal.ads.zzepu;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzezy;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.concurrent.Callable;

public final class zzept
implements zzery<zzepu> {
    private final zzfsn zza;
    private final zzezy zzb;

    public zzept(zzfsn zzfsn2, zzezy zzezy2) {
        this.zza = zzfsn2;
        this.zzb = zzezy2;
    }

    public final zzfsm<zzepu> zza() {
        return this.zza.zzb((Callable)new zzeps(this));
    }

    final /* synthetic */ zzepu zzb() throws Exception {
        return new zzepu(this.zzb);
    }
}
