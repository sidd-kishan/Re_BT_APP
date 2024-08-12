/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzeou
 *  com.google.android.gms.internal.ads.zzeow
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzeou;
import com.google.android.gms.internal.ads.zzeow;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.concurrent.Callable;

public final class zzeov
implements zzery<zzeow> {
    private final Context zza;
    private final zzfsn zzb;

    public zzeov(Context context, zzfsn zzfsn2) {
        this.zza = context;
        this.zzb = zzfsn2;
    }

    public final zzfsm<zzeow> zza() {
        return this.zzb.zzb((Callable)new zzeou(this));
    }
}
