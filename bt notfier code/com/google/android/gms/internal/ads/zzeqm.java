/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzeql
 *  com.google.android.gms.internal.ads.zzeqn
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzeql;
import com.google.android.gms.internal.ads.zzeqn;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.concurrent.Callable;

public final class zzeqm
implements zzery<zzeqn> {
    private final zzfsn zza;
    private final Bundle zzb;

    public zzeqm(zzfsn zzfsn2, Bundle bundle) {
        this.zza = zzfsn2;
        this.zzb = bundle;
    }

    public final zzfsm<zzeqn> zza() {
        return this.zza.zzb((Callable)new zzeql(this));
    }

    final /* synthetic */ zzeqn zzb() throws Exception {
        return new zzeqn(this.zzb);
    }
}
