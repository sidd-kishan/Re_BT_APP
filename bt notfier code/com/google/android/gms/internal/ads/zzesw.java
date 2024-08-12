/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzcbl
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzesv
 *  com.google.android.gms.internal.ads.zzesx
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcbl;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzesv;
import com.google.android.gms.internal.ads.zzesx;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.concurrent.Callable;

public final class zzesw
implements zzery<zzesx> {
    private final Context zza;
    private final String zzb;
    private final zzfsn zzc;

    public zzesw(zzcbl zzcbl2, Context context, String string, zzfsn zzfsn2) {
        this.zza = context;
        this.zzb = string;
        this.zzc = zzfsn2;
    }

    public final zzfsm<zzesx> zza() {
        return this.zzc.zzb((Callable)new zzesv(this));
    }
}
